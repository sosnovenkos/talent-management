package ru.iflexible.talent_management.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

import java.io.ByteArrayInputStream;

public class JsonUtils {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final Configuration JSON_PATH_CONFIG = Configuration.builder()
            .jsonProvider(new JacksonJsonNodeJsonProvider())
            .mappingProvider(new JacksonMappingProvider())
            .build();

    public static String toJson(Object object) {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return e.toString();
        }
    }

//    public static DocumentContext jsonFromTheSameClassPath(final Class<?> clazz, final String relativeFilePath) {
//        return JsonPath
//                .using(JSON_PATH_CONFIG)
//                .parse(inputStreamFromTheSameClassPath(clazz, relativeFilePath));
//    }

    public static DocumentContext jsonFromByteArray(final byte[] bytes) {
        return JsonPath
                .using(JSON_PATH_CONFIG)
                .parse(new ByteArrayInputStream(bytes));
    }
}