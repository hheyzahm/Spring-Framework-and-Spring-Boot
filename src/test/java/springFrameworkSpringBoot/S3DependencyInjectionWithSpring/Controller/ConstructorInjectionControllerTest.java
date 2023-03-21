package springFrameworkSpringBoot.S3DependencyInjectionWithSpring.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springFrameworkSpringBoot.S3DependencyInjectionWithSpring.services.GreetingServiceImpl;


@SpringBootTest
class ConstructorInjectionControllerTest {

    @Autowired
    ConstructorInjectionController constructorInjectionController;


    @Test
    void sayHelloFromConstructorController() {
        System.out.println(constructorInjectionController.sayHelloFromConstructorController());
    }
}