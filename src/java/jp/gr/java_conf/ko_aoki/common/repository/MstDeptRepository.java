package jp.gr.java_conf.ko_aoki.common.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import jp.gr.java_conf.ko_aoki.common.entity.CodeDeptBean;

/**
 * ログイン画面のformクラス.
 * @author ko-aoki
 */
public interface MstDeptRepository {

    BigDecimal countLevel1to2DeptList(Map<String, String> params);
    List<CodeDeptBean> selectLevel1to2DeptList(Map<String, String> params, int startNum, int endNum);    

}
