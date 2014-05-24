/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.gr.java_conf.ko_aoki.common.service;

import java.util.Arrays;
import javax.inject.Inject;
import jp.gr.java_conf.ko_aoki.common.entity.MstUser;
import jp.gr.java_conf.ko_aoki.common.form.MntMstUserForm;
import jp.gr.java_conf.ko_aoki.common.form.MntMstUserRegForm;
import jp.gr.java_conf.ko_aoki.common.repository.MstRoleRepository;
import jp.gr.java_conf.ko_aoki.common.repository.MstUserRepository;

/**
 *
 * @author admin
 */
public class MntMstUserServiceImple implements MntMstUserService{

    @Inject
    private MstUserRepository mstUserRep;

    @Inject
    private MstRoleRepository mstRoleRep;

    /**
     * Creates a new instance of MenuService
     */
    public MntMstUserServiceImple() {
    }

    public MntMstUserForm getUsers(String userNm, String deptId1, String deptId2, String roleId) {        

        MntMstUserForm form = new MntMstUserForm();
        form.setRecs(mstUserRep.find(userNm, deptId1, deptId2, roleId));
        form.setRoles(mstRoleRep.findAll());
        form.setResult("ok");
        
        return form;
    }

    public MntMstUserRegForm getUser(String mstUserId ) {


        MntMstUserRegForm form = new MntMstUserRegForm();
        MstUser user = mstUserRep.find(mstUserId);
        if (user == null) {
            throw new RuntimeException("データが存在しません　ユーザID：" + mstUserId);
        } else {
            form.setRec(user);
            form.setRoles(mstRoleRep.findAll());
            form.setResult("ok");
        }
        return form;
    }

    public MntMstUserRegForm confirm(MntMstUserRegForm form) {
        form.setResult("OK");
        return form;
    }

    public MntMstUserRegForm updateUser(String mstUserId, MntMstUserRegForm form) {
        mstUserRep.update(form.getRec());
        form.setMessages(Arrays.asList("データを更新しました。"));
        return form;
    }

}
