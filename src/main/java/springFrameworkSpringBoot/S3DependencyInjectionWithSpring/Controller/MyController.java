package springFrameworkSpringBoot.S3DependencyInjectionWithSpring.Controller;

import org.springframework.stereotype.Controller;
import springFrameworkSpringBoot.S3DependencyInjectionWithSpring.services.GreetingService;
import springFrameworkSpringBoot.S3DependencyInjectionWithSpring.services.GreetingServiceImpl;

/**
 * @Created 15 03 2023 - 3:58 PM
 * @Author Hazeem Hassan
 */
@Controller
public class MyController {

    private final GreetingService greetingService;

    /**
     * this below will be use when we have not mentioned a @Service annotation in GreetingServiceImpl class
     */
    public MyController() {
        this.greetingService = new GreetingServiceImpl();
    }

    public String sayHelloFromMyController() {
        System.out.println("I'm in the controller");
        return "Hello Everyone from MyController CLass";

    }
}
