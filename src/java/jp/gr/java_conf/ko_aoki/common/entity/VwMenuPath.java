package jp.gr.java_conf.ko_aoki.common.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * メニュービューのEntityクラス.
 * @author ko-aoki
 */
@Entity
@Table(name = "VW_MENU_PATH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwMenuPath.findAll", query = "SELECT v FROM VwMenuPath v"),
    @NamedQuery(name = "VwMenuPath.findByRoleId", query = "SELECT v FROM VwMenuPath v WHERE v.roleId = :roleId"),
    @NamedQuery(name = "VwMenuPath.findByMenuId", query = "SELECT v FROM VwMenuPath v WHERE v.menuId = :menuId"),
    @NamedQuery(name = "VwMenuPath.findByPMenuId", query = "SELECT v FROM VwMenuPath v WHERE v.pMenuId = :pMenuId"),
    @NamedQuery(name = "VwMenuPath.findByMenuNm", query = "SELECT v FROM VwMenuPath v WHERE v.menuNm = :menuNm"),
    @NamedQuery(name = "VwMenuPath.findByPath", query = "SELECT v FROM VwMenuPath v WHERE v.path = :path"),
    @NamedQuery(name = "VwMenuPath.findByUrl", query = "SELECT v FROM VwMenuPath v WHERE v.url = :url")})
public class VwMenuPath implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ROLE_ID")
    private String roleId;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MENU_ID")
    private String menuId;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "P_MENU_ID")
    private String pMenuId;
    @Size(max = 60)
    @Column(name = "MENU_NM")
    private String menuNm;
    @Size(max = 4000)
    @Column(name = "PATH")
    private String path;
    @Size(max = 2048)
    @Column(name = "URL")
    private String url;

    public VwMenuPath() {
    }

    public VwMenuPath(String pMenuId) {
        this.pMenuId = pMenuId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getPMenuId() {
        return pMenuId;
    }

    public void setPMenuId(String pMenuId) {
        this.pMenuId = pMenuId;
    }

    public String getMenuNm() {
        return menuNm;
    }

    public void setMenuNm(String menuNm) {
        this.menuNm = menuNm;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pMenuId != null ? pMenuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VwMenuPath)) {
            return false;
        }
        VwMenuPath other = (VwMenuPath) object;
        if ((this.pMenuId == null && other.pMenuId != null) || (this.pMenuId != null && !this.pMenuId.equals(other.pMenuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.gr.java_conf.ko_aoki.common.entity.VwMenuPath[ pMenuId=" + pMenuId + " ]";
    }
    
}
