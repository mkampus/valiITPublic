package ee.bcs.valiit.solution.errorsexception;

public class ApplicationException extends RuntimeException {
    public ApplicationException(String message) {
        super(message);
    }
}
