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
public class PropertyInjectionController {
    /**
     * one way of using @Qualifier
     * @Qualifier("greetingServicePropertyInjected")
     */
    /**
     * Second way of using @Qualifier
     *    @Qualifier("greetingServiceProperty")
     * */
    @Qualifier("greetingServiceProperty")
    @Autowired
    GreetingService greetingService;

    public String sayHelloFromPropertyController(){
        return "Executing from Property Injection Controller Class.\n"+greetingService.sayGreeting();
    }
}
