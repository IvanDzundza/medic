import javax.print.Doc;
import java.util.*;
import java.util.stream.Collectors;

public class DoctorList {

    private List<Doctor> doctors = new LinkedList<Doctor>();

    public List<String> getSpecializationUnique() {
        List<String> specializatonUnique = new LinkedList<>();
        for (Doctor doctor : doctors) {
            if (!specializatonUnique.contains(Doctor.specializations)) {
                specializatonUnique.add(Arrays.toString(Doctor.specializations));
            }
        }
        return specializatonUnique;
    }

    public List<String> getSpecializationUniqueStream() {
        return doctors.stream()
                .map(doctor -> doctor.getSpecialization())
                .distinct()
                .collect(Collectors.toList());
    }

    public Map<String, Integer> getMapSpecialization() {
        Map<String, Integer> mapSpecialization = new HashMap<>();
        for (Doctor doctor : doctors) {
            if (mapSpecialization.containsKey(doctor.getSpecialization())) {
                mapSpecialization.replace(doctor.getSpecialization(), mapSpecialization.get(doctor.getSpecialization()) + 1);
            } else {
                mapSpecialization.put(doctor.getSpecialization(), 1);
            }
        }
        return mapSpecialization;
    }

    public Map<String, List<Doctor>> getMapSpecializationDoctor() {
        Map<String, List<Doctor>> mapMapSpecializationListDoctor = new HashMap<>();
        for (Doctor doctor : doctors) {
            if (mapMapSpecializationListDoctor.containsKey(doctor.getSpecialization())) {
                mapMapSpecializationListDoctor.get(doctor.getSpecialization()).add(doctor);
            } else {
                List<Doctor> list = new LinkedList<>();
                list.add(doctor);
                mapMapSpecializationListDoctor.put(doctor.getSpecialization(), list);
            }
        }
        return mapMapSpecializationListDoctor;
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

    public List<Doctor> filterBySpecializationByStream(String specializations) {
        return doctors.stream()
                .filter(doctor -> doctor.getSpecialization().equalsIgnoreCase(specializations))
                .toList();
    }

    public List<Doctor> filterBySpecialization() {
        String specialization;
        System.out.println("Введіть спеціальність доктора:");
        Scanner scanner = new Scanner(System.in);
        specialization = scanner.nextLine();
        return filterBySpecializationByStream(specialization);
    }

    public List<Doctor> filterDoctorsWithLicense() {
        List<Doctor> doctorsArrayList = new ArrayList<>();

        for(Doctor doctor : doctors){
            if(doctor.isLicense()){
                doctorsArrayList.add(doctor);
            }
        } return doctorsArrayList;

    }

    public List<Doctor> filterDoctorsWithLicenseByStream() {
        return doctors.stream()
                .filter(doctor -> doctor.isLicense())
                .toList();
    }

    public void addRandomDoctors(int numberOfDoctors) {
        Random random = new Random();

        for (int i = 0; i < numberOfDoctors; i++) {
            doctors.add(new Doctor(i, Human.lastNames[random.nextInt(Human.lastNames.length)], "Тарас", "Тарасович", "Мазепи", random.nextInt(999), Doctor.specializations[random.nextInt(Doctor.specializations.length)], random.nextBoolean()));

        }
    }

    public List<Doctor> getAll() {
        return doctors;
    }

}
