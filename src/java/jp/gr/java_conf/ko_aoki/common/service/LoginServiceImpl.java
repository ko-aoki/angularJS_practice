/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.gr.java_conf.ko_aoki.common.service;

import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import jp.gr.java_conf.ko_aoki.common.entity.MstUser;
import jp.gr.java_conf.ko_aoki.common.form.LoginForm;
import jp.gr.java_conf.ko_aoki.common.repository.MstUserRepository;

public class LoginServiceImpl implements LoginService{

    @Inject
    private MstUserRepository mstUserRep;
    
    public LoginForm login(String userId, String password) {
       
        List<MstUser> rec = mstUserRep.findByUserId(userId);
        LoginForm form = new LoginForm();
        if (rec.isEmpty()) {
            form.setMessages(Arrays.asList("ユーザが存在しません")); //サンプルとして
            form.setResult("error");
        } else {
            if (password.equals(rec.get(0).getPassword())) {
                form.setRoleId(rec.get(0).getRoleId().getRoleId());
                form.setResult("ok");
            } else {
                form.setMessages(Arrays.asList("パスワードが一致しません"));
                form.setResult("error");
            }
        }
        return form;

    }

}
