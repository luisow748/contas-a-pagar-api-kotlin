package com.luisow748.contasapg.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.yml")
@AllArgsConstructor
class ConfigProperties(
    private val env: Environment
) {

    fun getConfigValue(key: String): String? {
        return env.getProperty(key)
    }
}

