public class Main {


    public static void main(String[] args) {

        PatientList patientList = new PatientList();
        patientList.addRandomPatients(10);
        System.out.println(patientList);
        for (Patient patient : patientList.filterByDiagnosis()) {
            System.out.println(patient);
        }

        for (Patient patient : patientList.filterByMedicalCartNumberIn()) {
            System.out.println(patient);
        }
        System.out.println("Пацієнти з страхівкою:");
        for (Patient patient : patientList.filterPatientsWithInsurance()) {
            System.out.println(patient);
        }
    }

}


