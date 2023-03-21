package springFrameworkSpringBoot.S3DependencyInjectionWithSpring.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @Created 15 03 2023 - 5:39 PM
 * @Author Hazeem Hassan
 */
@Primary
@Service
public class GreetingServicePrimary implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello Everyone from the primary Bean";
    }
}
