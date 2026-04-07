public class IntegrationGateway<T extends MedicalRecord & Versioned & Confidential> {
    
    private T mockDatabaseRecord;
    
    public IntegrationGateway(T record) {
        this.mockDatabaseRecord = record;
    }
    
    public SecureResponse<T> fetchData(String id, int clearanceLevel) {
        if (id == null || id.trim().isEmpty()) {
            return new SecureResponse<>("ERROR: Patient ID tidak boleh kosong");
        }
        
        if (!id.equals(mockDatabaseRecord.getPatientId())) {
            return new SecureResponse<>("ERROR: Patient ID '" + id + "' tidak ditemukan di database");
        }
        
        int dataSecurityLevel = mockDatabaseRecord.getSecurityLevel();
        
        if (clearanceLevel < dataSecurityLevel) {
            mockDatabaseRecord.maskSensitiveData();
            
            String warningMsg = "PERHATIAN: Clearance level Anda (" + clearanceLevel + 
                              ") lebih rendah dari security level data (" + dataSecurityLevel + 
                              "). Beberapa data sensitif telah disembunyikan.";
            
            return new SecureResponse<>(mockDatabaseRecord, warningMsg);
        } else {
            return new SecureResponse<>(mockDatabaseRecord);
        }
    }
    
    public int getDataVersion() {
        return mockDatabaseRecord.getVersion();
    }
    
    public int getDataSecurityLevel() {
        return mockDatabaseRecord.getSecurityLevel();
    }
}
