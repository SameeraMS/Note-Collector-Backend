package org.example.notecollecter.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//presentation/controller layer ekat adala configs

@Configuration
@ComponentScan(basePackages = "org.example.notecollecter")
@EnableWebMvc
public class WebAppConfig {
}
