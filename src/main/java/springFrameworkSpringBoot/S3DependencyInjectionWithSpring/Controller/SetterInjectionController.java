package springFrameworkSpringBoot.S3DependencyInjectionWithSpring.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import springFrameworkSpringBoot.S3DependencyInjectionWithSpring.services.GreetingService;


/**
 * @Created 15 03 2023 - 4:26 PM
 * @Author Hazeem Hassan
 */

public class SetterInjectionController {

    private GreetingService greetingService;

    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHelloFromSetterController() {
        return "Executing from Setter Injection Controller Class.\n" + greetingService.sayGreeting();
    }
}
