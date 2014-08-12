package jp.gr.java_conf.ko_aoki.common.service;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import jp.gr.java_conf.ko_aoki.common.base.MenuHandler;
import jp.gr.java_conf.ko_aoki.common.bean.MenuBean;
import jp.gr.java_conf.ko_aoki.common.entity.VwMenuPath;
import jp.gr.java_conf.ko_aoki.common.repository.MstMenuRepository;

/**
 * メニュー画面のサービスクラス.
 * @author ko-aoki
 */
public class MenuServiceImpl implements MenuService{

    @Inject
    private MstMenuRepository mstMenuRep;

    /**
     * Creates a new instance of MenuService
     */
    public MenuServiceImpl() {
    }

    /**
     * メニュー画面の初期化処理を行います.
     * @param roleId
     * @return 
     */
    public List<MenuBean> init(String roleId) {

       List<VwMenuPath> recs = mstMenuRep.findByRoleId(roleId);
       ArrayList<String> paths = new ArrayList<String>();
       for(VwMenuPath bean : recs) {
            String menu = bean.getPath() + (bean.getUrl() == null ? "" : ":" + bean.getUrl());
			paths.add(menu);
       }
       ArrayList<MenuBean> menus = MenuHandler.createMenu(paths);
    
       return menus;
    }

}
