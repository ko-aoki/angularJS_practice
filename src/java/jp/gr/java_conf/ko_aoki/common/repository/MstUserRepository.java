package jp.gr.java_conf.ko_aoki.common.repository;

import java.util.List;
import jp.gr.java_conf.ko_aoki.common.entity.MstUser;

/**
 *
 * @author admin
 */
public interface MstUserRepository {

    MstUser find(String mstUserId);

    void update(MstUser user);

    List<MstUser> findByUserId(String userId);

    List<MstUser> find(String userNm, String deptId1, String deptId2, String roleId);

}
