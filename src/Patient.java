public class Patient extends Human implements Comparable <Patient> {
    private int numberMedicalCart;
    private boolean insurance;
    private String diagnosis;

    public Patient() {

    }

    public Patient(int id, String lastname, String name, String fatherName, String adress, int telephone, int numberMedicalCart, boolean insurance, String diagnosis) {
        super(id, lastname, name, fatherName, adress, telephone);
        this.numberMedicalCart = numberMedicalCart;
        this.insurance = insurance;
        this.diagnosis = diagnosis;
    }

    public int getNumberMedicalCart() {
        return numberMedicalCart;
    }

    public void setNumberMedicalCart(int numberMedicalCart) {
        this.numberMedicalCart = numberMedicalCart;
    }

    public boolean isInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "numberMedicalCart=" + numberMedicalCart +
                ", insurance=" + insurance +
                ", diagnosis='" + diagnosis + '\'' +
                ", id=" + id +
                ", lastname='" + lastname + '\'' +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", adress='" + adress + '\'' +
                ", telephone=" + telephone +
                "} ";
    }

    @Override
    public int compareTo(Patient o) {
        return this.getNumberMedicalCart() - o.getNumberMedicalCart();
    }

    public static String dagnosis[] = {
            "Астма", "Бронхіт", "Запалення", "Риніт", "Трахеїт", "Алергія", "Обструкція"
    };
}