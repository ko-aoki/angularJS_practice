package jp.gr.java_conf.ko_aoki.common.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import jp.gr.java_conf.ko_aoki.common.form.LoginForm;
import jp.gr.java_conf.ko_aoki.common.service.LoginService;

/**
 * ログイン画面のリソースクラス
 * @author ko-aoki
 */
@Path("login")
public class LoginResource {

    @Inject
    private LoginService loginService;
    
    /**
     * Creates a new instance of LoginService
     */
    public LoginResource() {
    }


    /**
     * ログイン処理を行います.
     * @param userId
     * @param password
     * @return 
     */
    @GET
    @Path("{userId},{password}")
    @Produces("application/json")
    public LoginForm login(@PathParam("userId") String userId, @PathParam("password") String password) {
       return loginService.login(userId, password);
    }

}
