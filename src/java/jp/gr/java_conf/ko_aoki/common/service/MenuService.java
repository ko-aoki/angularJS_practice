/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.gr.java_conf.ko_aoki.common.service;

import java.util.List;
import jp.gr.java_conf.ko_aoki.common.bean.MenuBean;

/**
 *
 * @author admin
 */
public interface MenuService {
    List<MenuBean> init(String roleId);
}
