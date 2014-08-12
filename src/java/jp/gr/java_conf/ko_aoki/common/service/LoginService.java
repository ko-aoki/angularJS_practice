package jp.gr.java_conf.ko_aoki.common.service;

import jp.gr.java_conf.ko_aoki.common.form.LoginForm;

/**
 *
 * @author admin
 */
public interface LoginService {
    LoginForm login(String userId, String password);
}
