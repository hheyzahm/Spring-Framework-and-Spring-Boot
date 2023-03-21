package springFrameworkSpringBoot.S3DependencyInjectionWithSpring.services;

import org.springframework.stereotype.Service;

/**
 * @Created 15 03 2023 - 4:22 PM
 * @Author Hazeem Hassan
 */
@Service("greetingServiceSetter")
public class GreetingServiceSetterInjected implements GreetingService
{

    @Override
    public String sayGreeting() {
        return "Executed from Greeting Service Setter Injected\t\t\tFriends don't let friends to Setter injection";
    }
}
