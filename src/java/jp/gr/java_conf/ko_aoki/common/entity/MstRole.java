package jp.gr.java_conf.ko_aoki.common.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * ロールマスタのEntityクラス.
 * @author ko-aoki
 */
@Entity
@Table(name = "MST_ROLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstRole.findAll", query = "SELECT m FROM MstRole m"),
    @NamedQuery(name = "MstRole.findByRoleId", query = "SELECT m FROM MstRole m WHERE m.roleId = :roleId"),
    @NamedQuery(name = "MstRole.findByRoleNm", query = "SELECT m FROM MstRole m WHERE m.roleNm = :roleNm")})
public class MstRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ROLE_ID")
    private String roleId;
    @Size(max = 40)
    @Column(name = "ROLE_NM")
    private String roleNm;
    @OneToMany(mappedBy = "roleId")
    private Collection<MstUser> mstUserCollection;

    public MstRole() {
    }

    public MstRole(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleNm() {
        return roleNm;
    }

    public void setRoleNm(String roleNm) {
        this.roleNm = roleNm;
    }

    @XmlTransient
    public Collection<MstUser> getMstUserCollection() {
        return mstUserCollection;
    }

    public void setMstUserCollection(Collection<MstUser> mstUserCollection) {
        this.mstUserCollection = mstUserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstRole)) {
            return false;
        }
        MstRole other = (MstRole) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.gr.java_conf.ko_aoki.common.entity.MstRole[ roleId=" + roleId + " ]";
    }
    
}
