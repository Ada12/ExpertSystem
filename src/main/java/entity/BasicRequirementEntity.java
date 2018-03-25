package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 2018/3/13.
 */
@Entity
@Table(name = "basic_requirement", schema = "expert_system", catalog = "")
public class BasicRequirementEntity {
    private int id;
    private String description;
    private Double sglVi;
    private Double sglV0;
    private Double frtSglTmp;
    private Double rrSglTmp;
    private Double linVi;
    private Double linV0;
    private Double frtLinPwr;
    private Double rrLinPwr;
    private Double hftVi;
    private Double hftV0;
    private Double frtHftPwr;
    private Double rrHftPwr;
    private String bet;
    private String brakeStop;
    private String pedalFeel;
    private Integer userId;
    private String notes;
    private Integer isWork;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "sgl_vi")
    public Double getSglVi() {
        return sglVi;
    }

    public void setSglVi(Double sglVi) {
        this.sglVi = sglVi;
    }

    @Basic
    @Column(name = "sgl_v0")
    public Double getSglV0() {
        return sglV0;
    }

    public void setSglV0(Double sglV0) {
        this.sglV0 = sglV0;
    }

    @Basic
    @Column(name = "frt_sgl_tmp")
    public Double getFrtSglTmp() {
        return frtSglTmp;
    }

    public void setFrtSglTmp(Double frtSglTmp) {
        this.frtSglTmp = frtSglTmp;
    }

    @Basic
    @Column(name = "rr_sgl_tmp")
    public Double getRrSglTmp() {
        return rrSglTmp;
    }

    public void setRrSglTmp(Double rrSglTmp) {
        this.rrSglTmp = rrSglTmp;
    }

    @Basic
    @Column(name = "lin_vi")
    public Double getLinVi() {
        return linVi;
    }

    public void setLinVi(Double linVi) {
        this.linVi = linVi;
    }

    @Basic
    @Column(name = "lin_v0")
    public Double getLinV0() {
        return linV0;
    }

    public void setLinV0(Double linV0) {
        this.linV0 = linV0;
    }

    @Basic
    @Column(name = "frt_lin_pwr")
    public Double getFrtLinPwr() {
        return frtLinPwr;
    }

    public void setFrtLinPwr(Double frtLinPwr) {
        this.frtLinPwr = frtLinPwr;
    }

    @Basic
    @Column(name = "rr_lin_pwr")
    public Double getRrLinPwr() {
        return rrLinPwr;
    }

    public void setRrLinPwr(Double rrLinPwr) {
        this.rrLinPwr = rrLinPwr;
    }

    @Basic
    @Column(name = "hft_vi")
    public Double getHftVi() {
        return hftVi;
    }

    public void setHftVi(Double hftVi) {
        this.hftVi = hftVi;
    }

    @Basic
    @Column(name = "hft_v0")
    public Double getHftV0() {
        return hftV0;
    }

    public void setHftV0(Double hftV0) {
        this.hftV0 = hftV0;
    }

    @Basic
    @Column(name = "frt_hft_pwr")
    public Double getFrtHftPwr() {
        return frtHftPwr;
    }

    public void setFrtHftPwr(Double frtHftPwr) {
        this.frtHftPwr = frtHftPwr;
    }

    @Basic
    @Column(name = "rr_hft_pwr")
    public Double getRrHftPwr() {
        return rrHftPwr;
    }

    public void setRrHftPwr(Double rrHftPwr) {
        this.rrHftPwr = rrHftPwr;
    }

    @Basic
    @Column(name = "bet")
    public String getBet() {
        return bet;
    }

    public void setBet(String bet) {
        this.bet = bet;
    }

    @Basic
    @Column(name = "brake_stop")
    public String getBrakeStop() {
        return brakeStop;
    }

    public void setBrakeStop(String brakeStop) {
        this.brakeStop = brakeStop;
    }

    @Basic
    @Column(name = "pedal_feel")
    public String getPedalFeel() {
        return pedalFeel;
    }

    public void setPedalFeel(String pedalFeel) {
        this.pedalFeel = pedalFeel;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic
    @Column(name = "is_work")
    public Integer getIsWork() {
        return isWork;
    }

    public void setIsWork(Integer isWork) {
        this.isWork = isWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasicRequirementEntity that = (BasicRequirementEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (sglVi != null ? !sglVi.equals(that.sglVi) : that.sglVi != null) return false;
        if (sglV0 != null ? !sglV0.equals(that.sglV0) : that.sglV0 != null) return false;
        if (frtSglTmp != null ? !frtSglTmp.equals(that.frtSglTmp) : that.frtSglTmp != null) return false;
        if (rrSglTmp != null ? !rrSglTmp.equals(that.rrSglTmp) : that.rrSglTmp != null) return false;
        if (linVi != null ? !linVi.equals(that.linVi) : that.linVi != null) return false;
        if (linV0 != null ? !linV0.equals(that.linV0) : that.linV0 != null) return false;
        if (frtLinPwr != null ? !frtLinPwr.equals(that.frtLinPwr) : that.frtLinPwr != null) return false;
        if (rrLinPwr != null ? !rrLinPwr.equals(that.rrLinPwr) : that.rrLinPwr != null) return false;
        if (hftVi != null ? !hftVi.equals(that.hftVi) : that.hftVi != null) return false;
        if (hftV0 != null ? !hftV0.equals(that.hftV0) : that.hftV0 != null) return false;
        if (frtHftPwr != null ? !frtHftPwr.equals(that.frtHftPwr) : that.frtHftPwr != null) return false;
        if (rrHftPwr != null ? !rrHftPwr.equals(that.rrHftPwr) : that.rrHftPwr != null) return false;
        if (bet != null ? !bet.equals(that.bet) : that.bet != null) return false;
        if (brakeStop != null ? !brakeStop.equals(that.brakeStop) : that.brakeStop != null) return false;
        if (pedalFeel != null ? !pedalFeel.equals(that.pedalFeel) : that.pedalFeel != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (isWork != null ? !isWork.equals(that.isWork) : that.isWork != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (sglVi != null ? sglVi.hashCode() : 0);
        result = 31 * result + (sglV0 != null ? sglV0.hashCode() : 0);
        result = 31 * result + (frtSglTmp != null ? frtSglTmp.hashCode() : 0);
        result = 31 * result + (rrSglTmp != null ? rrSglTmp.hashCode() : 0);
        result = 31 * result + (linVi != null ? linVi.hashCode() : 0);
        result = 31 * result + (linV0 != null ? linV0.hashCode() : 0);
        result = 31 * result + (frtLinPwr != null ? frtLinPwr.hashCode() : 0);
        result = 31 * result + (rrLinPwr != null ? rrLinPwr.hashCode() : 0);
        result = 31 * result + (hftVi != null ? hftVi.hashCode() : 0);
        result = 31 * result + (hftV0 != null ? hftV0.hashCode() : 0);
        result = 31 * result + (frtHftPwr != null ? frtHftPwr.hashCode() : 0);
        result = 31 * result + (rrHftPwr != null ? rrHftPwr.hashCode() : 0);
        result = 31 * result + (bet != null ? bet.hashCode() : 0);
        result = 31 * result + (brakeStop != null ? brakeStop.hashCode() : 0);
        result = 31 * result + (pedalFeel != null ? pedalFeel.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (isWork != null ? isWork.hashCode() : 0);
        return result;
    }
}
