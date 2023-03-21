package springFrameworkSpringBoot.S3DependencyInjectionWithSpring.services.i18N;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springFrameworkSpringBoot.S3DependencyInjectionWithSpring.services.GreetingService;

/**
 * @Created 15 03 2023 - 4:22 PM
 * @Author Hazeem Hassan
 */
@Profile("ES")
@Service("i18NService")
public class SpanishGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Executed from Spanish Greeting Service\tHola Mundo - ES";
    }

}
