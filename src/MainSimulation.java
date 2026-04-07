public class MainSimulation {

    public static void main(String[] args) {

        System.out.println("\n=== LEVEL 1 (TIDAK DIMASK) ===");

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


        System.out.println("\n=== LEVEL 2 & 3 (SELALU DIMASK) ===");

        IntegrationGateway<PatientProfileV1> gatewayV1 =
                new IntegrationGateway<>(MockDatabase.getPatientV1());

        System.out.println(
                gatewayV1.fetchData("P001", SecurityLevel.PUBLIC)
        );


        IntegrationGateway<PatientProfileV2> gatewayV2 =
                new IntegrationGateway<>(MockDatabase.getPatientV2());

        System.out.println(
                gatewayV2.fetchData("P002", SecurityLevel.PUBLIC)
        );


        System.out.println("\n=== AKSES TINGGI (TETAP DIMASK SESUAI PERMINTAAN) ===");

        IntegrationGateway<PatientProfileV1> gatewayHighV1 =
                new IntegrationGateway<>(MockDatabase.getPatientV1());


        System.out.println(
                gatewayHighV1.fetchData("P001", SecurityLevel.PUBLIC)
        );


        IntegrationGateway<PatientProfileV2> gatewayHighV2 =
                new IntegrationGateway<>(MockDatabase.getPatientV2());

        System.out.println(
                gatewayHighV2.fetchData("P002", SecurityLevel.PUBLIC)
        );


        System.out.println("\n=== ERROR CASE ===");

        IntegrationGateway<PatientProfileV1> gatewayError =
                new IntegrationGateway<>(MockDatabase.getPatientV1());

        System.out.println(gatewayError.fetchData("P999", SecurityLevel.SECRET));
        System.out.println(gatewayError.fetchData("", SecurityLevel.SECRET));
    }
}