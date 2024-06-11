import javax.print.Doc;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

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

    public List<String> getSpecializationUniqueByStream() {
        return doctors.stream()
                .map(doctor -> doctor.getSpecialization())
                .distinct()
                .collect(Collectors.toList());
    }

    public String getSpecializationUniqueByReduce() {
        return doctors.stream()
                .map(doctor -> doctor.getSpecialization())
                .distinct()
                .reduce("Specialization:", (s1, s2) -> s1 + "," + s2);
    }

    public long countDoctorsWithSpecializationByStream(String specializations) {
        return doctors.stream()
                .filter(doctor -> doctor.getSpecialization().equalsIgnoreCase(specializations))
                .count();
    }

    public String getDoctorsLastNames() {
        return doctors.stream()
                .collect(Collectors.mapping(doctor -> doctor.getLastname(), Collectors.joining(", ")));
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

    public Map<String, Long> getMapSpecializationCountingByStream() {
        return doctors.stream()
                .collect(groupingBy(doctor -> doctor.getSpecialization(), Collectors.counting()));
    }

    public Map<String, String> getDoctorsLastNameBySpecializationsMapByStream() {
        return doctors.stream()
                .collect(groupingBy(doctor -> doctor.getSpecialization(), Collectors.mapping(doctor -> doctor.getLastname(), Collectors.joining(","))));
    }

    public Map<Boolean, List<Doctor>> getDoctorsMapGroupingByLicense() {
        return doctors.stream()
                .collect(groupingBy(doctor -> doctor.isLicense()));
    }

    public Map<Boolean, List<Doctor>> getDoctorsMapPartitionByLicense() {
        return doctors.stream()
                .collect(Collectors.partitioningBy(doctor -> doctor.isLicense()));
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

    public Map<String, List<Doctor>> getMapSpecializationDoctorByStream() {
        return doctors.stream()
                .collect(groupingBy(doctor -> doctor.getSpecialization(), Collectors.toList()));
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
        return filterBySpecialization(specialization);
    }

    public List<Doctor> filterByDoctorTelephoneNumber (int start, int end) {
        int telephoneNumber;
        List<Doctor> doctorTelephone = new ArrayList<>();

        for(Doctor doctor : doctors) {
            telephoneNumber = doctor.getTelephone();
            if(telephoneNumber > start && telephoneNumber < end){
                doctorTelephone.add(doctor);
            }
        } return doctorTelephone;
    }

    public List<Doctor> filterByDoctorTelephoneNumberByStream (int start, int end) {
        return doctors.stream()
                .filter(doctor -> doctor.getTelephone() > start && doctor.getTelephone() < end)
                .toList();
    }


    public void addRandomDoctors(int numberOfDoctors) {
        Random random = new Random();

        for (int i = 0; i < numberOfDoctors; i++) {
            doctors.add(new Doctor(i, Human.lastNames[random.nextInt(Human.lastNames.length)], "Тарас", "Тарасович", "Мазепи", random.nextInt(999), Doctor.specializations[random.nextInt(Doctor.specializations.length)], true));

        }
    }


    public List<Doctor> getAll() {
        return this.doctors;
    }
}
