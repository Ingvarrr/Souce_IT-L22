package ClassesFromMySQL_DB;

/**
 * Created by vig on 2/8/17.
 */
public class Class1 {
    private Long id;
    private Integer roomNumber;
    private String number;

    public Class1(Long id, Integer roomNumber, String number) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return number;
    }
}
