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
 * メニュー画面のリソースクラス
 * @author ko-aoki
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
     * メニュー画面の初期表示処理.
     * @param roleId
     * @return 
     */
    @GET
    @Path("{roleId}")
    @Produces("application/json")
    public List<MenuBean> init(@PathParam("roleId") String roleId) {
        return menuService.init(roleId);
    }

}
