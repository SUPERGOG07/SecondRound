package animal_shop;

public abstract class Animal {

    private String name;

    private int age;
    /**
     * male:1
     * female:2
     */
    private int sex;

    /**
     * 买入的价格
     */
    private double bidPrice;

    /**
     * 卖出的价格
     */
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Animal(String name, int age, int sex, double bidPrice, double price) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.bidPrice = bidPrice;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", bidPrice=" + bidPrice +
                ", price=" + price +
                '}';
    }
}
