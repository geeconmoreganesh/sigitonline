package app.sign.signit_app.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignatureList {
    @SerializedName("SIGNATURE_ID")
    @Expose
    private String signatureId;
    @SerializedName("SIGNATURE")
    @Expose
    private String signature;
    @SerializedName("IS_DEFAULT")
    @Expose
    private String isDefault;
    @SerializedName("IS_DELETED")
    @Expose
    private String isDeleted;
    @SerializedName("OA_ID")
    @Expose
    private String oaId;
    @SerializedName("OA_BRAND_ID")
    @Expose
    private String oaBrandId;
    @SerializedName("USER_ID")
    @Expose
    private String userId;
    @SerializedName("CREATED_ON")
    @Expose
    private String createdOn;
    @SerializedName("UPDATED_ON")
    @Expose
    private String updatedOn;
    @SerializedName("CREATED_BY")
    @Expose
    private String createdBy;
    @SerializedName("UPDATED_BY")
    @Expose
    private String updatedBy;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SignatureList() {
    }

    /**
     * 
     * @param isDefault
     * @param updatedBy
     * @param isDeleted
     * @param signature
     * @param createdBy
     * @param signatureId
     * @param updatedOn
     * @param oaBrandId
     * @param userId
     * @param createdOn
     * @param oaId
     */
    public SignatureList(String signatureId, String signature, String isDefault, String isDeleted, String oaId, String oaBrandId, String userId, String createdOn, String updatedOn, String createdBy, String updatedBy) {
        super();
        this.signatureId = signatureId;
        this.signature = signature;
        this.isDefault = isDefault;
        this.isDeleted = isDeleted;
        this.oaId = oaId;
        this.oaBrandId = oaBrandId;
        this.userId = userId;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public String getSignatureId() {
        return signatureId;
    }

    public void setSignatureId(String signatureId) {
        this.signatureId = signatureId;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getOaId() {
        return oaId;
    }

    public void setOaId(String oaId) {
        this.oaId = oaId;
    }

    public String getOaBrandId() {
        return oaBrandId;
    }

    public void setOaBrandId(String oaBrandId) {
        this.oaBrandId = oaBrandId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

}
