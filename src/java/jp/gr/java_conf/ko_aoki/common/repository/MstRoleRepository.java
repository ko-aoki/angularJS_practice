package jp.gr.java_conf.ko_aoki.common.repository;

import java.util.List;
import jp.gr.java_conf.ko_aoki.common.entity.MstRole;

/**
 *
 * @author admin
 */
public interface MstRoleRepository {

    List<MstRole> findAll();

}
