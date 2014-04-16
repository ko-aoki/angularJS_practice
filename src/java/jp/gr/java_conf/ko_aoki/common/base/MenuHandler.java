package jp.gr.java_conf.ko_aoki.common.base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import jp.gr.java_conf.ko_aoki.common.bean.MenuBean;

/**
 * メニュー情報の操作を行うクラスです。
 * @author kaoki
 *
 */
public class MenuHandler {

    /**
     * パス文字列のリストをMenuDTOのネストリストに変換します。
     * @param paths
     * @return MenuDTOのネストリスト
     */
    public static ArrayList<MenuBean> createMenu(ArrayList<String> paths) {
        ArrayList<MenuBean> rtn = new ArrayList<>();
        Set<String> menuSet = new HashSet<>();
        for (String path : paths) {
            int urlOffset = path.indexOf(":");
            String url = "";
            if (urlOffset >= 0) {
                url = path.substring(urlOffset + 1);
                path = path.substring(0, urlOffset);
            }
            String[] menuIds = path.split("/");
            StringBuilder menuPath = new StringBuilder();
            for (int i=1; i < menuIds.length; i++) {
                String menuId = menuIds[i];
                menuPath.append("/").append(menuId);
                //同じパスは登録しない
                if (menuSet.contains(menuPath.toString())) {
                    continue;
                }
                menuSet.add(menuPath.toString() );
                MenuBean menuDto = new MenuBean(menuId,menuPath.toString(), url);
                addMenuList(rtn, menuDto);
            }
        }
       return rtn;
    }

    private static void addMenuList(ArrayList<MenuBean> list, MenuBean menuDto) {

        if (list.isEmpty()) {
            list.add(menuDto);
            return;
        }

        for (int i=0; i < list.size(); i++) {
            MenuBean menu = list.get(i);
            String menuDtoPath = menuDto.getPath();
            String menuDtoParentPath = menuDtoPath.substring(0, menuDtoPath.lastIndexOf("/"));
            //追加対象の親パスと検索対象のパスが一致
            if ( menuDtoParentPath.equals(menu.getPath())) {
                //子が存在しないか、検索終了
                if (menuDto.getChildMenu().isEmpty() || i == list.size() - 1 ) {
                    menu.addChild(menuDto);
                    return;
                }
                //追加対象が検索対象より階層が深い
            } else if ( menuDtoPath.contains(menu.getPath())) {
                addMenuList(menu.getChildMenu(),menuDto);
                return;
            }

        }

        //検索対象と同じ階層で存在しない追加対象
        list.add(menuDto);

        return;
    }
}
