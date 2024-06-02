import java.util.*;
import java.util.stream.Collectors;

public class PatientList {

    private final List<Patient> patients = new ArrayList<>();

    public int getIndex(Patient patient) {
        return patients.indexOf(patient);
    }

    public List<String> getUniqueLastNames() {
        List<String> lastNames = new LinkedList<>();
        for (Patient patient : patients) {
            if (!lastNames.contains(patient.getLastname())) {
                lastNames.add(patient.getLastname());
            }
        }
        return lastNames;
    }

    public Set<String> getUniqueDiagnosis() {
        Set<String> diagnosis = new HashSet<>();
        for (Patient patient : patients) {
            diagnosis.add(patient.getDiagnosis());
        }
        return diagnosis;
    }

    public Set<String> getUniqueDiagnosisByStream() {
        return patients.stream()
                .map(patient -> patient.getDiagnosis())
                .collect(Collectors.toSet());
    }

    public Map<String, Integer> getMap() {
        Map<String, Integer> map = new HashMap<>();
        for (Patient patient : patients) {
            if (map.containsKey(patient.getDiagnosis())) {
                map.replace(patient.getDiagnosis(), map.get(patient.getDiagnosis()) + 1);
            } else {
                map.put(patient.getDiagnosis(), 1);
            }
        }
        return map;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void removeFromList(Patient patient) {
        patients.remove(patient);

    }

    public void removeFromListBIndex(int index) {
        patients.remove(index);
    }


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

    public List<Patient> filterPatientsWithInsurance() {
        List<Patient> result = new ArrayList<>();

        for (Patient patient : patients) {
            if (patient.isInsurance()) {
                result.add(patient);
            }
        }
        return result;
    }

    public List<Patient> filterPatientsWithInsuranceByStream() {
        return patients.stream()
                .filter(patient -> patient.isInsurance())
                .toList();
    }

    public List<Patient> filterByMedicalCartNumberIn(int start, int end) {
        int medicalCartNumber;
        ArrayList<Patient> result = new ArrayList<>();


        for (Patient patient : patients) {


            medicalCartNumber = patient.getNumberMedicalCart();
            if (medicalCartNumber > start && medicalCartNumber < end) {
                result.add(patient);
            }
        }
        return result;
    }

    public Optional<Integer> getMaxNumberMedicalCartByStream() {
        return patients.stream()
                .map(patient -> patient.getNumberMedicalCart())
                .max(Integer::compare);
    }

    public Optional<Patient> getPatientWithMaxNumberMedicalCartByStream() {
        return patients.stream()
                .max((o1, o2) -> Integer.compare(o1.getNumberMedicalCart(), o2.getNumberMedicalCart()));


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
}
