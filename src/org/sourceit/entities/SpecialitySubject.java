package org.sourceit.entities;

public class SpecialitySubject extends Entity {

    private long professionId;
    private long subjectId;
    private String professionName;

    public SpecialitySubject(long professionId, long subjectId, String professionName, String subjectName) {
        this();
        this.professionId = professionId;
        this.subjectId = subjectId;
        this.professionName = professionName;
        this.subjectName = subjectName;
    }

    private String subjectName;


    public SpecialitySubject() {
        this.id = -1;
    }

    public long getProfessionId() {
        return professionId;
    }

    public void setProfessionId(long professionId) {
        this.professionId = professionId;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
