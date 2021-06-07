package br.com.themykael.concessionaria.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("br.com.themykael.concessionaria")
@EnableWebMvc
public class RootConfig {}
