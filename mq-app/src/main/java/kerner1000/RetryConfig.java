package kerner1000;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "messaging.retry")
public class RetryConfig {

    long delay;

    int attempts;

    long maxRetryTime;


}
