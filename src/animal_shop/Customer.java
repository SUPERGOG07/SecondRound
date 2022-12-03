import java.time.LocalDate;

public class Customer {

    String name;

    int frequency;

    LocalDate lastTime;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", frequency=" + frequency +
                ", lastTime=" + lastTime +
                '}';
    }
}
