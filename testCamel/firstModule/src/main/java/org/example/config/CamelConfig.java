package org.example.config;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class CamelConfig {
    @Bean
    public CamelContext camelContext() throws Exception {
        CamelContext ctx = new DefaultCamelContext();
        ctx.addRoutes(new CamelRouter());
        ctx.start();
        return ctx;

    }
    @Bean
    public ProducerTemplate producerTemplate() throws Exception {
        var ctx = camelContext();
        ProducerTemplate producer = ctx.createProducerTemplate();
        return producer;

    }

}
