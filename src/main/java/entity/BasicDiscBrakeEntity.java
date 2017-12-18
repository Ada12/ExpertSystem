package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 17/11/18.
 */
@Entity
@Table(name = "basic_disc_brake", schema = "expert_system", catalog = "")
public class BasicDiscBrakeEntity {
    private int id;
    private String description;
    private Double pstD;
    private Integer pstNum;
    private Double pstArea;
    private Double hfP;
    private String pVcurve;
    private Double pvK;
    private Double pvB;
    private Double pvC;
    private String linMat;
    private Double linMu;
    private Double linMuK;
    private Double linMuE;
    private Double linMuNp;
    private Double linArea;
    private Double linWearLim;
    private String frtRtTempIn;
    private String frtLinWearOut;
    private String frtLinFrictOut;
    private Double perCorner;
    private String rtTypeV;
    private Double rtSwpAreaV;
    private Double rtEfcRV;
    private Double rtDiaOutV;
    private Double rtDiaInV;
    private String rtInCkTV;
    private String rtOutCkTV;
    private Double rtTV;
    private Integer rtVanNumV;
    private Double rtVanLenV;
    private Double rtVaneHighV;
    private Double rtVanTV;
    private Double rtWmV;
    private Double rtWaV;
    private Double rhoV;
    private Double cc50V;
    private Double cc80V;
    private Double cvr50V;
    private Double cvr80V;
    private String rtTempInV;
    private String rtSpecOutV;
    private String rtTypeS;
    private Double rtSwpAreaS;
    private Double rtEfcRS;
    private Double rtDiaOutS;
    private Double rtDiaInS;
    private Double rtTS;
    private Double rtWmS;
    private Double rtWaS;
    private Double rhoS;
    private Double cc50S;
    private Double cc80S;
    private Double cvr50S;
    private Double cvr80S;
    private String rtTempInS;
    private String rtSpecOutS;
    private String notes;

    @Id
    @Column(name = "id")
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
    @Column(name = "pst_d")
    public Double getPstD() {
        return pstD;
    }

    public void setPstD(Double pstD) {
        this.pstD = pstD;
    }

    @Basic
    @Column(name = "pst_num")
    public Integer getPstNum() {
        return pstNum;
    }

    public void setPstNum(Integer pstNum) {
        this.pstNum = pstNum;
    }

    @Basic
    @Column(name = "pst_area")
    public Double getPstArea() {
        return pstArea;
    }

    public void setPstArea(Double pstArea) {
        this.pstArea = pstArea;
    }

    @Basic
    @Column(name = "hf_P")
    public Double getHfP() {
        return hfP;
    }

    public void setHfP(Double hfP) {
        this.hfP = hfP;
    }

    @Basic
    @Column(name = "PVcurve")
    public String getpVcurve() {
        return pVcurve;
    }

    public void setpVcurve(String pVcurve) {
        this.pVcurve = pVcurve;
    }

    @Basic
    @Column(name = "PV_k")
    public Double getPvK() {
        return pvK;
    }

    public void setPvK(Double pvK) {
        this.pvK = pvK;
    }

    @Basic
    @Column(name = "PV_b")
    public Double getPvB() {
        return pvB;
    }

    public void setPvB(Double pvB) {
        this.pvB = pvB;
    }

    @Basic
    @Column(name = "PV_c")
    public Double getPvC() {
        return pvC;
    }

    public void setPvC(Double pvC) {
        this.pvC = pvC;
    }

    @Basic
    @Column(name = "lin_mat")
    public String getLinMat() {
        return linMat;
    }

    public void setLinMat(String linMat) {
        this.linMat = linMat;
    }

    @Basic
    @Column(name = "lin_mu")
    public Double getLinMu() {
        return linMu;
    }

    public void setLinMu(Double linMu) {
        this.linMu = linMu;
    }

    @Basic
    @Column(name = "lin_mu_k")
    public Double getLinMuK() {
        return linMuK;
    }

    public void setLinMuK(Double linMuK) {
        this.linMuK = linMuK;
    }

    @Basic
    @Column(name = "lin_mu_e")
    public Double getLinMuE() {
        return linMuE;
    }

    public void setLinMuE(Double linMuE) {
        this.linMuE = linMuE;
    }

    @Basic
    @Column(name = "lin_mu_np")
    public Double getLinMuNp() {
        return linMuNp;
    }

    public void setLinMuNp(Double linMuNp) {
        this.linMuNp = linMuNp;
    }

    @Basic
    @Column(name = "lin_area")
    public Double getLinArea() {
        return linArea;
    }

    public void setLinArea(Double linArea) {
        this.linArea = linArea;
    }

    @Basic
    @Column(name = "lin_wear_lim")
    public Double getLinWearLim() {
        return linWearLim;
    }

    public void setLinWearLim(Double linWearLim) {
        this.linWearLim = linWearLim;
    }

    @Basic
    @Column(name = "frt_rt_temp_in")
    public String getFrtRtTempIn() {
        return frtRtTempIn;
    }

    public void setFrtRtTempIn(String frtRtTempIn) {
        this.frtRtTempIn = frtRtTempIn;
    }

    @Basic
    @Column(name = "frt_lin_wear_out")
    public String getFrtLinWearOut() {
        return frtLinWearOut;
    }

    public void setFrtLinWearOut(String frtLinWearOut) {
        this.frtLinWearOut = frtLinWearOut;
    }

    @Basic
    @Column(name = "frt_lin_frict_out")
    public String getFrtLinFrictOut() {
        return frtLinFrictOut;
    }

    public void setFrtLinFrictOut(String frtLinFrictOut) {
        this.frtLinFrictOut = frtLinFrictOut;
    }

    @Basic
    @Column(name = "per_corner")
    public Double getPerCorner() {
        return perCorner;
    }

    public void setPerCorner(Double perCorner) {
        this.perCorner = perCorner;
    }

    @Basic
    @Column(name = "rt_type_V")
    public String getRtTypeV() {
        return rtTypeV;
    }

    public void setRtTypeV(String rtTypeV) {
        this.rtTypeV = rtTypeV;
    }

    @Basic
    @Column(name = "rt_swp_area_V")
    public Double getRtSwpAreaV() {
        return rtSwpAreaV;
    }

    public void setRtSwpAreaV(Double rtSwpAreaV) {
        this.rtSwpAreaV = rtSwpAreaV;
    }

    @Basic
    @Column(name = "rt_efc_r_V")
    public Double getRtEfcRV() {
        return rtEfcRV;
    }

    public void setRtEfcRV(Double rtEfcRV) {
        this.rtEfcRV = rtEfcRV;
    }

    @Basic
    @Column(name = "rt_dia_out_V")
    public Double getRtDiaOutV() {
        return rtDiaOutV;
    }

    public void setRtDiaOutV(Double rtDiaOutV) {
        this.rtDiaOutV = rtDiaOutV;
    }

    @Basic
    @Column(name = "rt_dia_in_V")
    public Double getRtDiaInV() {
        return rtDiaInV;
    }

    public void setRtDiaInV(Double rtDiaInV) {
        this.rtDiaInV = rtDiaInV;
    }

    @Basic
    @Column(name = "rt_in_ck_t_V")
    public String getRtInCkTV() {
        return rtInCkTV;
    }

    public void setRtInCkTV(String rtInCkTV) {
        this.rtInCkTV = rtInCkTV;
    }

    @Basic
    @Column(name = "rt_out_ck_t_V")
    public String getRtOutCkTV() {
        return rtOutCkTV;
    }

    public void setRtOutCkTV(String rtOutCkTV) {
        this.rtOutCkTV = rtOutCkTV;
    }

    @Basic
    @Column(name = "rt_t_V")
    public Double getRtTV() {
        return rtTV;
    }

    public void setRtTV(Double rtTV) {
        this.rtTV = rtTV;
    }

    @Basic
    @Column(name = "rt_van_num_V")
    public Integer getRtVanNumV() {
        return rtVanNumV;
    }

    public void setRtVanNumV(Integer rtVanNumV) {
        this.rtVanNumV = rtVanNumV;
    }

    @Basic
    @Column(name = "rt_van_len_V")
    public Double getRtVanLenV() {
        return rtVanLenV;
    }

    public void setRtVanLenV(Double rtVanLenV) {
        this.rtVanLenV = rtVanLenV;
    }

    @Basic
    @Column(name = "rt_vane_high_V")
    public Double getRtVaneHighV() {
        return rtVaneHighV;
    }

    public void setRtVaneHighV(Double rtVaneHighV) {
        this.rtVaneHighV = rtVaneHighV;
    }

    @Basic
    @Column(name = "rt_van_t_V")
    public Double getRtVanTV() {
        return rtVanTV;
    }

    public void setRtVanTV(Double rtVanTV) {
        this.rtVanTV = rtVanTV;
    }

    @Basic
    @Column(name = "rt_wm_V")
    public Double getRtWmV() {
        return rtWmV;
    }

    public void setRtWmV(Double rtWmV) {
        this.rtWmV = rtWmV;
    }

    @Basic
    @Column(name = "rt_wa_V")
    public Double getRtWaV() {
        return rtWaV;
    }

    public void setRtWaV(Double rtWaV) {
        this.rtWaV = rtWaV;
    }

    @Basic
    @Column(name = "rho_V")
    public Double getRhoV() {
        return rhoV;
    }

    public void setRhoV(Double rhoV) {
        this.rhoV = rhoV;
    }

    @Basic
    @Column(name = "CC_50_V")
    public Double getCc50V() {
        return cc50V;
    }

    public void setCc50V(Double cc50V) {
        this.cc50V = cc50V;
    }

    @Basic
    @Column(name = "CC_80_V")
    public Double getCc80V() {
        return cc80V;
    }

    public void setCc80V(Double cc80V) {
        this.cc80V = cc80V;
    }

    @Basic
    @Column(name = "CVR_50_V")
    public Double getCvr50V() {
        return cvr50V;
    }

    public void setCvr50V(Double cvr50V) {
        this.cvr50V = cvr50V;
    }

    @Basic
    @Column(name = "CVR_80_V")
    public Double getCvr80V() {
        return cvr80V;
    }

    public void setCvr80V(Double cvr80V) {
        this.cvr80V = cvr80V;
    }

    @Basic
    @Column(name = "rt_temp_in_V")
    public String getRtTempInV() {
        return rtTempInV;
    }

    public void setRtTempInV(String rtTempInV) {
        this.rtTempInV = rtTempInV;
    }

    @Basic
    @Column(name = "rt_spec_out_V")
    public String getRtSpecOutV() {
        return rtSpecOutV;
    }

    public void setRtSpecOutV(String rtSpecOutV) {
        this.rtSpecOutV = rtSpecOutV;
    }

    @Basic
    @Column(name = "rt_type_S")
    public String getRtTypeS() {
        return rtTypeS;
    }

    public void setRtTypeS(String rtTypeS) {
        this.rtTypeS = rtTypeS;
    }

    @Basic
    @Column(name = "rt_swp_area_S")
    public Double getRtSwpAreaS() {
        return rtSwpAreaS;
    }

    public void setRtSwpAreaS(Double rtSwpAreaS) {
        this.rtSwpAreaS = rtSwpAreaS;
    }

    @Basic
    @Column(name = "rt_efc_r_S")
    public Double getRtEfcRS() {
        return rtEfcRS;
    }

    public void setRtEfcRS(Double rtEfcRS) {
        this.rtEfcRS = rtEfcRS;
    }

    @Basic
    @Column(name = "rt_dia_out_S")
    public Double getRtDiaOutS() {
        return rtDiaOutS;
    }

    public void setRtDiaOutS(Double rtDiaOutS) {
        this.rtDiaOutS = rtDiaOutS;
    }

    @Basic
    @Column(name = "rt_dia_in_S")
    public Double getRtDiaInS() {
        return rtDiaInS;
    }

    public void setRtDiaInS(Double rtDiaInS) {
        this.rtDiaInS = rtDiaInS;
    }

    @Basic
    @Column(name = "rt_t_S")
    public Double getRtTS() {
        return rtTS;
    }

    public void setRtTS(Double rtTS) {
        this.rtTS = rtTS;
    }

    @Basic
    @Column(name = "rt_wm_S")
    public Double getRtWmS() {
        return rtWmS;
    }

    public void setRtWmS(Double rtWmS) {
        this.rtWmS = rtWmS;
    }

    @Basic
    @Column(name = "rt_wa_S")
    public Double getRtWaS() {
        return rtWaS;
    }

    public void setRtWaS(Double rtWaS) {
        this.rtWaS = rtWaS;
    }

    @Basic
    @Column(name = "rho_S")
    public Double getRhoS() {
        return rhoS;
    }

    public void setRhoS(Double rhoS) {
        this.rhoS = rhoS;
    }

    @Basic
    @Column(name = "CC_50_S")
    public Double getCc50S() {
        return cc50S;
    }

    public void setCc50S(Double cc50S) {
        this.cc50S = cc50S;
    }

    @Basic
    @Column(name = "CC_80_S")
    public Double getCc80S() {
        return cc80S;
    }

    public void setCc80S(Double cc80S) {
        this.cc80S = cc80S;
    }

    @Basic
    @Column(name = "CVR_50_S")
    public Double getCvr50S() {
        return cvr50S;
    }

    public void setCvr50S(Double cvr50S) {
        this.cvr50S = cvr50S;
    }

    @Basic
    @Column(name = "CVR_80_S")
    public Double getCvr80S() {
        return cvr80S;
    }

    public void setCvr80S(Double cvr80S) {
        this.cvr80S = cvr80S;
    }

    @Basic
    @Column(name = "rt_temp_in_S")
    public String getRtTempInS() {
        return rtTempInS;
    }

    public void setRtTempInS(String rtTempInS) {
        this.rtTempInS = rtTempInS;
    }

    @Basic
    @Column(name = "rt_spec_out_S")
    public String getRtSpecOutS() {
        return rtSpecOutS;
    }

    public void setRtSpecOutS(String rtSpecOutS) {
        this.rtSpecOutS = rtSpecOutS;
    }

    @Basic
    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasicDiscBrakeEntity that = (BasicDiscBrakeEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (pstD != null ? !pstD.equals(that.pstD) : that.pstD != null) return false;
        if (pstNum != null ? !pstNum.equals(that.pstNum) : that.pstNum != null) return false;
        if (pstArea != null ? !pstArea.equals(that.pstArea) : that.pstArea != null) return false;
        if (hfP != null ? !hfP.equals(that.hfP) : that.hfP != null) return false;
        if (pVcurve != null ? !pVcurve.equals(that.pVcurve) : that.pVcurve != null) return false;
        if (pvK != null ? !pvK.equals(that.pvK) : that.pvK != null) return false;
        if (pvB != null ? !pvB.equals(that.pvB) : that.pvB != null) return false;
        if (pvC != null ? !pvC.equals(that.pvC) : that.pvC != null) return false;
        if (linMat != null ? !linMat.equals(that.linMat) : that.linMat != null) return false;
        if (linMu != null ? !linMu.equals(that.linMu) : that.linMu != null) return false;
        if (linMuK != null ? !linMuK.equals(that.linMuK) : that.linMuK != null) return false;
        if (linMuE != null ? !linMuE.equals(that.linMuE) : that.linMuE != null) return false;
        if (linMuNp != null ? !linMuNp.equals(that.linMuNp) : that.linMuNp != null) return false;
        if (linArea != null ? !linArea.equals(that.linArea) : that.linArea != null) return false;
        if (linWearLim != null ? !linWearLim.equals(that.linWearLim) : that.linWearLim != null) return false;
        if (frtRtTempIn != null ? !frtRtTempIn.equals(that.frtRtTempIn) : that.frtRtTempIn != null) return false;
        if (frtLinWearOut != null ? !frtLinWearOut.equals(that.frtLinWearOut) : that.frtLinWearOut != null)
            return false;
        if (frtLinFrictOut != null ? !frtLinFrictOut.equals(that.frtLinFrictOut) : that.frtLinFrictOut != null)
            return false;
        if (perCorner != null ? !perCorner.equals(that.perCorner) : that.perCorner != null) return false;
        if (rtTypeV != null ? !rtTypeV.equals(that.rtTypeV) : that.rtTypeV != null) return false;
        if (rtSwpAreaV != null ? !rtSwpAreaV.equals(that.rtSwpAreaV) : that.rtSwpAreaV != null) return false;
        if (rtEfcRV != null ? !rtEfcRV.equals(that.rtEfcRV) : that.rtEfcRV != null) return false;
        if (rtDiaOutV != null ? !rtDiaOutV.equals(that.rtDiaOutV) : that.rtDiaOutV != null) return false;
        if (rtDiaInV != null ? !rtDiaInV.equals(that.rtDiaInV) : that.rtDiaInV != null) return false;
        if (rtInCkTV != null ? !rtInCkTV.equals(that.rtInCkTV) : that.rtInCkTV != null) return false;
        if (rtOutCkTV != null ? !rtOutCkTV.equals(that.rtOutCkTV) : that.rtOutCkTV != null) return false;
        if (rtTV != null ? !rtTV.equals(that.rtTV) : that.rtTV != null) return false;
        if (rtVanNumV != null ? !rtVanNumV.equals(that.rtVanNumV) : that.rtVanNumV != null) return false;
        if (rtVanLenV != null ? !rtVanLenV.equals(that.rtVanLenV) : that.rtVanLenV != null) return false;
        if (rtVaneHighV != null ? !rtVaneHighV.equals(that.rtVaneHighV) : that.rtVaneHighV != null) return false;
        if (rtVanTV != null ? !rtVanTV.equals(that.rtVanTV) : that.rtVanTV != null) return false;
        if (rtWmV != null ? !rtWmV.equals(that.rtWmV) : that.rtWmV != null) return false;
        if (rtWaV != null ? !rtWaV.equals(that.rtWaV) : that.rtWaV != null) return false;
        if (rhoV != null ? !rhoV.equals(that.rhoV) : that.rhoV != null) return false;
        if (cc50V != null ? !cc50V.equals(that.cc50V) : that.cc50V != null) return false;
        if (cc80V != null ? !cc80V.equals(that.cc80V) : that.cc80V != null) return false;
        if (cvr50V != null ? !cvr50V.equals(that.cvr50V) : that.cvr50V != null) return false;
        if (cvr80V != null ? !cvr80V.equals(that.cvr80V) : that.cvr80V != null) return false;
        if (rtTempInV != null ? !rtTempInV.equals(that.rtTempInV) : that.rtTempInV != null) return false;
        if (rtSpecOutV != null ? !rtSpecOutV.equals(that.rtSpecOutV) : that.rtSpecOutV != null) return false;
        if (rtTypeS != null ? !rtTypeS.equals(that.rtTypeS) : that.rtTypeS != null) return false;
        if (rtSwpAreaS != null ? !rtSwpAreaS.equals(that.rtSwpAreaS) : that.rtSwpAreaS != null) return false;
        if (rtEfcRS != null ? !rtEfcRS.equals(that.rtEfcRS) : that.rtEfcRS != null) return false;
        if (rtDiaOutS != null ? !rtDiaOutS.equals(that.rtDiaOutS) : that.rtDiaOutS != null) return false;
        if (rtDiaInS != null ? !rtDiaInS.equals(that.rtDiaInS) : that.rtDiaInS != null) return false;
        if (rtTS != null ? !rtTS.equals(that.rtTS) : that.rtTS != null) return false;
        if (rtWmS != null ? !rtWmS.equals(that.rtWmS) : that.rtWmS != null) return false;
        if (rtWaS != null ? !rtWaS.equals(that.rtWaS) : that.rtWaS != null) return false;
        if (rhoS != null ? !rhoS.equals(that.rhoS) : that.rhoS != null) return false;
        if (cc50S != null ? !cc50S.equals(that.cc50S) : that.cc50S != null) return false;
        if (cc80S != null ? !cc80S.equals(that.cc80S) : that.cc80S != null) return false;
        if (cvr50S != null ? !cvr50S.equals(that.cvr50S) : that.cvr50S != null) return false;
        if (cvr80S != null ? !cvr80S.equals(that.cvr80S) : that.cvr80S != null) return false;
        if (rtTempInS != null ? !rtTempInS.equals(that.rtTempInS) : that.rtTempInS != null) return false;
        if (rtSpecOutS != null ? !rtSpecOutS.equals(that.rtSpecOutS) : that.rtSpecOutS != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (pstD != null ? pstD.hashCode() : 0);
        result = 31 * result + (pstNum != null ? pstNum.hashCode() : 0);
        result = 31 * result + (pstArea != null ? pstArea.hashCode() : 0);
        result = 31 * result + (hfP != null ? hfP.hashCode() : 0);
        result = 31 * result + (pVcurve != null ? pVcurve.hashCode() : 0);
        result = 31 * result + (pvK != null ? pvK.hashCode() : 0);
        result = 31 * result + (pvB != null ? pvB.hashCode() : 0);
        result = 31 * result + (pvC != null ? pvC.hashCode() : 0);
        result = 31 * result + (linMat != null ? linMat.hashCode() : 0);
        result = 31 * result + (linMu != null ? linMu.hashCode() : 0);
        result = 31 * result + (linMuK != null ? linMuK.hashCode() : 0);
        result = 31 * result + (linMuE != null ? linMuE.hashCode() : 0);
        result = 31 * result + (linMuNp != null ? linMuNp.hashCode() : 0);
        result = 31 * result + (linArea != null ? linArea.hashCode() : 0);
        result = 31 * result + (linWearLim != null ? linWearLim.hashCode() : 0);
        result = 31 * result + (frtRtTempIn != null ? frtRtTempIn.hashCode() : 0);
        result = 31 * result + (frtLinWearOut != null ? frtLinWearOut.hashCode() : 0);
        result = 31 * result + (frtLinFrictOut != null ? frtLinFrictOut.hashCode() : 0);
        result = 31 * result + (perCorner != null ? perCorner.hashCode() : 0);
        result = 31 * result + (rtTypeV != null ? rtTypeV.hashCode() : 0);
        result = 31 * result + (rtSwpAreaV != null ? rtSwpAreaV.hashCode() : 0);
        result = 31 * result + (rtEfcRV != null ? rtEfcRV.hashCode() : 0);
        result = 31 * result + (rtDiaOutV != null ? rtDiaOutV.hashCode() : 0);
        result = 31 * result + (rtDiaInV != null ? rtDiaInV.hashCode() : 0);
        result = 31 * result + (rtInCkTV != null ? rtInCkTV.hashCode() : 0);
        result = 31 * result + (rtOutCkTV != null ? rtOutCkTV.hashCode() : 0);
        result = 31 * result + (rtTV != null ? rtTV.hashCode() : 0);
        result = 31 * result + (rtVanNumV != null ? rtVanNumV.hashCode() : 0);
        result = 31 * result + (rtVanLenV != null ? rtVanLenV.hashCode() : 0);
        result = 31 * result + (rtVaneHighV != null ? rtVaneHighV.hashCode() : 0);
        result = 31 * result + (rtVanTV != null ? rtVanTV.hashCode() : 0);
        result = 31 * result + (rtWmV != null ? rtWmV.hashCode() : 0);
        result = 31 * result + (rtWaV != null ? rtWaV.hashCode() : 0);
        result = 31 * result + (rhoV != null ? rhoV.hashCode() : 0);
        result = 31 * result + (cc50V != null ? cc50V.hashCode() : 0);
        result = 31 * result + (cc80V != null ? cc80V.hashCode() : 0);
        result = 31 * result + (cvr50V != null ? cvr50V.hashCode() : 0);
        result = 31 * result + (cvr80V != null ? cvr80V.hashCode() : 0);
        result = 31 * result + (rtTempInV != null ? rtTempInV.hashCode() : 0);
        result = 31 * result + (rtSpecOutV != null ? rtSpecOutV.hashCode() : 0);
        result = 31 * result + (rtTypeS != null ? rtTypeS.hashCode() : 0);
        result = 31 * result + (rtSwpAreaS != null ? rtSwpAreaS.hashCode() : 0);
        result = 31 * result + (rtEfcRS != null ? rtEfcRS.hashCode() : 0);
        result = 31 * result + (rtDiaOutS != null ? rtDiaOutS.hashCode() : 0);
        result = 31 * result + (rtDiaInS != null ? rtDiaInS.hashCode() : 0);
        result = 31 * result + (rtTS != null ? rtTS.hashCode() : 0);
        result = 31 * result + (rtWmS != null ? rtWmS.hashCode() : 0);
        result = 31 * result + (rtWaS != null ? rtWaS.hashCode() : 0);
        result = 31 * result + (rhoS != null ? rhoS.hashCode() : 0);
        result = 31 * result + (cc50S != null ? cc50S.hashCode() : 0);
        result = 31 * result + (cc80S != null ? cc80S.hashCode() : 0);
        result = 31 * result + (cvr50S != null ? cvr50S.hashCode() : 0);
        result = 31 * result + (cvr80S != null ? cvr80S.hashCode() : 0);
        result = 31 * result + (rtTempInS != null ? rtTempInS.hashCode() : 0);
        result = 31 * result + (rtSpecOutS != null ? rtSpecOutS.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
