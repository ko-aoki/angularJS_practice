package jp.gr.java_conf.ko_aoki.common.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CodeDeptBean implements Serializable {

	/** 親部門ID */
	private String pDeptId;
	/** 親部門名称 */
	private String pDeptNm;
	/** 部門ID */
        @Id
	private String deptId;
	/** 部門名称 */
	private String deptNm;

	/**
	 * 親部門IDを取得します。
	 * @return 親部門ID
	 */
	public String getpDeptId() {
	    return pDeptId;
	}
	/**
	 * 親部門IDを設定します。
	 * @param pDeptId 親部門ID
	 */
	public void setpDeptId(String pDeptId) {
	    this.pDeptId = pDeptId;
	}
	/**
	 * 親部門名称を取得します。
	 * @return 親部門名称
	 */
	public String getpDeptNm() {
	    return pDeptNm;
	}
	/**
	 * 親部門名称を設定します。
	 * @param pDeptNm 親部門名称
	 */
	public void setpDeptNm(String pDeptNm) {
	    this.pDeptNm = pDeptNm;
	}
	/**
	 * 部門IDを取得します。
	 * @return 部門ID
	 */
	public String getDeptId() {
	    return deptId;
	}
	/**
	 * 部門IDを設定します。
	 * @param deptId 部門ID
	 */
	public void setDeptId(String deptId) {
	    this.deptId = deptId;
	}
	/**
	 * 部門名称を取得します。
	 * @return 部門名称
	 */
	public String getDeptNm() {
	    return deptNm;
	}
	/**
	 * 部門名称を設定します。
	 * @param deptNm 部門名称
	 */
	public void setDeptNm(String deptNm) {
	    this.deptNm = deptNm;
	}
}
