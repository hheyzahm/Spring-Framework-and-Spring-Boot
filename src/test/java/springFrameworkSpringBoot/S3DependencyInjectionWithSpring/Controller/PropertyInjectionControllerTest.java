package springFrameworkSpringBoot.S3DependencyInjectionWithSpring.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springFrameworkSpringBoot.S3DependencyInjectionWithSpring.services.GreetingServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PropertyInjectionControllerTest {

    @Autowired
    PropertyInjectionController propertyInjectionController;

    @Test
    void sayHelloFromPropertyController() {
        System.out.println(propertyInjectionController.sayHelloFromPropertyController());
    }
}