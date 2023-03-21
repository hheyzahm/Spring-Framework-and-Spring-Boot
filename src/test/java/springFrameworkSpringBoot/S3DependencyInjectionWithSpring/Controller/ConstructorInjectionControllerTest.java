package springFrameworkSpringBoot.S3DependencyInjectionWithSpring.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springFrameworkSpringBoot.S3DependencyInjectionWithSpring.services.GreetingServiceImpl;


class ConstructorInjectionControllerTest {

    ConstructorInjectionController constructorInjectionController;
    @BeforeEach
    void setUp() {
        constructorInjectionController=new ConstructorInjectionController(new GreetingServiceImpl());
    }

    @Test
    void sayHelloFromConstructorController() {
        System.out.println(constructorInjectionController.sayHelloFromConstructorController());
    }
}