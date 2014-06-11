
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.gr.java_conf.ko_aoki.common.resource;

import java.util.HashMap;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import jp.gr.java_conf.ko_aoki.common.form.CodeDeptForm;
import jp.gr.java_conf.ko_aoki.common.service.CodeDeptService;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("codeDept")
public class CodeDeptResource {

    @Inject
    private CodeDeptService codeDeptService;

    /**
     * Creates a new instance of MenuService
     */
    public CodeDeptResource() {
    }

    @POST
//    @Path("{pDeptId: .*},{pDeptNm: .*},{deptId: .*},{deptNm: .*}")
    @Consumes("application/json")
    @Produces("application/json")
    public CodeDeptForm getDepts(CodeDeptForm form) {
        HashMap<String, String> param = new HashMap<>();
        param.put("pDeptId", form.getpDeptId());
        param.put("pDeptNm", form.getpDeptNm());
        param.put("deptId", form.getDeptId());
        param.put("deptNm", form.getDeptNm());
        int curPage = form.getPageInfo() != null ? form.getPageInfo().getRequestPage() : 0;
        CodeDeptForm rtnForm = codeDeptService.getDepts(param, curPage);
        return rtnForm;
    }

}
