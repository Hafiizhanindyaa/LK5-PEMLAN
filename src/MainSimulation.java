package src;

public class MainSimulation {

    public static void main(String[] args) {

        System.out.println("\n=== CASE 1: DATA PUBLIC (TIDAK DIMASK) ===");

        PatientProfileV1 publicPatient = new PatientProfileV1(
                "P003",
                "Andi Wijaya",
                "1111111111",
                SecurityLevel.PUBLIC
        );

        IntegrationGateway<PatientProfileV1> gatewayPublic =
                new IntegrationGateway<>(publicPatient);

        System.out.println(
                gatewayPublic.fetchData("P003", SecurityLevel.PUBLIC)
        );


        System.out.println("\n=== CASE 2: CLEARANCE LEBIH RENDAH (DIMASK) ===");

        IntegrationGateway<PatientProfileV1> gatewayLowV1 =
                new IntegrationGateway<>(MockDatabase.getPatientV1());

        System.out.println(
                gatewayLowV1.fetchData("P001", SecurityLevel.PUBLIC)
        );


        IntegrationGateway<PatientProfileV2> gatewayLowV2 =
                new IntegrationGateway<>(MockDatabase.getPatientV2());

        System.out.println(
                gatewayLowV2.fetchData("P002", SecurityLevel.PUBLIC)
        );


        System.out.println("\n=== CASE 3: CLEARANCE SAMA (TIDAK DIMASK) ===");

        IntegrationGateway<PatientProfileV1> gatewayEqualV1 =
                new IntegrationGateway<>(MockDatabase.getPatientV1());

        System.out.println(
                gatewayEqualV1.fetchData("P001", SecurityLevel.RESTRICTED)
        );


        System.out.println("\n=== CASE 4: CLEARANCE LEBIH TINGGI (TIDAK DIMASK) ===");

        IntegrationGateway<PatientProfileV1> gatewayHighV1 =
                new IntegrationGateway<>(MockDatabase.getPatientV1());

        System.out.println(
                gatewayHighV1.fetchData("P001", SecurityLevel.SECRET)
        );


        IntegrationGateway<PatientProfileV2> gatewayHighV2 =
                new IntegrationGateway<>(MockDatabase.getPatientV2());

        System.out.println(
                gatewayHighV2.fetchData("P002", SecurityLevel.SECRET)
        );


        System.out.println("\n=== CASE 5: ERROR CASE ===");

        IntegrationGateway<PatientProfileV1> gatewayError =
                new IntegrationGateway<>(MockDatabase.getPatientV1());

        // ID tidak ditemukan
        System.out.println(
                gatewayError.fetchData("P999", SecurityLevel.SECRET)
        );

        // ID kosong
        System.out.println(
                gatewayError.fetchData("", SecurityLevel.SECRET)
        );
    }
}