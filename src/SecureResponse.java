public class SecureResponse<T extends MedicalRecord & Confidential> {

    private boolean success;
    private T data;
    private String warningMessage;  // Peringatan jika ada data yang di-masking

    public SecureResponse(boolean success, T data, String warningMessage) {
        this.success = success;
        this.data = data;
        this.warningMessage = warningMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public String getWarningMessage() {
        return warningMessage;
    }

    @Override
    public String toString() {
        return "\n=== SecureResponse ===" +
               "\nStatus  : " + (success ? "SUCCESS" : "FAILED") +
               "\nWarning : " + (warningMessage != null ? warningMessage : "None") +
               "\nData    :\n       " + data;
    }
}