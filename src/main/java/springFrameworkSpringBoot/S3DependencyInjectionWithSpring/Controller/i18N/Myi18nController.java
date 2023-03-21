package springFrameworkSpringBoot.S3DependencyInjectionWithSpring.Controller.i18N;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import springFrameworkSpringBoot.S3DependencyInjectionWithSpring.services.GreetingService;

/**
 * @Created 16 03 2023 - 11:24 AM
 * @Author Hazeem Hassan
 */
@Controller
public class Myi18nController {
    private final GreetingService greetingService;

    public Myi18nController(@Qualifier("i18NService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello_i18n() {
        return greetingService.sayGreeting();
    }

}
