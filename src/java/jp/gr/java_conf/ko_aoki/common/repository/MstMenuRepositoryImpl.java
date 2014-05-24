/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.gr.java_conf.ko_aoki.common.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jp.gr.java_conf.ko_aoki.common.base.MenuHandler;
import jp.gr.java_conf.ko_aoki.common.bean.MenuBean;
import jp.gr.java_conf.ko_aoki.common.entity.VwMenuPath;

/**
 *
 * @author admin
 */
public class MstMenuRepositoryImpl implements MstMenuRepository{

    @PersistenceContext(name = "common-app-javaee7PU")
    private EntityManager em;

    @Override
    public List<VwMenuPath> findByRoleId(String roleId) {
       Query query = em.createNamedQuery("VwMenuPath.findByRoleId", VwMenuPath.class);
       query.setParameter("roleId", roleId);
       List<VwMenuPath> recs = query.getResultList();
       return recs;
    }
    
}
