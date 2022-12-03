package animal_shop.exception;

public class AnimalNotFoundException extends RuntimeException{
    public AnimalNotFoundException() {
        super();
    }

    public AnimalNotFoundException(String message) {
        super(message);
    }
}
