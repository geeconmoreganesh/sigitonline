
package app.sign.signit_app.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArchiveList {

    @SerializedName("DS_ID")
    @Expose
    private String dsId;
    @SerializedName("NAME")
    @Expose
    private String name;
    @SerializedName("SUBJECT")
    @Expose
    private String subject;
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
    private String expieryDate;
    @SerializedName("NO_OF_DAYS")
    @Expose
    private String noOfDays;
    @SerializedName("LAST_REMINDER_DATE")
    @Expose
    private String lastReminderDate;
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
    private String completedOn;
    @SerializedName("UPDATED_ON")
    @Expose
    private String updatedOn;
    @SerializedName("UPDATED_BY")
    @Expose
    private String updatedBy;
    @SerializedName("PARTY_NAME")
    @Expose
    private String partyName;
    @SerializedName("PARTY_STATUS_NM")
    @Expose
    private String partyStatusNm;
    @SerializedName("SIGNED_ON")
    @Expose
    private String signedOn;
    @SerializedName("PARTY_EMAIL")
    @Expose
    private String partyEmail;
    @SerializedName("PARTY_ROLE")
    @Expose
    private String partyRole;
    @SerializedName("REJECTED_ON")
    @Expose
    private String rejectedOn;

    public ArchiveList(String dsId, String name, String subject, String parties, String partiesEmail, String path, String imgPath, String imgCount, String type, String status, String statusNm, String fpId, String expieryDate, String noOfDays, String lastReminderDate, String cancelationReason, String isArchived, String isDeleted, String oaId, String oaBrandId, String userId, String userNm, String createdOn, String createdBy, String sentOn, String completedOn, String updatedOn, String updatedBy, String partyName, String partyStatusNm, String signedOn, String partyEmail, String partyRole, String rejectedOn) {
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
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

    public String getExpieryDate() {
        return expieryDate;
    }

    public void setExpieryDate(String expieryDate) {
        this.expieryDate = expieryDate;
    }

    public String getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(String noOfDays) {
        this.noOfDays = noOfDays;
    }

    public String getLastReminderDate() {
        return lastReminderDate;
    }

    public void setLastReminderDate(String lastReminderDate) {
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

    public String getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(String completedOn) {
        this.completedOn = completedOn;
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

    public String getSignedOn() {
        return signedOn;
    }

    public void setSignedOn(String signedOn) {
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

    public String getRejectedOn() {
        return rejectedOn;
    }

    public void setRejectedOn(String rejectedOn) {
        this.rejectedOn = rejectedOn;
    }

}
