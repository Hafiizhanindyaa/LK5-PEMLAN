public class SecureResponse<T extends MedicalRecord & Confidential> {

    private boolean success;
    private T data;
    private String warningMessage;
    private boolean dataMasked;

    public SecureResponse(T data) {
        this.success = true;
        this.data = data;
        this.warningMessage = null;
        this.dataMasked = false;
    }

    public SecureResponse(T data, String warningMessage) {
        this.success = true;
        this.data = data;
        this.warningMessage = warningMessage;
        this.dataMasked = true;
    }

    public SecureResponse(String errorMessage) {
        this.success = false;
        this.data = null;
        this.warningMessage = errorMessage;
        this.dataMasked = false;
    }

    public boolean isSuccess()          { return success; }
    public T getData()                  { return data; }
    public String getWarningMessage()   { return warningMessage; }
    public boolean isDataMasked()       { return dataMasked; }

    @Override
    public String toString() {
        return "\n=== SecureResponse ===" +
               "\nStatus  : " + (success ? "SUCCESS" : "FAILED") +
               "\nMasked  : " + (dataMasked ? "YA - sebagian data disembunyikan" : "TIDAK") +
               "\nWarning : " + (warningMessage != null ? warningMessage : "None") +
               "\nData    :\n       " + data;
    }
}