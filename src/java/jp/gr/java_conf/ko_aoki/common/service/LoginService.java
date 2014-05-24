/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.gr.java_conf.ko_aoki.common.service;

import jp.gr.java_conf.ko_aoki.common.form.LoginForm;

/**
 *
 * @author admin
 */
public interface LoginService {
    LoginForm login(String userId, String password);
}
