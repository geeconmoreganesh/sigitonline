package app.sign.signit_app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DocketFields {

    @SerializedName("ELEMENT_ID")
    @Expose
    private String eLEMENTID;
    @SerializedName("DS_ID")
    @Expose
    private String dSID;
    @SerializedName("PARTY_ID")
    @Expose
    private String pARTYID;
    @SerializedName("PARTY_NAME")
    @Expose
    private String pARTYNAME;
    @SerializedName("PARTY_COLOR")
    @Expose
    private String pARTYCOLOR;
    @SerializedName("PAGE_NO")
    @Expose
    private String pAGENO;
    @SerializedName("ELEMENT_TYPE")
    @Expose
    private String eLEMENTTYPE;
    @SerializedName("ELEMENT_NAME")
    @Expose
    private String eLEMENTNAME;
    @SerializedName("REQUIRED")
    @Expose
    private String rEQUIRED;
    @SerializedName("READONLY")
    @Expose
    private String rEADONLY;
    @SerializedName("ELEMENT_TXT")
    @Expose
    private String eLEMENTTXT;
    @SerializedName("ELEMENT_X")
    @Expose
    private String eLEMENTX;
    @SerializedName("ELEMENT_Y")
    @Expose
    private String eLEMENTY;
    @SerializedName("PDF_X")
    @Expose
    private String pDFX;
    @SerializedName("PDF_Y")
    @Expose
    private String pDFY;
    @SerializedName("ELEMENT_W")
    @Expose
    private String eLEMENTW;
    @SerializedName("ELEMENT_H")
    @Expose
    private String eLEMENTH;
    @SerializedName("PDF_W")
    @Expose
    private String pDFW;
    @SerializedName("PDF_H")
    @Expose
    private String pDFH;
    @SerializedName("ELEMENT_TITLE")
    @Expose
    private String eLEMENTTITLE;
    @SerializedName("FONT_FAMILY")
    @Expose
    private String fONTFAMILY;
    @SerializedName("FONT_SIZE")
    @Expose
    private String fONTSIZE;
    @SerializedName("VALIDATION")
    @Expose
    private String vALIDATION;
    @SerializedName("PLACEHOLDER")
    @Expose
    private String pLACEHOLDER;
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
    private String uPDATEDON;
    @SerializedName("UPDATED_BY")
    @Expose
    private String uPDATEDBY;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DocketFields() {
    }

    /**
     * 
     * @param rEADONLY
     * @param eLEMENTH
     * @param oABRANDID
     * @param pARTYNAME
     * @param pARTYID
     * @param eLEMENTX
     * @param eLEMENTY
     * @param pDFY
     * @param fONTSIZE
     * @param eLEMENTTYPE
     * @param pDFX
     * @param pDFW
     * @param eLEMENTW
     * @param cREATEDON
     * @param uSERID
     * @param fONTFAMILY
     * @param pLACEHOLDER
     * @param rEQUIRED
     * @param dSID
     * @param pAGENO
     * @param pDFH
     * @param vALIDATION
     * @param eLEMENTNAME
     * @param iSDELETED
     * @param eLEMENTID
     * @param eLEMENTTITLE
     * @param eLEMENTTXT
     * @param oAID
     * @param pARTYCOLOR
     */
    public DocketFields(String eLEMENTID, String dSID, String pARTYID, String pARTYNAME, String pARTYCOLOR, String pAGENO, String eLEMENTTYPE, String eLEMENTNAME, String rEQUIRED, String rEADONLY, String eLEMENTTXT, String eLEMENTX, String eLEMENTY, String pDFX, String pDFY, String eLEMENTW, String eLEMENTH, String pDFW, String pDFH, String eLEMENTTITLE, String fONTFAMILY, String fONTSIZE, String vALIDATION, String pLACEHOLDER, String iSDELETED, String oAID, String oABRANDID, String uSERID, String cREATEDON) {
        super();
        this.eLEMENTID = eLEMENTID;
        this.dSID = dSID;
        this.pARTYID = pARTYID;
        this.pARTYNAME = pARTYNAME;
        this.pARTYCOLOR = pARTYCOLOR;
        this.pAGENO = pAGENO;
        this.eLEMENTTYPE = eLEMENTTYPE;
        this.eLEMENTNAME = eLEMENTNAME;
        this.rEQUIRED = rEQUIRED;
        this.rEADONLY = rEADONLY;
        this.eLEMENTTXT = eLEMENTTXT;
        this.eLEMENTX = eLEMENTX;
        this.eLEMENTY = eLEMENTY;
        this.pDFX = pDFX;
        this.pDFY = pDFY;
        this.eLEMENTW = eLEMENTW;
        this.eLEMENTH = eLEMENTH;
        this.pDFW = pDFW;
        this.pDFH = pDFH;
        this.eLEMENTTITLE = eLEMENTTITLE;
        this.fONTFAMILY = fONTFAMILY;
        this.fONTSIZE = fONTSIZE;
        this.vALIDATION = vALIDATION;
        this.pLACEHOLDER = pLACEHOLDER;
        this.iSDELETED = iSDELETED;
        this.oAID = oAID;
        this.oABRANDID = oABRANDID;
        this.uSERID = uSERID;
        this.cREATEDON = cREATEDON;
    }

    public String getELEMENTID() {
        return eLEMENTID;
    }

    public void setELEMENTID(String eLEMENTID) {
        this.eLEMENTID = eLEMENTID;
    }

    public String getDSID() {
        return dSID;
    }

    public void setDSID(String dSID) {
        this.dSID = dSID;
    }

    public String getPARTYID() {
        return pARTYID;
    }

    public void setPARTYID(String pARTYID) {
        this.pARTYID = pARTYID;
    }

    public String getPARTYNAME() {
        return pARTYNAME;
    }

    public void setPARTYNAME(String pARTYNAME) {
        this.pARTYNAME = pARTYNAME;
    }

    public String getPARTYCOLOR() {
        return pARTYCOLOR;
    }

    public void setPARTYCOLOR(String pARTYCOLOR) {
        this.pARTYCOLOR = pARTYCOLOR;
    }

    public String getPAGENO() {
        return pAGENO;
    }

    public void setPAGENO(String pAGENO) {
        this.pAGENO = pAGENO;
    }

    public String getELEMENTTYPE() {
        return eLEMENTTYPE;
    }

    public void setELEMENTTYPE(String eLEMENTTYPE) {
        this.eLEMENTTYPE = eLEMENTTYPE;
    }

    public String getELEMENTNAME() {
        return eLEMENTNAME;
    }

    public void setELEMENTNAME(String eLEMENTNAME) {
        this.eLEMENTNAME = eLEMENTNAME;
    }

    public String getREQUIRED() {
        return rEQUIRED;
    }

    public void setREQUIRED(String rEQUIRED) {
        this.rEQUIRED = rEQUIRED;
    }

    public String getREADONLY() {
        return rEADONLY;
    }

    public void setREADONLY(String rEADONLY) {
        this.rEADONLY = rEADONLY;
    }

    public String getELEMENTTXT() {
        return eLEMENTTXT;
    }

    public void setELEMENTTXT(String eLEMENTTXT) {
        this.eLEMENTTXT = eLEMENTTXT;
    }

    public String getELEMENTX() {
        return eLEMENTX;
    }

    public void setELEMENTX(String eLEMENTX) {
        this.eLEMENTX = eLEMENTX;
    }

    public String getELEMENTY() {
        return eLEMENTY;
    }

    public void setELEMENTY(String eLEMENTY) {
        this.eLEMENTY = eLEMENTY;
    }

    public String getPDFX() {
        return pDFX;
    }

    public void setPDFX(String pDFX) {
        this.pDFX = pDFX;
    }

    public String getPDFY() {
        return pDFY;
    }

    public void setPDFY(String pDFY) {
        this.pDFY = pDFY;
    }

    public String getELEMENTW() {
        return eLEMENTW;
    }

    public void setELEMENTW(String eLEMENTW) {
        this.eLEMENTW = eLEMENTW;
    }

    public String getELEMENTH() {
        return eLEMENTH;
    }

    public void setELEMENTH(String eLEMENTH) {
        this.eLEMENTH = eLEMENTH;
    }

    public String getPDFW() {
        return pDFW;
    }

    public void setPDFW(String pDFW) {
        this.pDFW = pDFW;
    }

    public String getPDFH() {
        return pDFH;
    }

    public void setPDFH(String pDFH) {
        this.pDFH = pDFH;
    }

    public String getELEMENTTITLE() {
        return eLEMENTTITLE;
    }

    public void setELEMENTTITLE(String eLEMENTTITLE) {
        this.eLEMENTTITLE = eLEMENTTITLE;
    }

    public String getFONTFAMILY() {
        return fONTFAMILY;
    }

    public void setFONTFAMILY(String fONTFAMILY) {
        this.fONTFAMILY = fONTFAMILY;
    }

    public String getFONTSIZE() {
        return fONTSIZE;
    }

    public void setFONTSIZE(String fONTSIZE) {
        this.fONTSIZE = fONTSIZE;
    }

    public String getVALIDATION() {
        return vALIDATION;
    }

    public void setVALIDATION(String vALIDATION) {
        this.vALIDATION = vALIDATION;
    }

    public String getPLACEHOLDER() {
        return pLACEHOLDER;
    }

    public void setPLACEHOLDER(String pLACEHOLDER) {
        this.pLACEHOLDER = pLACEHOLDER;
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

}
