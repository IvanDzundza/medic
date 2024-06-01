import java.math.BigDecimal;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {


    public static void main(String[] args) {


//        Map<Product, Integer> maps = new HashMap<>();
//        maps.put(new Product("apple", BigDecimal.valueOf(55.50)), 5);
//        maps.put(new Product("orange", BigDecimal.valueOf(75.50)), 3);
//        maps.put(new Product("strawberry", BigDecimal.valueOf(80.00)), 15);
//        maps.forEach((product, pices) -> System.out.printf("%d %s %s \n", pices, product.getName(), product.getPrice().multiply(BigDecimal.valueOf(pices)).toString()));
//        // 5 apple = 277,50

        DoctorList doctorList = new DoctorList();
        doctorList.addRandomDoctors(10);
        List<Doctor> doctors = doctorList.getAll();
        Comparator<Doctor> lastNameComparator = (doctor1, doctor2) -> doctor1.getLastname().compareTo(doctor2.getLastname());
        Collections.sort(doctors, lastNameComparator);
        System.out.println(doctors);

        System.out.println(doctorList.getSpecializationUniqueStream());
        System.out.println(doctorList.filterBySpecialization());

        Comparator<Doctor> idComparator = (doctor1, doctor2) -> doctor1.getId().compareTo(doctor2.getId());
        Collections.sort(doctors, lastNameComparator.thenComparing(idComparator));
        System.out.println(doctors);

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

        Consumer<Doctor> doctorConsumer = System.out::println;

        Supplier<Doctor> doctorSupplier = () -> new Doctor();
        doctors.add(doctorSupplier.get());

        doctors.forEach(doctorConsumer);

        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }

        doctors.replaceAll(doctor -> {
            doctor.setLicense(false);
            return doctor;
        });

        BiConsumer<Patient, Doctor> petientDoctorBiConsumer = (patient, doctor) -> {
            System.out.println(patient);
            System.out.println(doctor);
        };

        BiConsumer<Patient, Doctor> petientDoctorBiConsumer1 = new BiConsumer<Patient, Doctor>() {
            @Override
            public void accept(Patient patient, Doctor doctor) {
                System.out.println(patient);
                System.out.println(doctor);

            }
        };

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


