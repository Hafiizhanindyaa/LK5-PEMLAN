public class PatientProfileV1 implements MedicalRecord, Versioned, Confidential {

    private String patientId;
    private String name;
    private String ssn;          
    private int securityLevel;

    public PatientProfileV1(String patientId, String name, String ssn, int securityLevel) {
        this.patientId = patientId;
        this.name = name;
        this.ssn = ssn;
        this.securityLevel = securityLevel;
    }

    @Override
    public String getPatientId() {
        return patientId;
    }

    @Override
    public int getVersion() {
        return 1;
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

    @Override
    public String toString() {
        return "[V1] Patient ID : " + patientId +
               "\n       Name       : " + name +
               "\n       KTP (SSN)  : " + ssn +
               "\n       Security   : " + securityLevel;
    }
}