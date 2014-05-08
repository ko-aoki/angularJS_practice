/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.gr.java_conf.ko_aoki.common.service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import jp.gr.java_conf.ko_aoki.common.entity.MstRole;
import jp.gr.java_conf.ko_aoki.common.entity.MstUser;
import jp.gr.java_conf.ko_aoki.common.entity.MstUser_;
import jp.gr.java_conf.ko_aoki.common.form.MntMstUserForm;
import jp.gr.java_conf.ko_aoki.common.form.MntMstUserRegForm;
import org.apache.commons.lang.StringUtils;

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
    public MntMstUserForm getUsers(
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
        
        //ロールのセット
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<MstRole> roleCq = cb.createQuery(MstRole.class);
        Root<MstRole> roleRoot = roleCq.from(MstRole.class);
        roleCq.select(roleRoot);
        TypedQuery<MstRole> roleQuery = em.createQuery(roleCq);

        MntMstUserForm form = new MntMstUserForm();
        form.setRecs(query.getResultList());
        final List<MstRole> roleRecs = roleQuery.getResultList();
        form.setRoles(roleRecs);
        form.setResult("ok");
        
        // Entityマネージャをクローズする
        em.close();
        return form;
    }

    @GET
    @Path("{mstUserId: .*}")
    @Produces("application/json")
    public MntMstUserRegForm getUser(
            @PathParam("mstUserId") String mstUserId
    ) {
        // Entityマネージャファクトリを生成する
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("common-app-javaee7PU");
        // Entityマネージャを生成する
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityManager em = entityManager;

        // Entityトランザクションを取得し、トランザクションを開始する
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<MstUser> cq = cb.createQuery(MstUser.class);
        Root<MstUser> root = cq.from(MstUser.class);
        cq.select(root).where(cb.equal(root.get(MstUser_.mstUserId), mstUserId));
        TypedQuery<MstUser> query = em.createQuery(cq);
        List<MstUser> resultList = query.getResultList();
        MntMstUserRegForm form = new MntMstUserRegForm();

        if (resultList.isEmpty()) {
            throw new RuntimeException("データが存在しません　ユーザID：" + mstUserId);
        } else {
            form.setRec(query.getResultList().get(0));
            //ロールのセット
            CriteriaQuery<MstRole> roleCq = cb.createQuery(MstRole.class);
            Root<MstRole> roleRoot = roleCq.from(MstRole.class);
            roleCq.select(roleRoot);
            TypedQuery<MstRole> roleQuery = em.createQuery(roleCq);
            form.setRoles(roleQuery.getResultList());

            form.setResult("ok");
        }
        

        
// Entityマネージャをクローズする
        em.close();
        return form;
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public MntMstUserRegForm confirm(MntMstUserRegForm form) {
        MntMstUserRegForm output = new MntMstUserRegForm();
        return output;
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
