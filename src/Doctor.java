public class Doctor extends Human implements Comparable <Doctor>{
    private String specialization;
    private boolean license;

    public Doctor() {

    }


    public Doctor(int id, String lastname, String name, String fatherName, String adress, int telephone, String specialization, boolean license) {
        super(id, lastname, name, fatherName, adress, telephone);
        this.specialization = specialization;
        this.license = license;
    }

    public boolean isLicense() {
        return license;
    }

    public void setLicense(boolean license) {
        this.license = license;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "license='" + license + '\'' +
                "specialization='" + specialization + '\'' +
                ", id=" + id +
                ", lastname='" + lastname + '\'' +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", adress='" + adress + '\'' +
                ", telephone=" + telephone +
                "} " ;
    }

    @Override
    public int compareTo(Doctor o) {
        return this.getLastname().compareTo(o.getLastname());
    }

    public static String specializations[] = {
            "Сімейний лікар", "Алерголог", "Терапевт", "Пульмонолог", "Лор", "Інтерн", "Інтерн-початківець"
    };
}
