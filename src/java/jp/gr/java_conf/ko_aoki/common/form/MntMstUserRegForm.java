package jp.gr.java_conf.ko_aoki.common.form;

import java.util.List;
import jp.gr.java_conf.ko_aoki.common.entity.MstRole;
import jp.gr.java_conf.ko_aoki.common.entity.MstUser;

/**
 * ユーザマスタメンテ登録画面のformクラス.
 * @author ko-aoki
 */
public class MntMstUserRegForm extends BaseForm{

    private MstUser rec;
    private List<MstRole> roles;

    /**
     * @return the rec
     */
    public MstUser getRec() {
        return rec;
    }

    /**
     * @param rec the rec to set
     */
    public void setRec(MstUser rec) {
        this.rec = rec;
    }

    /**
     * @return the roles
     */
    public List<MstRole> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(List<MstRole> roles) {
        this.roles = roles;
    }


}
