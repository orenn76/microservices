package com.ninyo.triangle.client.feign.exception;

import com.ninyo.crudcore.model.ErrorMessage;
import feign.Response;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
public class ClientErrorDecoder implements ErrorDecoder {

    private final Decoder decoder;
    private final ErrorDecoder defaultDecoder = new Default();
    public final static String RESPONSE_MSG_CODE_SYSTEM_ERR = "SYSTEM_ERROR";

    public ClientErrorDecoder(Decoder decoder) {
        this.decoder = decoder;
    }

    @Override
    public Exception decode(String methodKey, Response response) {

        if (response.status() >= 400 && response.status() < 500) {

            try {
                ErrorMessage errorMessage = (ErrorMessage) decoder.decode(response, ErrorMessage.class);
                if (errorMessage != null) {
                    return new ClientException(HttpStatus.valueOf(response.status()), errorMessage.getMessage());
                }

                return new ClientException(HttpStatus.valueOf(response.status()), RESPONSE_MSG_CODE_SYSTEM_ERR);
            } catch (Exception error) {
                log.warn("Unable to decode error response: {}", response, error);
            }
        }

        Exception ex = defaultDecoder.decode(methodKey, response);
        return new ClientException(HttpStatus.valueOf(response.status()), ex.getMessage());
    }
}
