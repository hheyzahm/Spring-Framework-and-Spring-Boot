package springFrameworkSpringBoot.S3DependencyInjectionWithSpring.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import springFrameworkSpringBoot.S3DependencyInjectionWithSpring.services.GreetingService;


/**
 * @Created 15 03 2023 - 4:26 PM
 * @Author Hazeem Hassan
 */
@Controller
public class SetterInjectionController {

    private GreetingService greetingService;


    /**
     * one way of using @Qualifier
     * @Qualifier("greetingServiceSetterInjected")
     */
    /**
     * Second way of using @Qualifier
     *
     * @Qualifier("greetingServiceSetter")
     */
    @Qualifier("greetingServiceSetter")
    @Autowired
    public void setGreetingService(GreetingService greetingService) {
        System.out.println("SetterInjectedController.setGreetingService");
        this.greetingService = greetingService;
    }

    public String sayHelloFromSetterController() {
        return "Executing from Setter Injection Controller Class.\n" + greetingService.sayGreeting();
    }
}
