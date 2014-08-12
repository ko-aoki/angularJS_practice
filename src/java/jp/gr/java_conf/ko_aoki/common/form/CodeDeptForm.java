package jp.gr.java_conf.ko_aoki.common.form;

import java.util.List;
import jp.gr.java_conf.ko_aoki.common.base.bean.PageBean;
import jp.gr.java_conf.ko_aoki.common.entity.CodeDeptBean;

/**
 * 部門コード検索画面のformクラス.
 * @author ko-aoki
 */
public class CodeDeptForm extends BaseForm{
	/** ページ情報 */
	private PageBean pageInfo;
	/** 親部門ID */
	private String pDeptId;
	/** 親部門名称 */
	private String pDeptNm;
	/** 部門ID */
	private String deptId;
	/** 部門名称 */
	private String deptNm;
	/** 明細 */
	private List<CodeDeptBean> recs;

    /**
     * @return the pDeptId
     */
    public String getpDeptId() {
        return pDeptId;
    }

    /**
     * @param pDeptId the pDeptId to set
     */
    public void setpDeptId(String pDeptId) {
        this.pDeptId = pDeptId;
    }

    /**
     * @return the pDeptNm
     */
    public String getpDeptNm() {
        return pDeptNm;
    }

    /**
     * @param pDeptNm the pDeptNm to set
     */
    public void setpDeptNm(String pDeptNm) {
        this.pDeptNm = pDeptNm;
    }

    /**
     * @return the deptId
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * @param deptId the deptId to set
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    /**
     * @return the deptNm
     */
    public String getDeptNm() {
        return deptNm;
    }

    /**
     * @param deptNm the deptNm to set
     */
    public void setDeptNm(String deptNm) {
        this.deptNm = deptNm;
    }

    /**
     * @return the recs
     */
    public List<CodeDeptBean> getRecs() {
        return recs;
    }

    /**
     * @param recs the recs to set
     */
    public void setRecs(List<CodeDeptBean> recs) {
        this.recs = recs;
    }

    /**
     * @return the pageInfo
     */
    public PageBean getPageInfo() {
        return pageInfo;
    }

    /**
     * @param pageInfo the page to set
     */
    public void setPageInfo(PageBean pageInfo) {
        this.pageInfo = pageInfo;
    }

}
