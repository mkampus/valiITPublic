package ee.bcs.valiit.tasks;

import java.util.HashMap;

public class Employee {

    private String Name;
    private String Address;
    private String LivesAlone;


    public String getLivesAlone() {
        return LivesAlone;
    }

    public void setLivesAlone(String livesAlone) {
        LivesAlone = livesAlone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
