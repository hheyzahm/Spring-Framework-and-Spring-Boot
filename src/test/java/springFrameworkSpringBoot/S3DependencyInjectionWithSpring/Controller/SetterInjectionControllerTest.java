package springFrameworkSpringBoot.S3DependencyInjectionWithSpring.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import springFrameworkSpringBoot.S3DependencyInjectionWithSpring.services.GreetingServiceImpl;

import static org.junit.jupiter.api.Assertions.*;


class SetterInjectionControllerTest {

SetterInjectionController setterInjectionController;
    @BeforeEach
    void setUp() {
        setterInjectionController =new SetterInjectionController();
        setterInjectionController.setGreetingService(new GreetingServiceImpl());
    }


    @Test
    void sayHelloFromSetterController() {
        System.out.println(setterInjectionController.sayHelloFromSetterController());
    }
}