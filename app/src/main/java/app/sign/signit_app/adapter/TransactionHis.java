
package app.sign.signit_app.adapter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransactionHis {

    @SerializedName("TRANSACTION_HISTORY_ID")
    @Expose
    private String transactionHistoryId;
    @SerializedName("DATE")
    @Expose
    private String date;
    @SerializedName("TRANSACTION_DESCRIPTION")
    @Expose
    private String transactionDescription;
    @SerializedName("METHOD")
    @Expose
    private String method;
    @SerializedName("AMOUNT")
    @Expose
    private String amount;
    @SerializedName("CREDITS")
    @Expose
    private String credits;
    @SerializedName("BALANCE_CREDITS")
    @Expose
    private String balanceCredits;
    @SerializedName("STATUS")
    @Expose
    private String status;
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
    @SerializedName("CREATED_BY")
    @Expose
    private String createdBy;
    @SerializedName("UPDATED_ON")
    @Expose
    private String updatedOn;
    @SerializedName("UPDATED_BY")
    @Expose
    private String updatedBy;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TransactionHis() {
    }

    /**
     * 
     * @param date
     * @param amount
     * @param updatedBy
     * @param method
     * @param transactionDescription
     * @param updatedOn
     * @param userId
     * @param createdOn
     * @param balanceCredits
     * @param isDeleted
     * @param credits
     * @param createdBy
     * @param transactionHistoryId
     * @param oaBrandId
     * @param oaId
     * @param status
     */
    public TransactionHis(String transactionHistoryId, String date, String transactionDescription, String method, String amount, String credits, String balanceCredits, String status, String isDeleted, String oaId, String oaBrandId, String userId, String createdOn, String createdBy, String updatedOn, String updatedBy) {
        super();
        this.transactionHistoryId = transactionHistoryId;
        this.date = date;
        this.transactionDescription = transactionDescription;
        this.method = method;
        this.amount = amount;
        this.credits = credits;
        this.balanceCredits = balanceCredits;
        this.status = status;
        this.isDeleted = isDeleted;
        this.oaId = oaId;
        this.oaBrandId = oaBrandId;
        this.userId = userId;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.updatedOn = updatedOn;
        this.updatedBy = updatedBy;
    }

    public String getTransactionHistoryId() {
        return transactionHistoryId;
    }

    public void setTransactionHistoryId(String transactionHistoryId) {
        this.transactionHistoryId = transactionHistoryId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getBalanceCredits() {
        return balanceCredits;
    }

    public void setBalanceCredits(String balanceCredits) {
        this.balanceCredits = balanceCredits;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

}
