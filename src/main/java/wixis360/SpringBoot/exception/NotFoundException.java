package wixis360.SpringBoot.exception;

/**
 * @author : Rashmi De Zoysa
 * @Date :25-Aug-21
 **/
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message){
        super(message);
    }
}
