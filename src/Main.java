public class Main {


    public static void main(String[] args) {

        PatientList patientList = new PatientList();
        patientList.addRandomPatients(10);
        System.out.println(patientList);
        for (Patient patient : patientList.filterByDiagnosis()) {
            System.out.println(patient);
        }

        DoctorList doctorList = new DoctorList();
        doctorList.addRandomDoctors(10);
        System.out.println(doctorList);
        for (Doctor doctor : doctorList.filterBySpecialization()) {
            System.out.println(doctor);
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


