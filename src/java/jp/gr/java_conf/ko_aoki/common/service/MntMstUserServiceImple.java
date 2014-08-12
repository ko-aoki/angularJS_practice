package jp.gr.java_conf.ko_aoki.common.service;

import java.util.Arrays;
import javax.inject.Inject;
import jp.gr.java_conf.ko_aoki.common.entity.MstUser;
import jp.gr.java_conf.ko_aoki.common.form.MntMstUserForm;
import jp.gr.java_conf.ko_aoki.common.form.MntMstUserRegForm;
import jp.gr.java_conf.ko_aoki.common.repository.MstRoleRepository;
import jp.gr.java_conf.ko_aoki.common.repository.MstUserRepository;

/**
 * ユーザマスタメンテ画面のサービスクラス.
 * @author ko-aoki
 */
public class MntMstUserServiceImple implements MntMstUserService{

    @Inject
    private MstUserRepository mstUserRep;

    @Inject
    private MstRoleRepository mstRoleRep;

    /**
     * Creates a new instance of MenuService
     */
    public MntMstUserServiceImple() {
    }

    /**
     * ユーザ情報を取得します.
     * @param userNm
     * @param deptId1
     * @param deptId2
     * @param roleId
     * @return 
     */
    public MntMstUserForm getUsers(String userNm, String deptId1, String deptId2, String roleId) {        

        MntMstUserForm form = new MntMstUserForm();
        form.setRecs(mstUserRep.find(userNm, deptId1, deptId2, roleId));
        form.setRoles(mstRoleRep.findAll());
        form.setResult("ok");
        
        return form;
    }

    /**
     * ユーザ情報を取得します.
     * @param mstUserId
     * @return 
     */
    public MntMstUserRegForm getUser(String mstUserId ) {


        MntMstUserRegForm form = new MntMstUserRegForm();
        MstUser user = mstUserRep.find(mstUserId);
        if (user == null) {
            throw new RuntimeException("データが存在しません　ユーザID：" + mstUserId);
        } else {
            form.setRec(user);
            form.setRoles(mstRoleRep.findAll());
            form.setResult("ok");
        }
        return form;
    }

    /**
     * 更新確認処理を行います.
     * @param form
     * @return 
     */
    public MntMstUserRegForm confirm(MntMstUserRegForm form) {
        //TODO 突合が必要
        form.setResult("OK");
        return form;
    }

    /**
     * ユーザデータを更新します.
     * @param mstUserId
     * @param form
     * @return 
     */
    public MntMstUserRegForm updateUser(String mstUserId, MntMstUserRegForm form) {
        mstUserRep.update(form.getRec());
        form.setMessages(Arrays.asList("データを更新しました。"));
        return form;
    }

}
