package jp.gr.java_conf.ko_aoki.common.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import jp.gr.java_conf.ko_aoki.common.entity.MstUser;
import org.apache.commons.lang.StringUtils;

/**
 * ユーザentityを操作するrepositoryクラス.
 * @author ko-aoki
 */
public class MstUserRepositoryImpl implements MstUserRepository{

    @PersistenceContext(name = "common-app-javaee7PU")
    private EntityManager em;

    /**
     * 一意キーでユーザを検索します.
     * @param mstUserId
     * @return 
     */
    @Override
    public MstUser find(String mstUserId) {
        MstUser user = em.find(MstUser.class, Long.valueOf(mstUserId));
        return user;

    }

    /**
     * ユーザIDでユーザを検索します.
     * @param userId
     * @return 
     */
    @Override
    public List<MstUser> findByUserId(String userId) {
       Query query = em.createNamedQuery("MstUser.findByUserId", MstUser.class);
       query.setParameter("userId", userId);
       List<MstUser> rec = query.getResultList();
       return rec;
    }

    /**
     * ユーザ名,部門1,部門2,ロールIDでユーザを検索します.
     * @param userNm
     * @param deptId1
     * @param deptId2
     * @param roleId
     * @return 
     */
    @Override
    public List<MstUser> find(String userNm, String deptId1, String deptId2, String roleId) {
        String sql = "SELECT u FROM MstUser as u";
        ArrayList<String> wheres = new ArrayList<String>();
        if (!userNm.isEmpty()) {
          wheres.add(" CONCAT(u.usernmSei,u.usernmMei) LIKE  :userNm ") ;
        }
        if (!deptId1.isEmpty()) {
          wheres.add(" u.mstDeptId.pDeptId = :deptId1");
        }
        if (!deptId2.isEmpty()) {
          wheres.add(" u.mstDeptId.deptId = :deptId2");
        }
        if (!roleId.isEmpty()) {
          wheres.add(" u.roleId.roleId = :roleId");
        }
        if (!wheres.isEmpty()) {
            String where= " WHERE " + StringUtils.join(wheres, " AND ");
            sql += where;
        }

        Query query = em.createQuery(sql, MstUser.class);
        if (!userNm.isEmpty()) {
            query.setParameter("userNm", "%" + userNm + "%");
        }
        if (!deptId1.isEmpty()) {
            query.setParameter("deptId1", deptId1);
        }
        if (!deptId1.isEmpty()) {
            query.setParameter("deptId2", deptId2);
        }
        if (!roleId.isEmpty()) {
            query.setParameter("roleId", roleId);
        }
        
        return query.getResultList();
    }

    /**
     * ユーザ情報を更新します.
     * @param user 
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public void update(MstUser user) {
        em.merge(user);
    }

}
