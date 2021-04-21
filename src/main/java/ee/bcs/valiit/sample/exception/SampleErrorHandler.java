package ee.bcs.valiit.sample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class SampleErrorHandler {


    @ExceptionHandler(SampleApplicationException.class)
    public ResponseEntity<Object> handleSampleException (SampleApplicationException e){
        return new ResponseEntity<>(new SampleErrorResponse(e.getMessage(), 400),
        HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public  ResponseEntity<Object> handleError (Exception e){
        e.printStackTrace();
        return new ResponseEntity<>(new SampleErrorResponse ("Internal error", 500),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
