package kerner1000;

import feign.RetryableException;
import feign.Retryer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyRetryer implements Retryer {

    private final RetryConfig retryConfig;

   private final Retryer delegate;

    int attempt;

    public MyRetryer(RetryConfig retryConfig){
        this.retryConfig = retryConfig;
        this.delegate = new Default(retryConfig.delay, retryConfig.maxRetryTime, retryConfig.attempts);
    }

    @Override
    public void continueOrPropagate(RetryableException e) {
        log.debug("Attempt {}", ++attempt);
        delegate.continueOrPropagate(e);
    }

    @Override
    public Retryer clone() {
        return new MyRetryer(retryConfig);
    }


}
