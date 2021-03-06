package jp.gr.java_conf.ko_aoki.common.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jp.gr.java_conf.ko_aoki.common.entity.CodeDeptBean;
import jp.gr.java_conf.ko_aoki.common.util.DateUtil;
import org.apache.commons.lang.StringUtils;

/**
 * 部門entityを操作するrepositoryクラス.
 * @author ko-aoki
 */
public class MstDeptRepositoryImpl implements MstDeptRepository{

    @PersistenceContext(name = "common-app-javaee7PU")
    private EntityManager em;

    /**
     * 親部門、子部門の階層関係を取得します（カウントのみ）.
     * @param params
     * @return 
     */
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

    /**
     * ページ検索での範囲内で、親部門、子部門の階層関係を取得します.
     * @param params
     * @param startNum
     * @param endNum
     * @return 
     */
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
        if (StringUtils.isNotEmpty(pDeptId )) {
            nQuery.setParameter("pDeptId", pDeptId + "%");
        }
        if (StringUtils.isNotEmpty(pDeptNm)) {
            nQuery.setParameter("pDeptNm", pDeptNm + "%");
        }
        if (StringUtils.isNotEmpty(deptId)) {
            nQuery.setParameter("deptId", deptId + "%");
        }
        if (StringUtils.isNotEmpty(deptNm)) {
            nQuery.setParameter("deptNm", deptNm + "%");
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
        
        if (StringUtils.isNotEmpty(pDeptId)) {
            query += 
            " AND"
            + " A.DEPT_ID LIKE ?pDeptId";
           
        }
        if (StringUtils.isNotEmpty(pDeptNm)) {
            query += 
            " AND"
            + " A.DEPT_NM LIKE ?pDeptNm";            
        }
        if (StringUtils.isNotEmpty(deptId)) {
            query += 
            " AND"
            + " B.DEPT_ID LIKE ?deptId";
            
        }
        if (StringUtils.isNotEmpty(deptNm)) {
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

        if (StringUtils.isNotEmpty(pDeptId)) {
            query += 
            " AND"
            + " DEPT_ID LIKE ?pDeptId";
           
        }
        if (StringUtils.isNotEmpty(pDeptNm)) {
            query += 
            " AND"
            + " DEPT_NM LIKE ?pDeptNm";            
        }
        
        return query;
        
    }
    
}
