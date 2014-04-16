/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.gr.java_conf.ko_aoki.common.service;

import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import jp.gr.java_conf.ko_aoki.common.entity.MstUser;
import jp.gr.java_conf.ko_aoki.common.form.BaseForm;
import jp.gr.java_conf.ko_aoki.common.form.LoginForm;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("login")
public class LoginService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LoginService
     */
    public LoginService() {
    }

    /**
     * Retrieves representation of an instance of jp.gr.java_conf.ko_aoki.common.service.LoginService
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{userId},{password}")
    @Produces("application/json")
    public LoginForm getJson(@PathParam("userId") String userId, @PathParam("password") String password) {
       // Entityマネージャファクトリを生成する
       EntityManagerFactory entityManagerFactory
               = Persistence.createEntityManagerFactory("common-app-javaee7PU");
       // Entityマネージャを生成する
       EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityManager em = entityManager;

       // Entityトランザクションを取得し、トランザクションを開始する
       EntityTransaction entityTransaction = em.getTransaction();
       entityTransaction.begin();
       Query query = em.createNamedQuery("MstUser.findByUserId", MstUser.class);
       query.setParameter("userId", userId);
       List<MstUser> rec = query.getResultList();
       LoginForm form = new LoginForm();
       if (rec.isEmpty()) {
           form.setMessages(Arrays.asList("ユーザが存在しません")); //サンプルとして
           form.setResult("error");
       } else {
           if (password.equals(rec.get(0).getPassword())) {
                form.setRoleId(rec.get(0).getRoleId().getRoleId());
                form.setResult("ok");
           } else {
               form.setMessages(Arrays.asList("パスワードが一致しません"));
           form.setResult("error");
           }
       }
       // Entityマネージャをクローズする
       em.close();
       return form;

    }

    /**
     * PUT method for updating or creating an instance of LoginService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
