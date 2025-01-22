package adoptionshop.adoptionshop.Exceptions;

public class AnimalAlreadyAdoptedException extends RuntimeException{
    public AnimalAlreadyAdoptedException(String message){
        super(message);
    }
}
