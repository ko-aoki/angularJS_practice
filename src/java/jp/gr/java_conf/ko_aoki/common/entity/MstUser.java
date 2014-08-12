package jp.gr.java_conf.ko_aoki.common.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ユーザマスタのEntityクラス.
 * @author ko-aoki
 */
@Entity
@Table(name = "MST_USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstUser.findAll", query = "SELECT m FROM MstUser m"),
    @NamedQuery(name = "MstUser.findByMstUserId", query = "SELECT m FROM MstUser m WHERE m.mstUserId = :mstUserId"),
    @NamedQuery(name = "MstUser.findByUserId", query = "SELECT m FROM MstUser m WHERE m.userId = :userId"),
    @NamedQuery(name = "MstUser.findByUsernmSei", query = "SELECT m FROM MstUser m WHERE m.usernmSei = :usernmSei"),
    @NamedQuery(name = "MstUser.findByUsernmMei", query = "SELECT m FROM MstUser m WHERE m.usernmMei = :usernmMei"),
    @NamedQuery(name = "MstUser.findByPassword", query = "SELECT m FROM MstUser m WHERE m.password = :password"),
    @NamedQuery(name = "MstUser.findByStartDate", query = "SELECT m FROM MstUser m WHERE m.startDate = :startDate"),
    @NamedQuery(name = "MstUser.findByEndDate", query = "SELECT m FROM MstUser m WHERE m.endDate = :endDate"),
    @NamedQuery(name = "MstUser.findByVersionNo", query = "SELECT m FROM MstUser m WHERE m.versionNo = :versionNo")})
public class MstUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MST_USER_ID")
    private Long mstUserId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USER_ID")
    private String userId;
    @Size(max = 20)
    @Column(name = "USERNM_SEI")
    private String usernmSei;
    @Size(max = 20)
    @Column(name = "USERNM_MEI")
    private String usernmMei;
    @Size(max = 100)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "START_DATE")
    private String startDate;
    @Size(max = 8)
    @Column(name = "END_DATE")
    private String endDate;
    @Column(name = "VERSION_NO")
    private Long versionNo;
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
    @ManyToOne
    private MstRole roleId;
    @JoinColumn(name = "MST_DEPT_ID", referencedColumnName = "MST_DEPT_ID")
    @ManyToOne
    private MstDept mstDeptId;

    public MstUser() {
    }

    public MstUser(Long mstUserId) {
        this.mstUserId = mstUserId;
    }

    public MstUser(Long mstUserId, String userId, String startDate) {
        this.mstUserId = mstUserId;
        this.userId = userId;
        this.startDate = startDate;
    }

    public Long getMstUserId() {
        return mstUserId;
    }

    public void setMstUserId(Long mstUserId) {
        this.mstUserId = mstUserId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsernmSei() {
        return usernmSei;
    }

    public void setUsernmSei(String usernmSei) {
        this.usernmSei = usernmSei;
    }

    public String getUsernmMei() {
        return usernmMei;
    }

    public void setUsernmMei(String usernmMei) {
        this.usernmMei = usernmMei;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Long getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(Long versionNo) {
        this.versionNo = versionNo;
    }

    public MstRole getRoleId() {
        return roleId;
    }

    public void setRoleId(MstRole roleId) {
        this.roleId = roleId;
    }

    public MstDept getMstDeptId() {
        return mstDeptId;
    }

    public void setMstDeptId(MstDept mstDeptId) {
        this.mstDeptId = mstDeptId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mstUserId != null ? mstUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstUser)) {
            return false;
        }
        MstUser other = (MstUser) object;
        if ((this.mstUserId == null && other.mstUserId != null) || (this.mstUserId != null && !this.mstUserId.equals(other.mstUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.gr.java_conf.ko_aoki.common.entity.MstUser[ mstUserId=" + mstUserId + " ]";
    }
    
}
