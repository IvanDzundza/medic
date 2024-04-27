import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private Patient[] patients;
    private Doctor[] doctors;


    public static void main(String[] args) {

        Main main = new Main();


        main.initArray(5);

        for (int i = 0; i < main.patients.length; i++) {

            System.out.println(main.patients[i]);
        }

        for (int i = 0; i < main.doctors.length; i++) {

            System.out.println(main.doctors[i]);
        }

        Arrays.sort(main.patients, new Comparator<Patient>() {
            @Override
            public int compare(Patient o1, Patient o2) {
                return o1.getDiagnosis().compareTo(o2.getDiagnosis());
            }
        }.thenComparing(new LastFamilyComparator()));
        Arrays.sort(main.doctors, (new Comparator<Doctor>() {
            @Override
            public int compare(Doctor o1, Doctor o2) {
                return o1.getSpecialization().compareTo(o2.getSpecialization());
            }
        }).thenComparing(new LastFamilyComparator()));

        for (int i = 0; i < main.patients.length; i++) {

            System.out.println(main.patients[i]);
        }

        for (int i = 0; i < main.doctors.length; i++) {

            System.out.println(main.doctors[i]);
        }

//        main.filterByDiagnosis();
//        main.filterInsurance();
//        main.printByMedicalCartNumberIn();


    }

    public void initArray(int arraySize) {

        patients = new Patient[arraySize];
        doctors = new Doctor[arraySize];

        Random random = new Random();


        for (int i = 0; i < patients.length; i++) {
            patients[i] = new Patient(i, Human.lastNames[random.nextInt(Human.lastNames.length)], "Тарас", "Тарасович", "Мазепи", random.nextInt(999), random.nextInt(100), random.nextBoolean(), Patient.dagnosis[random.nextInt(Patient.dagnosis.length)]);

        }
        for (int i = 0; i < doctors.length; i++) {
            doctors[i] = new Doctor(i, Human.lastNames[random.nextInt(Human.lastNames.length)], "Тарас", "Тарасович", "Мазепи", random.nextInt(999), Doctor.specializations[random.nextInt(Doctor.specializations.length)]);

        }


    }

    public void filterByDiagnosis(String diagnosis) {
        for (int i = 0; i < patients.length; i++) {
            if (((Patient) patients[i]).getDiagnosis().equalsIgnoreCase(diagnosis)) {
                System.out.println(patients[i]);
            }


        }

    }

    public void filterByDiagnosis() {
        String diagnos;
        System.out.println("Введіть діагноз пацієнта:");
        Scanner scanner = new Scanner(System.in);
        diagnos = scanner.nextLine();
        filterByDiagnosis(diagnos);
    }

//    public void filterInsurance() {
//        int count = 0;
//        for (int i = 0; i < patients.length; i++) {
//            if (!patients[i].isInsurance()) {
//                count++;
//                System.out.println(patients[i]);
//            }
//        }
//        System.out.println(count);
//    }

//    public void printByMedicalCartNumberIn(int start, int end) {
//        int medicalCartNumber;
//
//        for (int i = 0; i < patients.length; i++) {
//            medicalCartNumber = patients[i].getNumberMedicalCart();
//            if (medicalCartNumber > start && medicalCartNumber < end) {
//                System.out.println(patients[i]);
//            }
//        }
//    }
//    public void printByMedicalCartNumberIn() {
//        int start;
//        int end;
//        System.out.println("Введіть початкове значення:");
//        Scanner scanner = new Scanner(System.in);
//        start = scanner.nextInt();
//        System.out.println("Введіть кінцеве значення:");
//        end = scanner.nextInt();
//        printByMedicalCartNumberIn(start, end);
//
//
//
//
//    }

}


