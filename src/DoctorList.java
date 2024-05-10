import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class DoctorList {
    LinkedList<Doctor> doctors = new LinkedList<Doctor>();

    public void addRandomDoctors(int numberOfDoctors) {
        Random random = new Random();

        for (int i = 0; i < numberOfDoctors; i++) {
            doctors.add(new Doctor(i, Human.lastNames[random.nextInt(Human.lastNames.length)], "Тарас", "Тарасович", "Мазепи", random.nextInt(999), Doctor.specializations[random.nextInt(Doctor.specializations.length)]));

        }
    }

}
