/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.gr.java_conf.ko_aoki.common.service;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import jp.gr.java_conf.ko_aoki.common.base.MenuHandler;
import jp.gr.java_conf.ko_aoki.common.bean.MenuBean;
import jp.gr.java_conf.ko_aoki.common.entity.VwMenuPath;
import jp.gr.java_conf.ko_aoki.common.repository.MstMenuRepository;

/**
 *
 * @author admin
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
     * Retrieves representation of an instance of jp.gr.java_conf.ko_aoki.common.service.MenuServiceImpl
     * @return an instance of java.lang.String
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
