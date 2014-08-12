package jp.gr.java_conf.ko_aoki.common.service;

import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import jp.gr.java_conf.ko_aoki.common.entity.MstUser;
import jp.gr.java_conf.ko_aoki.common.form.LoginForm;
import jp.gr.java_conf.ko_aoki.common.repository.MstUserRepository;

/**
 * ログイン画面のサービスクラス.
 * @author ko-aoki
 */
public class LoginServiceImpl implements LoginService{

    @Inject
    private MstUserRepository mstUserRep;
    
    /**
     * ログイン処理を行います.
     * @param userId
     * @param password
     * @return 
     */
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
