/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
 *
 * @author admin
 */
@Entity
@Table(name = "MST_DEPT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstDept.findAll", query = "SELECT m FROM MstDept m"),
    @NamedQuery(name = "MstDept.findByMstDeptId", query = "SELECT m FROM MstDept m WHERE m.mstDeptId = :mstDeptId"),
    @NamedQuery(name = "MstDept.findByDeptId", query = "SELECT m FROM MstDept m WHERE m.deptId = :deptId"),
    @NamedQuery(name = "MstDept.findByDeptNm", query = "SELECT m FROM MstDept m WHERE m.deptNm = :deptNm"),
    @NamedQuery(name = "MstDept.findByPDeptId", query = "SELECT m FROM MstDept m WHERE m.pDeptId = :pDeptId"),
    @NamedQuery(name = "MstDept.findByStartDate", query = "SELECT m FROM MstDept m WHERE m.startDate = :startDate"),
    @NamedQuery(name = "MstDept.findByEndDate", query = "SELECT m FROM MstDept m WHERE m.endDate = :endDate"),
    @NamedQuery(name = "MstDept.findByVersionNo", query = "SELECT m FROM MstDept m WHERE m.versionNo = :versionNo")})
public class MstDept implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MST_DEPT_ID")
    private Long mstDeptId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "DEPT_ID")
    private String deptId;
    @Size(max = 80)
    @Column(name = "DEPT_NM")
    private String deptNm;
    @Size(max = 10)
    @Column(name = "P_DEPT_ID")
    private String pDeptId;
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
    @OneToMany(mappedBy = "mstDeptId")
    private Collection<MstUser> mstUserCollection;

    public MstDept() {
    }

    public MstDept(Long mstDeptId) {
        this.mstDeptId = mstDeptId;
    }

    public MstDept(Long mstDeptId, String deptId, String startDate) {
        this.mstDeptId = mstDeptId;
        this.deptId = deptId;
        this.startDate = startDate;
    }

    public Long getMstDeptId() {
        return mstDeptId;
    }

    public void setMstDeptId(Long mstDeptId) {
        this.mstDeptId = mstDeptId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptNm() {
        return deptNm;
    }

    public void setDeptNm(String deptNm) {
        this.deptNm = deptNm;
    }

    public String getPDeptId() {
        return pDeptId;
    }

    public void setPDeptId(String pDeptId) {
        this.pDeptId = pDeptId;
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
        hash += (mstDeptId != null ? mstDeptId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstDept)) {
            return false;
        }
        MstDept other = (MstDept) object;
        if ((this.mstDeptId == null && other.mstDeptId != null) || (this.mstDeptId != null && !this.mstDeptId.equals(other.mstDeptId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.gr.java_conf.ko_aoki.common.entity.MstDept[ mstDeptId=" + mstDeptId + " ]";
    }
    
}
