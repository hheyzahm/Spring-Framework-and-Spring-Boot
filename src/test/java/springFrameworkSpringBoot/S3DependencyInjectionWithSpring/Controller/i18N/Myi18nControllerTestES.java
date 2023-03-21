package springFrameworkSpringBoot.S3DependencyInjectionWithSpring.Controller.i18N;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("ES")
@SpringBootTest
class Myi18nControllerTestES {

   @Autowired
   Myi18nController myi18nController;

    @Test
    void sayHello_i18n() {
        System.out.println(myi18nController.sayHello_i18n());
    }
}