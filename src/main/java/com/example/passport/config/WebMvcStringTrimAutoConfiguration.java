package com.example.passport.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.json.JsonParser;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.io.IOException;

public class WebMvcStringTrimAutoConfiguration {
    @ControllerAdvice
    public static class ControllerStringParamTrimConfig {

        /**
         * url和form表单中的参数trim
         */
        @InitBinder
        public void initBinder(WebDataBinder binder) {
            // 构造方法中 boolean 参数含义为如果是空白字符串,是否转换为null
            // 即如果为true,那么 " " 会被转换为 null,否者为 ""
            StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(false);
            binder.registerCustomEditor(String.class, stringTrimmerEditor);
        }

        /**
         * Request Body中JSON或XML对象参数trim
         */
        @Bean
        public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
            return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder
                    .deserializerByType(String.class, new StdScalarDeserializer<String>(String.class) {
                        @Override
                        public String deserialize(com.fasterxml.jackson.core.JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
                            return StringUtils.trimWhitespace(p.getValueAsString());
                        }
                    });
        }
    }
}
