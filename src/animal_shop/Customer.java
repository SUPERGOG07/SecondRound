package animal_shop;

import java.time.LocalDate;

public class Customer {

    private String name;

    private int frequency;

    private LocalDate lastTime;

    @Override
    public String toString() {
        return "animal_shop.Customer{" +
                "name='" + name + '\'' +
                ", frequency=" + frequency +
                ", lastTime=" + lastTime +
                '}';
    }

    public Customer(String name) {
        this.name = name;
        this.frequency = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public LocalDate getLastTime() {
        return lastTime;
    }

    public void setLastTime(LocalDate lastTime) {
        this.lastTime = lastTime;
    }
}
