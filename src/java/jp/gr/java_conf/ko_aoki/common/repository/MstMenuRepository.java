package jp.gr.java_conf.ko_aoki.common.repository;

import java.util.List;
import jp.gr.java_conf.ko_aoki.common.entity.VwMenuPath;

/**
 *
 * @author admin
 */
public interface MstMenuRepository {

    List<VwMenuPath> findByRoleId(String roleId);    

}
