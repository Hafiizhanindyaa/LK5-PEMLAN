package src;

public class PatientProfileV2 implements MedicalRecord, Versioned, Confidential {

    private String patientId;
    private String name;
    private String ssn;          
    private int securityLevel;
    private String diagnosis;
    private String medicalHistory;

    public PatientProfileV2(String patientId, String name, String ssn, int securityLevel, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.ssn = ssn;
        this.securityLevel = securityLevel;
        this.diagnosis = diagnosis;
        this.medicalHistory = "None";
    }
    public PatientProfileV2(String patientId, String name, String ssn, String medicalHistory, int securityLevel) {
        this.patientId = patientId;
        this.name = name;
        this.ssn = ssn;
        this.securityLevel = securityLevel;
        this.medicalHistory = medicalHistory;
        this.diagnosis = "None";
    }
    public PatientProfileV2(String patientId, String name, String ssn, int securityLevel,String diagnosis, String medicalHistory) {
        this.patientId = patientId;
        this.name = name;
        this.ssn = ssn;
        this.securityLevel = securityLevel;
        this.diagnosis = diagnosis;
        this.medicalHistory = medicalHistory;
    }


    @Override
    public String getPatientId() {
        return patientId;
    }

    @Override
    public int getVersion() {
        return 2;
    }

    @Override
    public int getSecurityLevel() {
        return securityLevel;
    }

    @Override
    public void maskSensitiveData() {
        if (this.ssn != null) {
            this.ssn = "******";  
        }
    }

    public String getName() {
        return name;
    }

    public String getSsn() {
        return ssn;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    @Override
    public String toString() {
        return "[V2] Patient ID : " + patientId +
               "\n       Name            : " + name +
               "\n       KTP (SSN)       : " + ssn +
               "\n       Security        : " + securityLevel +
               "\n       Diagnosis       : " + diagnosis +
               "\n       Medical History : " + medicalHistory;
    }
}
