package springFrameworkSpringBoot.S3DependencyInjectionWithSpring.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyControllerTest {
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    MyController myController;

    @Test
    void testAutowiredOfController() {
        System.out.println(myController.sayHelloFromMyController());
    }
    @Test
    void testGetControllerFromCtx(){
        MyController myController=applicationContext.getBean(MyController.class);
        System.out.println(myController.sayHelloFromMyController());
    }

    @Test
    void sayHelloFromMyController() {
    }
}