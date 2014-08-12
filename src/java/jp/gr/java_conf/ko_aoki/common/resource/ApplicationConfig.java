package jp.gr.java_conf.ko_aoki.common.resource;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author admin
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(jp.gr.java_conf.ko_aoki.common.resource.CodeDeptResource.class);
        resources.add(jp.gr.java_conf.ko_aoki.common.resource.LoginResource.class);
        resources.add(jp.gr.java_conf.ko_aoki.common.resource.MenuResource.class);
        resources.add(jp.gr.java_conf.ko_aoki.common.resource.MntMstUserResource.class);
    }
    
}
