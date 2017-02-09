package ClassesFromMySQL_DB;

/**
 * Created by vig on 2/8/17.
 */
public class Subject {
    private Long id;
    private String name;
    private Integer roomNumber;

    public Subject(Long id, String name, Integer roomNumber) {
        this.id = id;
        this.name = name;
        this.roomNumber = roomNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return name;
    }
}
