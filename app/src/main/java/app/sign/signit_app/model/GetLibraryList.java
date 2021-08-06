package app.sign.signit_app.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetLibraryList {

    @SerializedName("DS_ID")
    @Expose
    private String dSID;
    @SerializedName("NAME")
    @Expose
    private String nAME;
    @SerializedName("SUBJECT")
    @Expose
    private String sUBJECT;
    @SerializedName("PARTIES")
    @Expose
    private String pARTIES;
    @SerializedName("PARTIES_EMAIL")
    @Expose
    private String pARTIESEMAIL;
    @SerializedName("PATH")
    @Expose
    private String pATH;
    @SerializedName("IMG_PATH")
    @Expose
    private String iMGPATH;
    @SerializedName("IMG_COUNT")
    @Expose
    private String iMGCOUNT;
    @SerializedName("TYPE")
    @Expose
    private String tYPE;
    @SerializedName("STATUS")
    @Expose
    private String sTATUS;
    @SerializedName("STATUS_NM")
    @Expose
    private String sTATUSNM;
    @SerializedName("FP_ID")
    @Expose
    private String fPID;
    @SerializedName("EXPIERY_DATE")
    @Expose
    private String eXPIERYDATE;
    @SerializedName("NO_OF_DAYS")
    @Expose
    private String nOOFDAYS;
    @SerializedName("LAST_REMINDER_DATE")
    @Expose
    private String lASTREMINDERDATE;
    @SerializedName("CANCELATION_REASON")
    @Expose
    private String cANCELATIONREASON;
    @SerializedName("IS_DELETED")
    @Expose
    private String iSDELETED;
    @SerializedName("OA_ID")
    @Expose
    private String oAID;
    @SerializedName("OA_BRAND_ID")
    @Expose
    private String oABRANDID;
    @SerializedName("USER_ID")
    @Expose
    private String uSERID;
    @SerializedName("CREATED_ON")
    @Expose
    private String cREATEDON;
    @SerializedName("CREATED_BY")
    @Expose
    private String cREATEDBY;
    @SerializedName("SENT_ON")
    @Expose
    private String sENTON;
    @SerializedName("COMPLETED_ON")
    @Expose
    private String cOMPLETEDON;
    @SerializedName("UPDATED_ON")
    @Expose
    private String uPDATEDON;
    @SerializedName("UPDATED_BY")
    @Expose
    private String uPDATEDBY;
    @SerializedName("party_details")
    @Expose
    private List<PartyDetail> partyDetails = null;

    public GetLibraryList(String dSID, String nAME, String sUBJECT, String pARTIES, String pARTIESEMAIL, String pATH, String iMGPATH, String iMGCOUNT, String tYPE, String sTATUS, String sTATUSNM, String fPID, String eXPIERYDATE, String nOOFDAYS, String lASTREMINDERDATE, String cANCELATIONREASON, String iSDELETED, String oAID, String oABRANDID, String uSERID, String cREATEDON, String cREATEDBY, String sENTON, String cOMPLETEDON, String uPDATEDON, String uPDATEDBY, List<PartyDetail> partyDetails) {
        this.dSID = dSID;
        this.nAME = nAME;
        this.sUBJECT = sUBJECT;
        this.pARTIES = pARTIES;
        this.pARTIESEMAIL = pARTIESEMAIL;
        this.pATH = pATH;
        this.iMGPATH = iMGPATH;
        this.iMGCOUNT = iMGCOUNT;
        this.tYPE = tYPE;
        this.sTATUS = sTATUS;
        this.sTATUSNM = sTATUSNM;
        this.fPID = fPID;
        this.eXPIERYDATE = eXPIERYDATE;
        this.nOOFDAYS = nOOFDAYS;
        this.lASTREMINDERDATE = lASTREMINDERDATE;
        this.cANCELATIONREASON = cANCELATIONREASON;
        this.iSDELETED = iSDELETED;
        this.oAID = oAID;
        this.oABRANDID = oABRANDID;
        this.uSERID = uSERID;
        this.cREATEDON = cREATEDON;
        this.cREATEDBY = cREATEDBY;
        this.sENTON = sENTON;
        this.cOMPLETEDON = cOMPLETEDON;
        this.uPDATEDON = uPDATEDON;
        this.uPDATEDBY = uPDATEDBY;
        this.partyDetails = partyDetails;
    }

    public String getDSID() {
        return dSID;
    }

    public void setDSID(String dSID) {
        this.dSID = dSID;
    }

    public String getNAME() {
        return nAME;
    }

    public void setNAME(String nAME) {
        this.nAME = nAME;
    }

    public String getSUBJECT() {
        return sUBJECT;
    }

    public void setSUBJECT(String sUBJECT) {
        this.sUBJECT = sUBJECT;
    }

    public String getPARTIES() {
        return pARTIES;
    }

    public void setPARTIES(String pARTIES) {
        this.pARTIES = pARTIES;
    }

    public String getPARTIESEMAIL() {
        return pARTIESEMAIL;
    }

    public void setPARTIESEMAIL(String pARTIESEMAIL) {
        this.pARTIESEMAIL = pARTIESEMAIL;
    }

    public String getPATH() {
        return pATH;
    }

    public void setPATH(String pATH) {
        this.pATH = pATH;
    }

    public String getIMGPATH() {
        return iMGPATH;
    }

    public void setIMGPATH(String iMGPATH) {
        this.iMGPATH = iMGPATH;
    }

    public String getIMGCOUNT() {
        return iMGCOUNT;
    }

    public void setIMGCOUNT(String iMGCOUNT) {
        this.iMGCOUNT = iMGCOUNT;
    }

    public String getTYPE() {
        return tYPE;
    }

    public void setTYPE(String tYPE) {
        this.tYPE = tYPE;
    }

    public String getSTATUS() {
        return sTATUS;
    }

    public void setSTATUS(String sTATUS) {
        this.sTATUS = sTATUS;
    }

    public String getSTATUSNM() {
        return sTATUSNM;
    }

    public void setSTATUSNM(String sTATUSNM) {
        this.sTATUSNM = sTATUSNM;
    }

    public String getFPID() {
        return fPID;
    }

    public void setFPID(String fPID) {
        this.fPID = fPID;
    }

    public String getEXPIERYDATE() {
        return eXPIERYDATE;
    }

    public void setEXPIERYDATE(String eXPIERYDATE) {
        this.eXPIERYDATE = eXPIERYDATE;
    }

    public String getNOOFDAYS() {
        return nOOFDAYS;
    }

    public void setNOOFDAYS(String nOOFDAYS) {
        this.nOOFDAYS = nOOFDAYS;
    }

    public String getLASTREMINDERDATE() {
        return lASTREMINDERDATE;
    }

    public void setLASTREMINDERDATE(String lASTREMINDERDATE) {
        this.lASTREMINDERDATE = lASTREMINDERDATE;
    }

    public String getCANCELATIONREASON() {
        return cANCELATIONREASON;
    }

    public void setCANCELATIONREASON(String cANCELATIONREASON) {
        this.cANCELATIONREASON = cANCELATIONREASON;
    }

    public String getISDELETED() {
        return iSDELETED;
    }

    public void setISDELETED(String iSDELETED) {
        this.iSDELETED = iSDELETED;
    }

    public String getOAID() {
        return oAID;
    }

    public void setOAID(String oAID) {
        this.oAID = oAID;
    }

    public String getOABRANDID() {
        return oABRANDID;
    }

    public void setOABRANDID(String oABRANDID) {
        this.oABRANDID = oABRANDID;
    }

    public String getUSERID() {
        return uSERID;
    }

    public void setUSERID(String uSERID) {
        this.uSERID = uSERID;
    }

    public String getCREATEDON() {
        return cREATEDON;
    }

    public void setCREATEDON(String cREATEDON) {
        this.cREATEDON = cREATEDON;
    }

    public String getCREATEDBY() {
        return cREATEDBY;
    }

    public void setCREATEDBY(String cREATEDBY) {
        this.cREATEDBY = cREATEDBY;
    }

    public String getSENTON() {
        return sENTON;
    }

    public void setSENTON(String sENTON) {
        this.sENTON = sENTON;
    }

    public String getCOMPLETEDON() {
        return cOMPLETEDON;
    }

    public void setCOMPLETEDON(String cOMPLETEDON) {
        this.cOMPLETEDON = cOMPLETEDON;
    }

    public String getUPDATEDON() {
        return uPDATEDON;
    }

    public void setUPDATEDON(String uPDATEDON) {
        this.uPDATEDON = uPDATEDON;
    }

    public String getUPDATEDBY() {
        return uPDATEDBY;
    }

    public void setUPDATEDBY(String uPDATEDBY) {
        this.uPDATEDBY = uPDATEDBY;
    }

    public List<PartyDetail> getPartyDetails() {
        return partyDetails;
    }

    public void setPartyDetails(List<PartyDetail> partyDetails) {
        this.partyDetails = partyDetails;
    }

}
