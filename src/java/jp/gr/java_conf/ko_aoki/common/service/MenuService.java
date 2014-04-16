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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import jp.gr.java_conf.ko_aoki.common.base.MenuHandler;
import jp.gr.java_conf.ko_aoki.common.bean.MenuBean;
import jp.gr.java_conf.ko_aoki.common.entity.VwMenuPath;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("menu")
public class MenuService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MenuService
     */
    public MenuService() {
    }

    /**
     * Retrieves representation of an instance of jp.gr.java_conf.ko_aoki.common.service.MenuService
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{roleId}")
    @Produces("application/json")
    public List<MenuBean> getJson(@PathParam("roleId") String roleId) {
       // Entityマネージャファクトリを生成する
       EntityManagerFactory entityManagerFactory
               = Persistence.createEntityManagerFactory("common-app-javaee7PU");
       // Entityマネージャを生成する
       EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityManager em = entityManager;

       // Entityトランザクションを取得し、トランザクションを開始する
       EntityTransaction entityTransaction = em.getTransaction();
       entityTransaction.begin();
       Query query = em.createNamedQuery("VwMenuPath.findByRoleId", VwMenuPath.class);
       query.setParameter("roleId", roleId);
       List<VwMenuPath> recs = query.getResultList();
       ArrayList<String> paths = new ArrayList<String>();
       for(VwMenuPath bean : recs) {
            String menu = bean.getPath() + (bean.getUrl() == null ? "" : ":" + bean.getUrl());
			paths.add(menu);
       }
       ArrayList<MenuBean> menus = MenuHandler.createMenu(paths);
    
       // Entityマネージャをクローズする
       em.close();
       return menus;
    }

    /**
     * PUT method for updating or creating an instance of MenuService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
