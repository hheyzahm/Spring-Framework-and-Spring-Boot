package springFrameworkSpringBoot.S8ExceptionHandeling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Created 22 03 2023 - 2:28 PM
 * @Author Hazeem Hassan
 */
//@ControllerAdvice
// above annotation is used for global exception handler process
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException() {
        return ResponseEntity.notFound().build();
    }
}
