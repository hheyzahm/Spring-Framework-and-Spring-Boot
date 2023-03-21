package springFrameworkSpringBoot.S3DependencyInjectionWithSpring.services.EnvironmentServices;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @Created 16 03 2023 - 12:01 PM
 * @Author Hazeem Hassan
 */
@Profile("uat")
@Service
public class EnvironmentServiceUserAcceptingTesting implements EnvironmentService{
    @Override
    public String getEnv() {
        return "uat";
    }
}
