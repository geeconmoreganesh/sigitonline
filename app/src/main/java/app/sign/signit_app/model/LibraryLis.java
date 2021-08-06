
package app.sign.signit_app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class LibraryLis {

    @SerializedName("DS_ID")
    @Expose
    private String dsId;
    @SerializedName("NAME")
    @Expose
    private String name;
    @SerializedName("SUBJECT")
    @Expose
    private Object subject;
    @SerializedName("PARTIES")
    @Expose
    private String parties;
    @SerializedName("PARTIES_EMAIL")
    @Expose
    private String partiesEmail;
    @SerializedName("PATH")
    @Expose
    private String path;
    @SerializedName("IMG_PATH")
    @Expose
    private String imgPath;
    @SerializedName("IMG_COUNT")
    @Expose
    private String imgCount;
    @SerializedName("TYPE")
    @Expose
    private String type;
    @SerializedName("STATUS")
    @Expose
    private String status;
    @SerializedName("STATUS_NM")
    @Expose
    private String statusNm;
    @SerializedName("FP_ID")
    @Expose
    private String fpId;
    @SerializedName("EXPIERY_DATE")
    @Expose
    private Object expieryDate;
    @SerializedName("NO_OF_DAYS")
    @Expose
    private String noOfDays;
    @SerializedName("LAST_REMINDER_DATE")
    @Expose
    private Object lastReminderDate;
    @SerializedName("CANCELATION_REASON")
    @Expose
    private String cancelationReason;
    @SerializedName("IS_ARCHIVED")
    @Expose
    private String isArchived;
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
    @SerializedName("USER_NM")
    @Expose
    private String userNm;
    @SerializedName("CREATED_ON")
    @Expose
    private String createdOn;
    @SerializedName("CREATED_BY")
    @Expose
    private String createdBy;
    @SerializedName("SENT_ON")
    @Expose
    private String sentOn;
    @SerializedName("COMPLETED_ON")
    @Expose
    private Object completedOn;
    @SerializedName("UPDATED_ON")
    @Expose
    private Object updatedOn;
    @SerializedName("UPDATED_BY")
    @Expose
    private Object updatedBy;
    @SerializedName("PARTY_NAME")
    @Expose
    private String partyName;
    @SerializedName("PARTY_STATUS_NM")
    @Expose
    private String partyStatusNm;
    @SerializedName("SIGNED_ON")
    @Expose
    private Object signedOn;
    @SerializedName("PARTY_EMAIL")
    @Expose
    private String partyEmail;
    @SerializedName("PARTY_ROLE")
    @Expose
    private String partyRole;
    @SerializedName("REJECTED_ON")
    @Expose
    private Object rejectedOn;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LibraryLis() {
    }

    /**
     * 
     * @param userNm
     * @param subject
     * @param imgCount
     * @param isArchived
     * @param statusNm
     * @param type
     * @param createdOn
     * @param signedOn
     * @param noOfDays
     * @param path
     * @param expieryDate
     * @param isDeleted
     * @param sentOn
     * @param partyName
     * @param partyStatusNm
     * @param lastReminderDate
     * @param updatedBy
     * @param dsId
     * @param updatedOn
     * @param userId
     * @param partyEmail
     * @param fpId
     * @param createdBy
     * @param completedOn
     * @param imgPath
     * @param partyRole
     * @param name
     * @param parties
     * @param rejectedOn
     * @param partiesEmail
     * @param oaBrandId
     * @param oaId
     * @param status
     * @param cancelationReason
     */
    public LibraryLis(String dsId, String name, Object subject, String parties, String partiesEmail, String path, String imgPath, String imgCount, String type, String status, String statusNm, String fpId, Object expieryDate, String noOfDays, Object lastReminderDate, String cancelationReason, String isArchived, String isDeleted, String oaId, String oaBrandId, String userId, String userNm, String createdOn, String createdBy, String sentOn, Object completedOn, Object updatedOn, Object updatedBy, String partyName, String partyStatusNm, Object signedOn, String partyEmail, String partyRole, Object rejectedOn) {
        super();
        this.dsId = dsId;
        this.name = name;
        this.subject = subject;
        this.parties = parties;
        this.partiesEmail = partiesEmail;
        this.path = path;
        this.imgPath = imgPath;
        this.imgCount = imgCount;
        this.type = type;
        this.status = status;
        this.statusNm = statusNm;
        this.fpId = fpId;
        this.expieryDate = expieryDate;
        this.noOfDays = noOfDays;
        this.lastReminderDate = lastReminderDate;
        this.cancelationReason = cancelationReason;
        this.isArchived = isArchived;
        this.isDeleted = isDeleted;
        this.oaId = oaId;
        this.oaBrandId = oaBrandId;
        this.userId = userId;
        this.userNm = userNm;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.sentOn = sentOn;
        this.completedOn = completedOn;
        this.updatedOn = updatedOn;
        this.updatedBy = updatedBy;
        this.partyName = partyName;
        this.partyStatusNm = partyStatusNm;
        this.signedOn = signedOn;
        this.partyEmail = partyEmail;
        this.partyRole = partyRole;
        this.rejectedOn = rejectedOn;
    }

    public String getDsId() {
        return dsId;
    }

    public void setDsId(String dsId) {
        this.dsId = dsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getSubject() {
        return subject;
    }

    public void setSubject(Object subject) {
        this.subject = subject;
    }

    public String getParties() {
        return parties;
    }

    public void setParties(String parties) {
        this.parties = parties;
    }

    public String getPartiesEmail() {
        return partiesEmail;
    }

    public void setPartiesEmail(String partiesEmail) {
        this.partiesEmail = partiesEmail;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImgCount() {
        return imgCount;
    }

    public void setImgCount(String imgCount) {
        this.imgCount = imgCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusNm() {
        return statusNm;
    }

    public void setStatusNm(String statusNm) {
        this.statusNm = statusNm;
    }

    public String getFpId() {
        return fpId;
    }

    public void setFpId(String fpId) {
        this.fpId = fpId;
    }

    public Object getExpieryDate() {
        return expieryDate;
    }

    public void setExpieryDate(Object expieryDate) {
        this.expieryDate = expieryDate;
    }

    public String getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(String noOfDays) {
        this.noOfDays = noOfDays;
    }

    public Object getLastReminderDate() {
        return lastReminderDate;
    }

    public void setLastReminderDate(Object lastReminderDate) {
        this.lastReminderDate = lastReminderDate;
    }

    public String getCancelationReason() {
        return cancelationReason;
    }

    public void setCancelationReason(String cancelationReason) {
        this.cancelationReason = cancelationReason;
    }

    public String getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(String isArchived) {
        this.isArchived = isArchived;
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

    public String getUserNm() {
        return userNm;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
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

    public String getSentOn() {
        return sentOn;
    }

    public void setSentOn(String sentOn) {
        this.sentOn = sentOn;
    }

    public Object getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(Object completedOn) {
        this.completedOn = completedOn;
    }

    public Object getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Object updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Object getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Object updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getPartyStatusNm() {
        return partyStatusNm;
    }

    public void setPartyStatusNm(String partyStatusNm) {
        this.partyStatusNm = partyStatusNm;
    }

    public Object getSignedOn() {
        return signedOn;
    }

    public void setSignedOn(Object signedOn) {
        this.signedOn = signedOn;
    }

    public String getPartyEmail() {
        return partyEmail;
    }

    public void setPartyEmail(String partyEmail) {
        this.partyEmail = partyEmail;
    }

    public String getPartyRole() {
        return partyRole;
    }

    public void setPartyRole(String partyRole) {
        this.partyRole = partyRole;
    }

    public Object getRejectedOn() {
        return rejectedOn;
    }

    public void setRejectedOn(Object rejectedOn) {
        this.rejectedOn = rejectedOn;
    }

}
