package animal_shop;

import java.time.LocalDate;

public interface AnimalShop {

    void open();

    void buyNewAnimal(Animal animal);

    void entertainCustomers(Customer customer);

    void close();
}
