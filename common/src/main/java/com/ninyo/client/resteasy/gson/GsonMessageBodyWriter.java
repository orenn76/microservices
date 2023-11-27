package com.ninyo.client.resteasy.gson;

import com.google.common.base.Charsets;
import org.springframework.stereotype.Service;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Service
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class GsonMessageBodyWriter implements MessageBodyWriter<Object> {

    @Override
    public boolean isWriteable(final Class<?> type, final Type genericType, final Annotation[] annotations, final MediaType mediaType) {
        return true;
    }

    @Override
    public long getSize(final Object object, final Class<?> type, final Type genericType, final Annotation[] annotations, final MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(final Object object,
                        final Class<?> type,
                        final Type genericType,
                        final Annotation[] annotations,
                        final MediaType mediaType,
                        final MultivaluedMap<String, Object> httpHeaders,
                        final OutputStream entityStream) throws IOException {

        try (final OutputStreamWriter writer = new OutputStreamWriter(entityStream, Charsets.UTF_8)) {
            final Type jsonType;
            if (type.equals(genericType)) {
                jsonType = type;
            } else {
                if (genericType == null) {
                    jsonType = type.getGenericSuperclass();
                } else {
                    jsonType = genericType;
                }
            }
            new GsonService().toJson(object, jsonType, writer);
        }
    }
}