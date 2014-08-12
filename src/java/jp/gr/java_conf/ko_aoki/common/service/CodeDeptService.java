package jp.gr.java_conf.ko_aoki.common.service;

import java.util.Map;
import jp.gr.java_conf.ko_aoki.common.form.CodeDeptForm;

/**
 *
 * @author admin
 */
public interface CodeDeptService {
    CodeDeptForm getDepts(Map<String, String> param, int curPage);
}
