package springFrameworkSpringBoot.S3DependencyInjectionWithSpring.Controller.EnvirnomentControl;

import org.springframework.stereotype.Controller;
import springFrameworkSpringBoot.S3DependencyInjectionWithSpring.services.EnvironmentServices.EnvironmentService;

/**
 * @Created 16 03 2023 - 11:59 AM
 * @Author Hazeem Hassan
 */
@Controller
public class EnvironmentController {
    private final EnvironmentService environmentService;

    public EnvironmentController(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    public String getEnvironment(){
        String text="";
        if (environmentService.getEnv().equals("dev"))
            text="Development";
        else if(environmentService.getEnv().equals("prod"))
            text="Production";
        else if(environmentService.getEnv().equals("qa"))
            text="Quality Assurance";
        else if(environmentService.getEnv().equals("uat"))
            text="User Acceptance Testing";

        return "You are in " + text + " Environment";
    }

}
