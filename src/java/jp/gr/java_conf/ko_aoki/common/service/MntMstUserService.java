package jp.gr.java_conf.ko_aoki.common.service;

import jp.gr.java_conf.ko_aoki.common.form.MntMstUserForm;
import jp.gr.java_conf.ko_aoki.common.form.MntMstUserRegForm;

/**
 *
 * @author admin
 */
public interface MntMstUserService {
    MntMstUserForm getUsers(String userNm, String deptId1, String deptId2, String roleId);
    MntMstUserRegForm getUser(String mstUserId );
    MntMstUserRegForm confirm(MntMstUserRegForm form);
    MntMstUserRegForm updateUser(String mstUserId, MntMstUserRegForm form);
}
