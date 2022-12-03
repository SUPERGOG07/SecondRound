package animal_shop;

public class ChineseGardenDog extends Animal{

    private boolean isVaccineInjected;

    public boolean isVaccineInjected() {
        return isVaccineInjected;
    }

    public void setVaccineInjected(boolean vaccineInjected) {
        isVaccineInjected = vaccineInjected;
    }

    public ChineseGardenDog(String name, int age, int sex, boolean isVaccineInjected) {
        super(name, age, sex, 50, 100);
        this.isVaccineInjected = isVaccineInjected;
    }
}
