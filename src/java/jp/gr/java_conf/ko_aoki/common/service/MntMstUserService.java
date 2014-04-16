/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.gr.java_conf.ko_aoki.common.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import jp.gr.java_conf.ko_aoki.common.entity.MstUser;
import jp.gr.java_conf.ko_aoki.common.form.MntMstUserForm;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("mntMstUser")
public class MntMstUserService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MenuService
     */
    public MntMstUserService() {
    }

    /**
     * Retrieves representation of an instance of
     * jp.gr.java_conf.ko_aoki.common.service.MenuService
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{userNm: .*},{deptId1: .*},{deptId2: .*},{roleId: .*}")
    @Produces("application/json")
    public MntMstUserForm getJson(
            @PathParam("userNm") String userNm,
            @PathParam("deptId1") String deptId1,
            @PathParam("deptId2") String deptId2,
            @PathParam("roleId") String roleId) {
        // Entityマネージャファクトリを生成する
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("common-app-javaee7PU");
        // Entityマネージャを生成する
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityManager em = entityManager;

        // Entityトランザクションを取得し、トランザクションを開始する
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        //TODO StringUtilsで書き直す
        String sql = "SELECT u FROM MstUser as u";
        if (!userNm.isEmpty()) {
          sql += " WHERE CONCAT(u.usernmSei,u.usernmMei) LIKE  :userNm " ;
        }
        if (!deptId1.isEmpty()) {
          sql += " AND u.mstDeptId.pDeptId = :deptId1";
        }
        if (!deptId2.isEmpty()) {
          sql += " AND u.mstDeptId.deptId = :deptId2";
        }
        if (!roleId.isEmpty()) {
          sql += " AND u.roleId.roleId = :roleId";
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
        
        MntMstUserForm form = new MntMstUserForm();
        form.setRecs(query.getResultList());
        form.setResult("ok");
        
        // Entityマネージャをクローズする
        em.close();
        return form;
    }

    /**
     * PUT method for updating or creating an instance of MenuService
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
