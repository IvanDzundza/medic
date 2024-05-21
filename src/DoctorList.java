import javax.print.Doc;
import java.util.*;

public class DoctorList {

    private List <Doctor> doctors = new LinkedList<Doctor>();

    public List<String> getSpecializationUnique() {
        List<String> specializatonUnique = new LinkedList<>();
        for (Doctor doctor: doctors) {
            if (!specializatonUnique.contains(Doctor.specializations)) {
                specializatonUnique.add(Arrays.toString(Doctor.specializations));
            }
        }
        return specializatonUnique;
    }

    public Map <String, Integer> getMapSpecialization() {
        Map <String, Integer> map = new HashMap<>();
        for (Doctor doctor : doctors) {
            if(map.containsKey(doctor.getSpecialization())){
                map.replace(doctor.getSpecialization(), map.get(doctor.getSpecialization())+1);
            } else {
                map.put(doctor.getSpecialization(), 1);
            }
        }
        return map;
    }


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
