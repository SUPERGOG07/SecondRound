public abstract class Animal {

    String name;

    int age;
    /**
     * male:1
     * female:2
     */
    int sex;

    double price;

    public Animal(String name, int age, int sex, double price) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", price=" + price +
                '}';
    }
}
