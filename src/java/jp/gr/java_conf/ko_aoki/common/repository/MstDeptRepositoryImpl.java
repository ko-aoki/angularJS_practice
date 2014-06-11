/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.gr.java_conf.ko_aoki.common.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jp.gr.java_conf.ko_aoki.common.entity.CodeDeptBean;
import jp.gr.java_conf.ko_aoki.common.util.DateUtil;

/**
 *
 * @author admin
 */
public class MstDeptRepositoryImpl implements MstDeptRepository{

    @PersistenceContext(name = "common-app-javaee7PU")
    private EntityManager em;

    @Override
    public BigDecimal countLevel1to2DeptList(Map<String, String> params) {

        String preQuery
                = " SELECT"
                + " count(*) as cnt"
                + " FROM"
                + " (";
	String query = createQueryString(params);
        query = preQuery + query + ")";
        Query nQuery = em.createNativeQuery(query);
        fillParam(nQuery, params);
        return (BigDecimal)nQuery.getSingleResult();

    }

    @Override
    public List<CodeDeptBean> selectLevel1to2DeptList(Map<String, String> params, int startNum, int endNum) {

        String preQuery
                = " SELECT"
                + " DEPT_ID_1 as pDeptID,"
                + " DEPT_NM_1 as pDeptNm,"
                + " DEPT_ID_2 as deptId,"
                + " DEPT_NM_2 as deptNm"
                + " FROM"
                + " ("
                + " SELECT  ROW_NUMBER() OVER (ORDER BY DEPT_ID_1,DEPT_ID_2) RNO, A.* FROM"
                + " (";

        String postQuery
                = " ) A"
                + " )"
                + " WHERE RNO BETWEEN ?startNum AND ?endNum"
                + " ORDER BY DEPT_ID_1,DEPT_ID_2";

                
	String query = preQuery + createQueryString(params) + postQuery;
        Query nQuery = em.createNativeQuery(query, CodeDeptBean.class);
        fillParam(nQuery, params);
        nQuery.setParameter("startNum", startNum);
        nQuery.setParameter("endNum", endNum);
        
        return nQuery.getResultList();
    }

    private void fillParam(Query nQuery, Map<String, String> params) {
        String pDeptId = params.get("pDeptId");
        String pDeptNm =params.get("pDeptNm");
        String deptId = params.get("deptId");
        String deptNm =params.get("deptNm");

        nQuery.setParameter("targetDate", DateUtil.getFormatCurDateString());
        if (pDeptId != null) {
            nQuery.setParameter("pDeptId", pDeptId);
        }
        if (pDeptNm != null) {
            nQuery.setParameter("pDeptNm", pDeptNm);
        }
        if (deptId != null) {
            nQuery.setParameter("deptId", deptId);
        }
        if (deptNm != null) {
            nQuery.setParameter("deptNm", deptNm);
        }
    }

    private String createQueryString(Map<String, String> params) {
        String pDeptId = params.get("pDeptId");
        String pDeptNm =params.get("pDeptNm");
        String deptId = params.get("deptId");
        String deptNm =params.get("deptNm");

	String query = 
          " SELECT A.DEPT_ID AS DEPT_ID_1, A.DEPT_NM AS DEPT_NM_1 ,B.DEPT_ID AS DEPT_ID_2, B.DEPT_NM AS DEPT_NM_2"
	+ " FROM MST_DEPT A, MST_DEPT B"
	+ " WHERE"
	+ " A.DEPT_ID = B.P_DEPT_ID"
	+ " AND"
	+ " (A.P_DEPT_ID = '9999')"
	+ " AND"
	+ " A.START_DATE <= ?targetDate AND"
	+ " A.END_DATE >= ?targetDate AND"
	+ " B.START_DATE <= ?targetDate AND"
	+ " B.END_DATE >= ?targetDate";
        
        if (pDeptId != null) {
            query += 
            " AND"
            + " A.DEPT_ID LIKE ?pDeptId?";
           
        }
        if (pDeptNm != null) {
            query += 
            " AND"
            + " A.DEPT_NM LIKE ?pDeptNm";            
        }
        if (deptId != null) {
            query += 
            " AND"
            + " B.DEPT_ID LIKE ?deptId}";
            
        }
        if (deptNm != null) {
            query += 
            " AND"
            + " B.DEPT_NM LIKE ?deptNm";
        }
        query +=
	" UNION ALL"
	+ " SELECT '' AS DEPT_ID_1, '' AS DEPT_NM_1 ,DEPT_ID AS DEPT_ID_2, DEPT_NM AS DEPT_NM_2"
	+ " FROM MST_DEPT"
	+ " WHERE"
	+ " P_DEPT_ID = '9999'"
	+ " AND"
	+ " START_DATE <= ?targetDate AND"
	+ " END_DATE <= ?targetDate";

        if (pDeptId != null) {
            query += 
            " AND"
            + " A.DEPT_ID LIKE ?pDeptId";
           
        }
        if (pDeptNm != null) {
            query += 
            " AND"
            + " A.DEPT_NM LIKE ?pDeptNm";            
        }
        
        return query;
        
    }
    
}
