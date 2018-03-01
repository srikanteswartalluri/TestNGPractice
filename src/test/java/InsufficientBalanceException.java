public class InsufficientBalanceException extends  Exception{
    public InsufficientBalanceException() {
        super();
    }

    public InsufficientBalanceException(String message, Throwable cause) {
        super(message, cause);
    }

}
