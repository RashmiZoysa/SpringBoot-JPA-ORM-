package wixis360.SpringBoot.exception;

/**
 * @author : Rashmi De Zoysa
 * @Date :25-Aug-21
 **/
public class ValidateException extends RuntimeException {
    public ValidateException(String message){
        super(message);
    }
}
