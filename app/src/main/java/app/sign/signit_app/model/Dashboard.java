package app.sign.signit_app.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dashboard {
    @SerializedName("DS_ID")
    @Expose
    private String dSID;
    @SerializedName("NAME")
    @Expose
    private String nAME;
    @SerializedName("SUBJECT")
    @Expose
    private Object sUBJECT;
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
    private Object eXPIERYDATE;
    @SerializedName("INTERVAL_DAYS")
    @Expose
    private Object iNTERVALDAYS;
    @SerializedName("CANCELATION_REASON")
    @Expose
    private Object cANCELATIONREASON;
    @SerializedName("IS_COPIED")
    @Expose
    private String iSCOPIED;
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
    private Object cOMPLETEDON;
    @SerializedName("UPDATED_ON")
    @Expose
    private Object uPDATEDON;
    @SerializedName("UPDATED_BY")
    @Expose
    private Object uPDATEDBY;

    public Dashboard(String dSID, String nAME, String pARTIES, String pATH, String iMGPATH, String iMGCOUNT, Object eXPIERYDATE, String uSERID, String cREATEDON) {
        this.dSID = dSID;
        this.nAME = nAME;
        this.pARTIES = pARTIES;
        this.pATH = pATH;
        this.iMGPATH = iMGPATH;
        this.iMGCOUNT = iMGCOUNT;
        this.eXPIERYDATE = eXPIERYDATE;
        this.uSERID = uSERID;
        this.cREATEDON = cREATEDON;
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

    public Object getSUBJECT() {
        return sUBJECT;
    }

    public void setSUBJECT(Object sUBJECT) {
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

    public Object getEXPIERYDATE() {
        return eXPIERYDATE;
    }

    public void setEXPIERYDATE(Object eXPIERYDATE) {
        this.eXPIERYDATE = eXPIERYDATE;
    }

    public Object getINTERVALDAYS() {
        return iNTERVALDAYS;
    }

    public void setINTERVALDAYS(Object iNTERVALDAYS) {
        this.iNTERVALDAYS = iNTERVALDAYS;
    }

    public Object getCANCELATIONREASON() {
        return cANCELATIONREASON;
    }

    public void setCANCELATIONREASON(Object cANCELATIONREASON) {
        this.cANCELATIONREASON = cANCELATIONREASON;
    }

    public String getISCOPIED() {
        return iSCOPIED;
    }

    public void setISCOPIED(String iSCOPIED) {
        this.iSCOPIED = iSCOPIED;
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

    public Object getCOMPLETEDON() {
        return cOMPLETEDON;
    }

    public void setCOMPLETEDON(Object cOMPLETEDON) {
        this.cOMPLETEDON = cOMPLETEDON;
    }

    public Object getUPDATEDON() {
        return uPDATEDON;
    }

    public void setUPDATEDON(Object uPDATEDON) {
        this.uPDATEDON = uPDATEDON;
    }

    public Object getUPDATEDBY() {
        return uPDATEDBY;
    }

    public void setUPDATEDBY(Object uPDATEDBY) {
        this.uPDATEDBY = uPDATEDBY;
    }

}
