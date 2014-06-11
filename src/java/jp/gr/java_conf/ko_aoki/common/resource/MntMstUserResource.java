/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.gr.java_conf.ko_aoki.common.resource;

import java.util.Arrays;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import jp.gr.java_conf.ko_aoki.common.form.MntMstUserForm;
import jp.gr.java_conf.ko_aoki.common.form.MntMstUserRegForm;
import jp.gr.java_conf.ko_aoki.common.service.MntMstUserService;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("mntMstUser")
public class MntMstUserResource {

    @Inject
    private MntMstUserService mntMstUserService;

    /**
     * Creates a new instance of MenuService
     */
    public MntMstUserResource() {
    }

    @GET
    @Path("{userNm: .*},{deptId1: .*},{deptId2: .*},{roleId: .*}")
    @Produces("application/json")
    public MntMstUserForm getUsers(
            @PathParam("userNm") String userNm,
            @PathParam("deptId1") String deptId1,
            @PathParam("deptId2") String deptId2,
            @PathParam("roleId") String roleId) {
        MntMstUserForm form = mntMstUserService.getUsers(userNm, deptId1, deptId2, roleId);
        return form;
    }

    @GET
    @Path("{mstUserId: .*}")
    @Produces("application/json")
    public MntMstUserRegForm getUser(
            @PathParam("mstUserId") String mstUserId
    ) {
        MntMstUserRegForm form = mntMstUserService.getUser(mstUserId);
        return form;
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public MntMstUserRegForm confirm(MntMstUserRegForm form) {
        MntMstUserRegForm rtnForm = mntMstUserService.confirm(form);
        return rtnForm;
    }

    @PUT
    @Path("{mstUserId: .*}")
    @Consumes("application/json")
    @Produces("application/json")
    public MntMstUserRegForm putUser(
            @PathParam("mstUserId") String mstUserId,
            MntMstUserRegForm form
    ) {

        mntMstUserService.updateUser(mstUserId, form);
        form.setMessages(Arrays.asList("データを更新しました。"));
        return form;
    }
}
