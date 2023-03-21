package springFrameworkSpringBoot.S3DependencyInjectionWithSpring.services;

import org.springframework.stereotype.Service;

/**
 * @Created 15 03 2023 - 4:22 PM
 * @Author Hazeem Hassan
 */
@Service
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello Everyone from Base Service (Greeting Service).";
    }
}
