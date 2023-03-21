package springFrameworkSpringBoot.S3DependencyInjectionWithSpring.services.i18N;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springFrameworkSpringBoot.S3DependencyInjectionWithSpring.services.GreetingService;

/**
 * @Created 15 03 2023 - 4:22 PM
 * @Author Hazeem Hassan
 */

@Profile({"EN","default"})
@Service("i18NService")
public class EnglishGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Executed from English Greeting Service.\tHello World - EN";
    }
}
