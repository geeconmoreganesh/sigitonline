package app.sign.signit_app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PartyDetail {

    @SerializedName("PARTY_NAME")
    @Expose
    private String pARTYNAME;
    @SerializedName("PARTY_STATUS_NM")
    @Expose
    private Object pARTYSTATUSNM;
    @SerializedName("SIGNED_ON")
    @Expose
    private Object sIGNEDON;
    @SerializedName("PARTY_EMAIL")
    @Expose
    private String pARTYEMAIL;
    @SerializedName("PARTY_ROLE")
    @Expose
    private String pARTYROLE;

    public PartyDetail(String pARTYNAME, Object pARTYSTATUSNM, Object sIGNEDON, String pARTYEMAIL, String pARTYROLE) {
        this.pARTYNAME = pARTYNAME;
        this.pARTYSTATUSNM = pARTYSTATUSNM;
        this.sIGNEDON = sIGNEDON;
        this.pARTYEMAIL = pARTYEMAIL;
        this.pARTYROLE = pARTYROLE;
    }

    public String getPARTYNAME() {
        return pARTYNAME;
    }

    public void setPARTYNAME(String pARTYNAME) {
        this.pARTYNAME = pARTYNAME;
    }

    public Object getPARTYSTATUSNM() {
        return pARTYSTATUSNM;
    }

    public void setPARTYSTATUSNM(Object pARTYSTATUSNM) {
        this.pARTYSTATUSNM = pARTYSTATUSNM;
    }

    public Object getSIGNEDON() {
        return sIGNEDON;
    }

    public void setSIGNEDON(Object sIGNEDON) {
        this.sIGNEDON = sIGNEDON;
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

}
