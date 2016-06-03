package org.sourceit.entities;

public class ApplicantResult extends Entity {

    private long applicantId;
    private long subjectId;
    private int mark;
    private String applicantFirstName;
    private String applicantName;
    private String subjectName;

    public ApplicantResult(long applicantId, long subjectId, int mark, String applicantFirstName,
                           String applicantName, String subjectName) {
        this();
        this.applicantId = applicantId;
        this.subjectId = subjectId;
        this.mark = mark;
        this.applicantFirstName = applicantFirstName;
        this.applicantName = applicantName;
        this.subjectName = subjectName;
    }

    public ApplicantResult() {
        this.id = -1;
    }

    public long getApplicantId() {
        return applicantId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }


    public void setApplicantId(long applicantId) {
        this.applicantId = applicantId;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
