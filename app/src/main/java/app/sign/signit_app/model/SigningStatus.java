package app.sign.signit_app.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SigningStatus {

    @SerializedName("PARTY_ID")
    @Expose
    private String pARTYID;
    @SerializedName("DS_ID")
    @Expose
    private String dSID;
    @SerializedName("PARTY_NAME")
    @Expose
    private String pARTYNAME;
    @SerializedName("PARTY_EMAIL")
    @Expose
    private String pARTYEMAIL;
    @SerializedName("PARTY_ROLE")
    @Expose
    private String pARTYROLE;
    @SerializedName("MESSAGE")
    @Expose
    private String mESSAGE;
    @SerializedName("PARTY_STATUS")
    @Expose
    private String pARTYSTATUS;
    @SerializedName("PARTY_STATUS_NM")
    @Expose
    private String pARTYSTATUSNM;
    @SerializedName("PARTY_COLOR")
    @Expose
    private String pARTYCOLOR;
    @SerializedName("SIGNING_ORDER")
    @Expose
    private String sIGNINGORDER;
    @SerializedName("SIGNED_ON")
    @Expose
    private Object sIGNEDON;
    @SerializedName("REJECTED_ON")
    @Expose
    private Object rEJECTEDON;
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
    @SerializedName("UPDATED_ON")
    @Expose
    private Object uPDATEDON;
    @SerializedName("UPDATED_BY")
    @Expose
    private Object uPDATEDBY;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SigningStatus() {
    }

    /**
     * 
     * @param pARTYROLE
     * @param dSID
     * @param pARTYSTATUSNM
     * @param uPDATEDBY
     * @param iSDELETED
     * @param oABRANDID
     * @param pARTYEMAIL
     * @param pARTYNAME
     * @param uPDATEDON
     * @param pARTYID
     * @param cREATEDBY
     * @param pARTYSTATUS
     * @param sIGNINGORDER
     * @param cREATEDON
     * @param mESSAGE
     * @param sIGNEDON
     * @param rEJECTEDON
     * @param oAID
     * @param pARTYCOLOR
     * @param uSERID
     */
    public SigningStatus(String pARTYID, String dSID, String pARTYNAME, String pARTYEMAIL, String pARTYROLE, String mESSAGE, String pARTYSTATUS, String pARTYSTATUSNM, String pARTYCOLOR, String sIGNINGORDER, Object sIGNEDON, Object rEJECTEDON, String iSDELETED, String oAID, String oABRANDID, String uSERID, String cREATEDON, String cREATEDBY, Object uPDATEDON, Object uPDATEDBY) {
        super();
        this.pARTYID = pARTYID;
        this.dSID = dSID;
        this.pARTYNAME = pARTYNAME;
        this.pARTYEMAIL = pARTYEMAIL;
        this.pARTYROLE = pARTYROLE;
        this.mESSAGE = mESSAGE;
        this.pARTYSTATUS = pARTYSTATUS;
        this.pARTYSTATUSNM = pARTYSTATUSNM;
        this.pARTYCOLOR = pARTYCOLOR;
        this.sIGNINGORDER = sIGNINGORDER;
        this.sIGNEDON = sIGNEDON;
        this.rEJECTEDON = rEJECTEDON;
        this.iSDELETED = iSDELETED;
        this.oAID = oAID;
        this.oABRANDID = oABRANDID;
        this.uSERID = uSERID;
        this.cREATEDON = cREATEDON;
        this.cREATEDBY = cREATEDBY;
        this.uPDATEDON = uPDATEDON;
        this.uPDATEDBY = uPDATEDBY;
    }

    public String getPARTYID() {
        return pARTYID;
    }

    public void setPARTYID(String pARTYID) {
        this.pARTYID = pARTYID;
    }

    public String getDSID() {
        return dSID;
    }

    public void setDSID(String dSID) {
        this.dSID = dSID;
    }

    public String getPARTYNAME() {
        return pARTYNAME;
    }

    public void setPARTYNAME(String pARTYNAME) {
        this.pARTYNAME = pARTYNAME;
    }

    public String getPARTYEMAIL() {
        return pARTYEMAIL;
    }

    public void setPARTYEMAIL(String pARTYEMAIL) {
        this.pARTYEMAIL = pARTYEMAIL;
    }

    public String getPARTYROLE() {
        return pARTYROLE;
    }

    public void setPARTYROLE(String pARTYROLE) {
        this.pARTYROLE = pARTYROLE;
    }

    public String getMESSAGE() {
        return mESSAGE;
    }

    public void setMESSAGE(String mESSAGE) {
        this.mESSAGE = mESSAGE;
    }

    public String getPARTYSTATUS() {
        return pARTYSTATUS;
    }

    public void setPARTYSTATUS(String pARTYSTATUS) {
        this.pARTYSTATUS = pARTYSTATUS;
    }

    public String getPARTYSTATUSNM() {
        return pARTYSTATUSNM;
    }

    public void setPARTYSTATUSNM(String pARTYSTATUSNM) {
        this.pARTYSTATUSNM = pARTYSTATUSNM;
    }

    public String getPARTYCOLOR() {
        return pARTYCOLOR;
    }

    public void setPARTYCOLOR(String pARTYCOLOR) {
        this.pARTYCOLOR = pARTYCOLOR;
    }

    public String getSIGNINGORDER() {
        return sIGNINGORDER;
    }

    public void setSIGNINGORDER(String sIGNINGORDER) {
        this.sIGNINGORDER = sIGNINGORDER;
    }

    public Object getSIGNEDON() {
        return sIGNEDON;
    }

    public void setSIGNEDON(Object sIGNEDON) {
        this.sIGNEDON = sIGNEDON;
    }

    public Object getREJECTEDON() {
        return rEJECTEDON;
    }

    public void setREJECTEDON(Object rEJECTEDON) {
        this.rEJECTEDON = rEJECTEDON;
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
