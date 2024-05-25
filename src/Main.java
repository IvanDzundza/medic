public class Main {


    public static void main(String[] args) {

//        PatientList patientList = new PatientList();
//        patientList.addRandomPatients(10);
//        System.out.println(patientList);
//
//        Patient newPatient = new Patient(33, Human.lastNames[1], "Тарас", "Тарасович", "Мазепи", 888, 100, true, "Astma");
//        patientList.addPatient(newPatient);
//        System.out.println(patientList);
//        Patient newPatient2 = new Patient(33, Human.lastNames[1], "Тарас", "Тарасович", "Мазепи", 888, 100, true, "Astma");
//        int index = patientList.getIndex(newPatient2);
//        System.out.println(index);
//        patientList.removeFromListBIndex(index);
//        patientList.removeFromList(newPatient2);
//        System.out.println(patientList);


//        for (Patient patient : patientList.filterByDiagnosis()) {
//            System.out.println(patient);
//        }
//
       DoctorList doctorList = new DoctorList();
       doctorList.addRandomDoctors(10);
        System.out.println(doctorList);
        System.out.println(doctorList.getMapSpecializationDoctor());
//        for (Doctor doctor : doctorList.filterBySpecialization()) {
//            System.out.println(doctor);
//        }
//
//        for (Patient patient : patientList.filterByMedicalCartNumberIn()) {
//            System.out.println(patient);
//        }
//        System.out.println("Пацієнти з страхівкою:");
//        for (Patient patient : patientList.filterPatientsWithInsurance()) {
//            System.out.println(patient);
//        }
    }

}


