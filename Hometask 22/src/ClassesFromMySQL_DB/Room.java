package ClassesFromMySQL_DB;

/**
 * Created by vig on 2/8/17.
 */
public class Room {
    private Long id;
    private Integer number;
    private Byte floor;
    private Byte amount;
    private Long schoolId;

    public Room(Long id, Integer number, Byte floor, Byte amount, Long schoolId) {
        this.id = id;
        this.number = number;
        this.floor = floor;
        this.amount = amount;
        this.schoolId = schoolId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Byte getFloor() {
        return floor;
    }

    public void setFloor(Byte floor) {
        this.floor = floor;
    }

    public Byte getAmount() {
        return amount;
    }

    public void setAmount(Byte amount) {
        this.amount = amount;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }
}
