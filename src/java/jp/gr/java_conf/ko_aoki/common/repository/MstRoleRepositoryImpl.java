package jp.gr.java_conf.ko_aoki.common.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jp.gr.java_conf.ko_aoki.common.entity.MstRole;
import jp.gr.java_conf.ko_aoki.common.entity.VwMenuPath;

/**
 * ロールentityを操作するrepositoryクラス.
 * @author ko-aoki
 */
public class MstRoleRepositoryImpl implements MstRoleRepository{

    @PersistenceContext(name = "common-app-javaee7PU")
    private EntityManager em;

    /**
     * すべてのロールentityを取得します。
     * @return 
     */
    public List<MstRole> findAll() {
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<MstRole> roleCq = cb.createQuery(MstRole.class);
        Root<MstRole> roleRoot = roleCq.from(MstRole.class);
        roleCq.select(roleRoot);
        TypedQuery<MstRole> roleQuery = em.createQuery(roleCq);
        List<MstRole> roleRecs = roleQuery.getResultList();
        
        return roleRecs;

    }
    
}
