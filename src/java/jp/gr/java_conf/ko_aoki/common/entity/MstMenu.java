/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
 *
 * @author admin
 */
@Entity
@Table(name = "MST_MENU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstMenu.findAll", query = "SELECT m FROM MstMenu m"),
    @NamedQuery(name = "MstMenu.findByMstMenuId", query = "SELECT m FROM MstMenu m WHERE m.mstMenuId = :mstMenuId"),
    @NamedQuery(name = "MstMenu.findByRoleId", query = "SELECT m FROM MstMenu m WHERE m.roleId = :roleId"),
    @NamedQuery(name = "MstMenu.findByMenuId", query = "SELECT m FROM MstMenu m WHERE m.menuId = :menuId"),
    @NamedQuery(name = "MstMenu.findByMenuNm", query = "SELECT m FROM MstMenu m WHERE m.menuNm = :menuNm"),
    @NamedQuery(name = "MstMenu.findByPMenuId", query = "SELECT m FROM MstMenu m WHERE m.pMenuId = :pMenuId"),
    @NamedQuery(name = "MstMenu.findByUrl", query = "SELECT m FROM MstMenu m WHERE m.url = :url")})
public class MstMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MST_MENU_ID")
    private Long mstMenuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ROLE_ID")
    private String roleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MENU_ID")
    private String menuId;
    @Size(max = 60)
    @Column(name = "MENU_NM")
    private String menuNm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "P_MENU_ID")
    private String pMenuId;
    @Size(max = 2048)
    @Column(name = "URL")
    private String url;

    public MstMenu() {
    }

    public MstMenu(Long mstMenuId) {
        this.mstMenuId = mstMenuId;
    }

    public MstMenu(Long mstMenuId, String roleId, String menuId, String pMenuId) {
        this.mstMenuId = mstMenuId;
        this.roleId = roleId;
        this.menuId = menuId;
        this.pMenuId = pMenuId;
    }

    public Long getMstMenuId() {
        return mstMenuId;
    }

    public void setMstMenuId(Long mstMenuId) {
        this.mstMenuId = mstMenuId;
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

    public String getMenuNm() {
        return menuNm;
    }

    public void setMenuNm(String menuNm) {
        this.menuNm = menuNm;
    }

    public String getPMenuId() {
        return pMenuId;
    }

    public void setPMenuId(String pMenuId) {
        this.pMenuId = pMenuId;
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
        hash += (mstMenuId != null ? mstMenuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstMenu)) {
            return false;
        }
        MstMenu other = (MstMenu) object;
        if ((this.mstMenuId == null && other.mstMenuId != null) || (this.mstMenuId != null && !this.mstMenuId.equals(other.mstMenuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.gr.java_conf.ko_aoki.common.entity.MstMenu[ mstMenuId=" + mstMenuId + " ]";
    }
    
}
