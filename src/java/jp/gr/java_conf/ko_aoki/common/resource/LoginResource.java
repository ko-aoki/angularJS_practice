/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.gr.java_conf.ko_aoki.common.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import jp.gr.java_conf.ko_aoki.common.form.LoginForm;
import jp.gr.java_conf.ko_aoki.common.service.LoginService;

/**
 * REST Web Service
 *
 * @author admin
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
     * Retrieves representation of an instance of jp.gr.java_conf.ko_aoki.common.service.LoginResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{userId},{password}")
    @Produces("application/json")
    public LoginForm login(@PathParam("userId") String userId, @PathParam("password") String password) {
       return loginService.login(userId, password);
    }

}
