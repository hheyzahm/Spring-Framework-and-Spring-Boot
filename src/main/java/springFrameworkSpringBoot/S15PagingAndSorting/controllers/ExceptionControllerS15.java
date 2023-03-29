package springFrameworkSpringBoot.S15PagingAndSorting.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import springFrameworkSpringBoot.S8ExceptionHandling.NotFoundException;

/**
 * @Created 22 03 2023 - 2:28 PM
 * @Author Hazeem Hassan
 */
//@ControllerAdvice
// above annotation is used for global exception handler process
public class ExceptionControllerS15 {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException() {
        return ResponseEntity.notFound().build();
    }
}
