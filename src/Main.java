import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {


    public static void main(String[] args) {

        DoctorList doctorList = new DoctorList();
        doctorList.addRandomDoctors(10);
        List<Doctor> doctors = doctorList.getAll();

        Predicate<Doctor> doctorPredicate1 = new Predicate<Doctor>() {
            @Override
            public boolean test(Doctor doctor) {
                return doctor.isLicense();
            }
        };

        Predicate<Doctor> doctorPredicate2 = (doctor) -> {
            return doctor.isLicense();
        };

        doctors.removeIf(doctorPredicate1);
        System.out.println(doctors);

        Consumer<Doctor> doctorConsumer = new Consumer<Doctor>() {
            @Override
            public void accept(Doctor doctor) {
                System.out.println(doctor);
            }
        };

        doctors.forEach(doctorConsumer);

        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }

        doctors.replaceAll(doctor -> {
            doctor.setLicense(false);
            return doctor;
        });



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
       DoctorList doctorList1 = new DoctorList();
       doctorList.addRandomDoctors(10);
        System.out.println(doctorList1);
        System.out.println(doctorList1.getMapSpecializationDoctor());
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


