package jp.gr.java_conf.ko_aoki.common.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jp.gr.java_conf.ko_aoki.common.entity.VwMenuPath;

/**
 * メニューentityを操作するrepositoryクラス.
 * @author ko-aoki
 */
public class MstMenuRepositoryImpl implements MstMenuRepository{

    @PersistenceContext(name = "common-app-javaee7PU")
    private EntityManager em;

    /**
     * ロールIDをキーとしてメニューentityを取得します.
     * @param roleId
     * @return 
     */
    @Override
    public List<VwMenuPath> findByRoleId(String roleId) {
       Query query = em.createNamedQuery("VwMenuPath.findByRoleId", VwMenuPath.class);
       query.setParameter("roleId", roleId);
       List<VwMenuPath> recs = query.getResultList();
       return recs;
    }
    
}
