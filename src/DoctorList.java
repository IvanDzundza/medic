import java.util.*;

public class DoctorList {

    private List <Doctor> doctors = new LinkedList<Doctor>();


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Doctor doctor : doctors) {
            stringBuilder.append(doctor).append(",\n");
        }
        return "DoctorList{" +
                "doctors=" + stringBuilder +
                '}';
    }


    public List<Doctor> filterBySpecialization(String specializations) {
        List<Doctor> result = new LinkedList<>();
        for (Doctor doctor : doctors) {
            if (doctor.getSpecialization().equalsIgnoreCase(specializations)) {
                result.add(doctor);
            }
        }

        return result;
    }

    public List<Doctor> filterBySpecialization() {
        String specialization;
        System.out.println("Введіть спеціальність доктора:");
        Scanner scanner = new Scanner(System.in);
        specialization = scanner.nextLine();
        return filterBySpecialization(specialization);
    }

    public void addRandomDoctors(int numberOfDoctors) {
        Random random = new Random();

        for (int i = 0; i < numberOfDoctors; i++) {
            doctors.add(new Doctor(i, Human.lastNames[random.nextInt(Human.lastNames.length)], "Тарас", "Тарасович", "Мазепи", random.nextInt(999), Doctor.specializations[random.nextInt(Doctor.specializations.length)]));

        }
    }

}
