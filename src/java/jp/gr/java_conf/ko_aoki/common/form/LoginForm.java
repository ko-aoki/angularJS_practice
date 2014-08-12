package jp.gr.java_conf.ko_aoki.common.form;

/**
 * ログイン画面のformクラス.
 * @author ko-aoki
 */
public class LoginForm extends BaseForm{
    private String roleId;

    /**
     * @return the roleId
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
