public class MockDatabase {

    public static PatientProfileV1 getPatientV1() {
        return new PatientProfileV1(
                "P001",
                "Budi Santoso",
                "1234567890",
                SecurityLevel.RESTRICTED
        );
    }

    public static PatientProfileV2 getPatientV2() {
        return new PatientProfileV2(
                "P002",
                "Siti Aminah",
                "9876543210",
                SecurityLevel.SECRET,
                "Diabetes",
                "Riwayat Hipertensi"
        );
    }
}