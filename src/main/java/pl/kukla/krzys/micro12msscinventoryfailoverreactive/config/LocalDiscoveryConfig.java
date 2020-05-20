package pl.kukla.krzys.micro12msscinventoryfailoverreactive.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Krzysztof Kukla
 */
@Profile("local-discovery")
@EnableDiscoveryClient
@Configuration
public class LocalDiscoveryConfig {
}
