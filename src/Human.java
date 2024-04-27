public abstract class Human {
    protected int id;
    protected String lastname;
    protected String name;
    protected String fatherName;
    protected String adress;
    protected int telephone;

    public Human () {

    }

    public Human(int id, String lastname, String name, String fatherName, String adress, int telephone) {
        this.id = id;
        this.lastname = lastname;
        this.name = name;
        this.fatherName = fatherName;
        this.adress = adress;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getName() {
        return name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getAdress() {
        return adress;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", adress='" + adress + '\'' +
                ", telephone=" + telephone +
                '}';
    }

    public static String lastNames[] = {
            "Петренко", "Василенко", "Гандзюк", "Андрушкевич", "Залежич", "Окасаневич", "Ганькевич"
    };
}


