/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
