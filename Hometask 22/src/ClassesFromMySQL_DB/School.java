package ClassesFromMySQL_DB;

/**
 * Created by vig on 2/8/17.
 */
public class School {
    private Long id;
    private String address;
    private Integer number;
    private Byte floors;
    private String speciality;

    public School(Long id, String address, Integer number, Byte floors, String speciality) {
        this.id = id;
        this.address = address;
        this.number = number;
        this.floors = floors;
        this.speciality = speciality;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Byte getFloors() {
        return floors;
    }

    public void setFloors(Byte floors) {
        this.floors = floors;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
