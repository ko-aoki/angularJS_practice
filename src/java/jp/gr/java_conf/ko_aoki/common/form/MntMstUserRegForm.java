/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.gr.java_conf.ko_aoki.common.form;

import java.util.List;
import jp.gr.java_conf.ko_aoki.common.entity.MstRole;
import jp.gr.java_conf.ko_aoki.common.entity.MstUser;

/**
 *
 * @author admin
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
