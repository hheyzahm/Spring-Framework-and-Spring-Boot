package springFrameworkSpringBoot.S19SpringRestTemplate.config;


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
public class RestTemplateBuilderConfigS19 {

    @Value("${rest.template.rootURL}")
    String rootURL;

    @Bean
    RestTemplateBuilder restTemplateBuilder(RestTemplateBuilderConfigurer configurer) {
        assert rootURL != null;
        RestTemplateBuilder builder = configurer.configure(new RestTemplateBuilder());
        DefaultUriBuilderFactory uriBuilderFactory = new
                DefaultUriBuilderFactory(rootURL);
        return builder.uriTemplateHandler(uriBuilderFactory);
    }
}
