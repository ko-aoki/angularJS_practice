/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.gr.java_conf.ko_aoki.common.resource;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import jp.gr.java_conf.ko_aoki.common.bean.MenuBean;
import jp.gr.java_conf.ko_aoki.common.service.MenuService;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("menu")
public class MenuResource {

    @Inject
    private MenuService menuService;

    /**
     * Creates a new instance of MenuService
     */
    public MenuResource() {
    }

    /**
     * Retrieves representation of an instance of jp.gr.java_conf.ko_aoki.common.service.MenuResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{roleId}")
    @Produces("application/json")
    public List<MenuBean> init(@PathParam("roleId") String roleId) {
        return menuService.init(roleId);
    }

}
