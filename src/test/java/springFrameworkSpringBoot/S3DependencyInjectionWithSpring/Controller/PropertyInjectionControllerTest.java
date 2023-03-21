package springFrameworkSpringBoot.S3DependencyInjectionWithSpring.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import springFrameworkSpringBoot.S3DependencyInjectionWithSpring.services.GreetingServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PropertyInjectionControllerTest {

    PropertyInjectionController propertyInjectionController;

    @BeforeEach
    void setup(){
        propertyInjectionController=new PropertyInjectionController();
        propertyInjectionController.greetingService=new GreetingServiceImpl();
    }
    @Test
    void sayHelloFromPropertyController() {
        System.out.println(propertyInjectionController.sayHelloFromPropertyController());
    }
}