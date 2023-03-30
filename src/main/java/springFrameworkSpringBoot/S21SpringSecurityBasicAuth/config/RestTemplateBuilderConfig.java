package springFrameworkSpringBoot.S21SpringSecurityBasicAuth.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.client.RestTemplateBuilderConfigurer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.DefaultUriBuilderFactory;

/**
 * @Created 29 03 2023 - 2:47 PM
 * @Author Hazeem Hassan
 */
@Configuration
public class RestTemplateBuilderConfig {

    @Value("${rest.template.username}")
    String USERNAME;
    @Value("${rest.template.password}")
    String PASSWORD;
    @Value("${rest.template.rootURL}")
    String rootURL;

    @Bean
    RestTemplateBuilder restTemplateBuilder(RestTemplateBuilderConfigurer configurer) {
       /* assert rootURL != null;
        RestTemplateBuilder builder = configurer.configure(new RestTemplateBuilder());
        DefaultUriBuilderFactory uriBuilderFactory = new
                DefaultUriBuilderFactory(rootURL);

        RestTemplateBuilder templateBuilderAuth=builder.basicAuthentication(USERNAME,PASSWORD);
        return templateBuilderAuth.uriTemplateHandler(uriBuilderFactory);*/
        assert rootURL != null;

        return configurer.configure(new RestTemplateBuilder())
                .basicAuthentication(USERNAME, PASSWORD)
                .uriTemplateHandler(new DefaultUriBuilderFactory(rootURL));
    }
}
