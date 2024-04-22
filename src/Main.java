package src;

import src.Patient;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private Patient[] patients;


    public static void main(String[] args) {

        Main main = new Main();

        main.initArray(5);

        for (int i = 0; i < main.patients.length; i++) {

            System.out.println(main.patients[i]);
        }

//        main.filterByDiagnosis();
//        main.filterInsurance();
        main.printByMedicalCartNumberIn();


    }

    public void initArray(int arraySize) {

        patients = new Patient[arraySize];

        Random random = new Random();


        for (int i = 0; i < patients.length; i++) {
            patients[i] = new Patient(i, "Петренко", "Тарас", "Мазепи", 332, random.nextInt(100), random.nextBoolean(), "Astma");

        }


    }

    public void filterByDiagnosis(String diagnosis) {
        for (int i = 0; i < patients.length; i++) {
            if (patients[i].getDiagnosis().equalsIgnoreCase(diagnosis)) {
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

    public void filterInsurance() {
        int count = 0;
        for (int i = 0; i < patients.length; i++) {
            if (!patients[i].getInsurance()) {
                count++;
                System.out.println(patients[i]);
            }
        }
        System.out.println(count);
    }

    public void printByMedicalCartNumberIn(int start, int end) {
        int medicalCartNumber;

        for (int i = 0; i < patients.length; i++) {
            medicalCartNumber = patients[i].getNumberMedicalCart();
            if (medicalCartNumber > start && medicalCartNumber < end) {
                System.out.println(patients[i]);
            }
        }
    }
    public void printByMedicalCartNumberIn() {
        int start;
        int end;
        System.out.println("Введіть початкове значення:");
        Scanner scanner = new Scanner(System.in);
        start = scanner.nextInt();
        System.out.println("Введіть кінцеве значення:");
        end = scanner.nextInt();
        filterMedicalCart(start, end);




    }

}


