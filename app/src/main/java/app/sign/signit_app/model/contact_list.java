package app.sign.signit_app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class contact_list {
    @SerializedName("CONTACT_ID")
    @Expose
    private String cONTACT_ID;
    @SerializedName("CONTACT_PERSON")
    @Expose
    private String cONTACT_PERSON;
    @SerializedName("EMAIL")
    @Expose
    private String eMAIL;
    @SerializedName("TELEPHONE")
    @Expose
    private String tELEPHONE;

    @SerializedName("OA_ID")
    @Expose
    private String oA_ID;
    @SerializedName("OA_BRAND_ID")
    @Expose
    private String oA_BRAND_ID;
    @SerializedName("OA_CD")
    @Expose
    private String oA_CD;
    @SerializedName("USER_ID")
    @Expose
    private String uSER_ID;

    public contact_list(String cONTACT_ID, String cONTACT_PERSON, String eMAIL, String tELEPHONE,String oA_ID,String oA_BRAND_ID,String oA_CD,String uSER_ID) {
        this.cONTACT_ID = cONTACT_ID;
        this.cONTACT_PERSON = cONTACT_PERSON;
        this.eMAIL = eMAIL;
        this.tELEPHONE = tELEPHONE;
        this.oA_ID = oA_ID;
        this.oA_BRAND_ID = oA_BRAND_ID;
        this.oA_CD = oA_CD;
        this.uSER_ID = uSER_ID;
    }

    public String getcONTACT_ID() {
        return cONTACT_ID;
    }

    public void setcONTACT_ID(String cONTACT_ID) {
        this.cONTACT_ID = cONTACT_ID;
    }

    public String getcONTACT_PERSON() {
        return cONTACT_PERSON;
    }

    public void setcONTACT_PERSON(String cONTACT_PERSON) {
        this.cONTACT_PERSON = cONTACT_PERSON;
    }

    public String geteMAIL() {
        return eMAIL;
    }

    public void seteMAIL(String eMAIL) {
        this.eMAIL = eMAIL;
    }

    public String gettELEPHONE() {
        return tELEPHONE;
    }

    public void settELEPHONE(String tELEPHONE) {
        this.tELEPHONE = tELEPHONE;
    }

    public String getoA_ID() {
        return oA_ID;
    }

    public void setoA_ID(String oA_ID) {
        this.oA_ID = oA_ID;
    }

    public String getoA_BRAND_ID() {
        return oA_BRAND_ID;
    }

    public void setoA_BRAND_ID(String oA_BRAND_ID) {
        this.oA_BRAND_ID = oA_BRAND_ID;
    }

    public String getoA_CD() {
        return oA_CD;
    }

    public void setoA_CD(String oA_CD) {
        this.oA_CD = oA_CD;
    }

    public String getuSER_ID() {
        return uSER_ID;
    }

    public void setuSER_ID(String uSER_ID) {
        this.uSER_ID = uSER_ID;
    }
}
