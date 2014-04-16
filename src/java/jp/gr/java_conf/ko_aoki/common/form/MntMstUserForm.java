/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.gr.java_conf.ko_aoki.common.form;

import java.util.List;
import jp.gr.java_conf.ko_aoki.common.entity.MstUser;

/**
 *
 * @author admin
 */
public class MntMstUserForm extends BaseForm{

    private List<MstUser> recs;

    /**
     * @return the rec
     */
    public List<MstUser> getRecs() {
        return recs;
    }

    /**
     * @param rec the rec to set
     */
    public void setRecs(List<MstUser> recs) {
        this.recs = recs;
    }

}
