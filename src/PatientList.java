import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PatientList {

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Patient patient : patients) {
            stringBuilder.append(patient).append(",\n");
        }
        return "PatientList{" +
                "patients=" + stringBuilder +
                '}';
    }

    private List<Patient> patients = new ArrayList<Patient>();


    public List<Patient> filterByDiagnosis(String diagnosis) {
        List<Patient> result = new ArrayList<>();
        for (Patient patient : patients) {
            if (patient.getDiagnosis().equalsIgnoreCase(diagnosis)) {
                result.add(patient);
            }
        }

        return result;
    }

    public List<Patient> filterByDiagnosis() {
        String diagnos;
        System.out.println("Введіть діагноз пацієнта:");
        Scanner scanner = new Scanner(System.in);
        diagnos = scanner.nextLine();
        return filterByDiagnosis(diagnos);
    }

    public void addRandomPatients(int numberOfPatients) {
        Random random = new Random();


        for (int i = 0; i < numberOfPatients; i++) {
            patients.add(new Patient(i, Human.lastNames[random.nextInt(Human.lastNames.length)], "Тарас", "Тарасович", "Мазепи", random.nextInt(999), random.nextInt(100), random.nextBoolean(), Patient.dagnosis[random.nextInt(Patient.dagnosis.length)]));

        }
    }

    public List <Patient> filterPatientsWithInsurance() {
        List<Patient> result = new ArrayList<>();

        for (Patient patient : patients) {
            if (patient.isInsurance()) {
                result.add(patient);
            }
        }
        return result;
    }

    public List<Patient> filterByMedicalCartNumberIn(int start, int end) {
        int medicalCartNumber;
        ArrayList<Patient> result = new ArrayList<Patient>();


        for (Patient patient : patients) {


            medicalCartNumber = patient.getNumberMedicalCart();
            if (medicalCartNumber > start && medicalCartNumber < end) {
                result.add(patient);
            }
        }
        return result;
    }

    public List<Patient> filterByMedicalCartNumberIn() {
        int start;
        int end;
        System.out.println("Фільтр по медичній карті. Введіть початкове значення:");
        Scanner scanner = new Scanner(System.in);
        start = scanner.nextInt();
        System.out.println("Введіть кінцеве значення:");
        end = scanner.nextInt();
        return filterByMedicalCartNumberIn(start, end);
    }
    };
