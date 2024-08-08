package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value = "request")
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.printf("[%s] [%s] [%s]\n", uuid, requestURL, message);
    }

    @PostConstruct
    public void init() {
        this.uuid = UUID.randomUUID().toString();
        System.out.printf("[%s] Request Scope Bean Created %s\n", uuid, this);

    }

    @PreDestroy
    public void destroy() {
        System.out.printf("[%s] Request Scope Bean Destroyed %s\n", uuid, this);

    }
}
