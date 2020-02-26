package com.clip.interview.configuration

import com.clip.interview.enums.ReportTypes
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter

@Configuration
class BeansConfiguration {
    @Bean
    fun reportTypesConverter() = Converter<String, ReportTypes> {
        ReportTypes.valueOf(it.toUpperCase())
    }
}