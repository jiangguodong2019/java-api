public class PasswordException extends RuntimeException{
    private String message;

    public PasswordException(String message) {
    }

    public PasswordException(String message, String message1) {
        super(message);

    }

    public PasswordException(String message, Throwable cause, String message1) {
        super(message, cause);

    }

    public PasswordException(Throwable cause, String message) {
        super(cause);

    }

    public PasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);

    }

    public PasswordException(int type, String message) {
        switch (type){
            case 1:
                System.out.println(message);
                break;
            case 2:
                System.out.println(message);
                break;
            case 3:
                System.out.println(message);
                break;
        }
    }
}
