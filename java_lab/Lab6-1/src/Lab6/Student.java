package Lab6;

public class Student {
    private String firstname;
    private String lastname;
    private String termin;
    private String usernmae;
    private String eamil;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTermin() {
        return termin;
    }

    public void setTermin(String termin) {
        this.termin = termin;
    }

    public String getUsernmae() {
        return usernmae;
    }

    public void setUsernmae(String usernmae) {
        this.usernmae = usernmae;
    }

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }

    public Student(String firstname, String lastname, String termin, String usernmae, String eamil) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.termin = termin;
        this.usernmae = usernmae;
        this.eamil = eamil;
    }
}
