/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.gr.java_conf.ko_aoki.common.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import jp.gr.java_conf.ko_aoki.common.base.PageBuilder;
import jp.gr.java_conf.ko_aoki.common.base.bean.PageBean;
import jp.gr.java_conf.ko_aoki.common.entity.CodeDeptBean;
import jp.gr.java_conf.ko_aoki.common.form.CodeDeptForm;
import jp.gr.java_conf.ko_aoki.common.repository.MstDeptRepository;

/**
 *
 * @author admin
 */
public class CodeDeptServiceImple implements CodeDeptService{

    @Inject
    private MstDeptRepository mstDeptRep;

    /**
     * Creates a new instance of MenuService
     */
    public CodeDeptServiceImple() {
    }

    public CodeDeptForm getDepts(Map<String, String> param, int curPage){

        BigDecimal cnt = mstDeptRep.countLevel1to2DeptList(param);

        //ページ込みで明細取得
        PageBean page = new PageBean();
        if (curPage < 1) {
            curPage = 1;
        }
        page.setCurPage(curPage);
        //ページ込みで明細取得
        PageBuilder pb = new PageBuilder();
        page = pb.build(curPage, 5, cnt.intValue(), 3);
        CodeDeptForm form = new CodeDeptForm();
        List<CodeDeptBean> recs = mstDeptRep.selectLevel1to2DeptList(param, page.getStartNum(), page.getEndNum());
        form.setRecs(recs);
        form.setPageInfo(page);
        form.setResult("ok");
        
        return form;
    }
}
