package app.sign.signit_app.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DocketHistory {

    @SerializedName("DSH_ID")
    @Expose
    private String dSHID;
    @SerializedName("DS_ID")
    @Expose
    private String dSID;
    @SerializedName("MSG")
    @Expose
    private String mSG;
    @SerializedName("IS_DELELTED")
    @Expose
    private String iSDELELTED;
    @SerializedName("OA_ID")
    @Expose
    private String oAID;
    @SerializedName("OA_BRAND_ID")
    @Expose
    private String oABRANDID;
    @SerializedName("USER_ID")
    @Expose
    private String uSERID;
    @SerializedName("CREATED_BY")
    @Expose
    private Object cREATEDBY;
    @SerializedName("CREATED_ON")
    @Expose
    private String cREATEDON;
    @SerializedName("UPDATED_BY")
    @Expose
    private String uPDATEDBY;
    @SerializedName("UPDATED_ON")
    @Expose
    private String uPDATEDON;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DocketHistory() {
    }

    /**
     * 
     * @param mSG
     * @param dSID
     * @param uPDATEDBY
     * @param iSDELELTED
     * @param cREATEDON
     * @param oABRANDID
     * @param dSHID
     * @param uPDATEDON
     * @param oAID
     * @param uSERID
     * @param cREATEDBY
     */
    public DocketHistory(String dSHID, String dSID, String mSG, String iSDELELTED, String oAID, String oABRANDID, String uSERID, Object cREATEDBY, String cREATEDON, String uPDATEDBY, String uPDATEDON) {
        super();
        this.dSHID = dSHID;
        this.dSID = dSID;
        this.mSG = mSG;
        this.iSDELELTED = iSDELELTED;
        this.oAID = oAID;
        this.oABRANDID = oABRANDID;
        this.uSERID = uSERID;
        this.cREATEDBY = cREATEDBY;
        this.cREATEDON = cREATEDON;
        this.uPDATEDBY = uPDATEDBY;
        this.uPDATEDON = uPDATEDON;
    }

    public String getDSHID() {
        return dSHID;
    }

    public void setDSHID(String dSHID) {
        this.dSHID = dSHID;
    }

    public String getDSID() {
        return dSID;
    }

    public void setDSID(String dSID) {
        this.dSID = dSID;
    }

    public String getMSG() {
        return mSG;
    }

    public void setMSG(String mSG) {
        this.mSG = mSG;
    }

    public String getISDELELTED() {
        return iSDELELTED;
    }

    public void setISDELELTED(String iSDELELTED) {
        this.iSDELELTED = iSDELELTED;
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

    public Object getCREATEDBY() {
        return cREATEDBY;
    }

    public void setCREATEDBY(Object cREATEDBY) {
        this.cREATEDBY = cREATEDBY;
    }

    public String getCREATEDON() {
        return cREATEDON;
    }

    public void setCREATEDON(String cREATEDON) {
        this.cREATEDON = cREATEDON;
    }

    public String getUPDATEDBY() {
        return uPDATEDBY;
    }

    public void setUPDATEDBY(String uPDATEDBY) {
        this.uPDATEDBY = uPDATEDBY;
    }

    public String getUPDATEDON() {
        return uPDATEDON;
    }

    public void setUPDATEDON(String uPDATEDON) {
        this.uPDATEDON = uPDATEDON;
    }

}
