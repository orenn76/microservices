package com.ninyo.client.resteasy;

import com.ninyo.client.resteasy.gson.GsonMessageBodyReader;
import com.ninyo.client.resteasy.gson.GsonMessageBodyWriter;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.springframework.stereotype.Service;

//import java.util.concurrent.TimeUnit;

@Service
public class ResteasyClientFactory {
    private static final long CONNECTION_TIMEOUT_MILLIS = 500L;
    private static final long SOCKET_TIMEOUT_MILLIS = 5000L;

    public static <T> T createClient(Class<T> type, String serviceUrl) {
        ResteasyClient resteasyClient = new ResteasyClientBuilder()
                .register(new GsonMessageBodyReader())
                .register(new GsonMessageBodyWriter())
                //.establishConnectionTimeout(CONNECTION_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS) TODO oren
                //.socketTimeout(SOCKET_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS) TODO oren
                .connectionPoolSize(100)
                .build();
        ResteasyWebTarget resteasyWebTarget = resteasyClient.target(serviceUrl);
        return (T) resteasyWebTarget.proxy(type);
    }
}