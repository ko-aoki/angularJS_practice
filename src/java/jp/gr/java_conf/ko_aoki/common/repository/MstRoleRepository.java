/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.gr.java_conf.ko_aoki.common.repository;

import java.util.List;
import jp.gr.java_conf.ko_aoki.common.entity.MstRole;
import jp.gr.java_conf.ko_aoki.common.entity.VwMenuPath;

/**
 *
 * @author admin
 */
public interface MstRoleRepository {

    List<VwMenuPath> findByRoleId(String roleId);    
    List<MstRole> findAll();

}
