
package jp.gr.java_conf.ko_aoki.common.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * メニュー情報クラス
 * @author ko-aoki
 */
public class MenuBean implements Serializable {

    /**
     * メニューID
     */
    private String menuId;

    /**
     * パス
     */
    private String path;

    /**
     * 親メニュー
     */
    private MenuBean parent;

    /**
     * URL
     */
    private String url;

    public MenuBean(){

    }

    public MenuBean(String menuId, String path, String url){
        this.menuId = menuId;
        this.path = path;
        this.url = url;
    }


    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public MenuBean getParent() {
        return parent;
    }

    public void setParent(MenuBean parent) {
        this.parent = parent;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<MenuBean> getChildMenu() {
        return childMenu;
    }

    public void setChildMenu(ArrayList<MenuBean> childMenu) {
        this.childMenu = childMenu;
    }

    /**
     * 子メニューリスト
     */
    private ArrayList<MenuBean> childMenu = new ArrayList<MenuBean>();

    /**
     * 子メニューを追加します
     * @param menu
     */
    public void addChild(MenuBean menu) {
        childMenu.add(menu);
    }

}
