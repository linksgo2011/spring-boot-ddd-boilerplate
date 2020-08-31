package org.domaindrivendesign.boilerplate.core;


import org.domaindrivendesign.boilerplate.core.model.AggregateRoot;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;

import java.util.UUID;

@Configuration
public class DaoConfiguration {

    @Bean
    public ApplicationListener<BeforeSaveEvent> idSetting() {
        return event -> {
            if (event.getEntity() instanceof AggregateRoot) {
                AggregateRoot aggregateRoot = (AggregateRoot) event.getEntity();
                if (aggregateRoot.getId() == null) {
                    aggregateRoot.setId(UUID.randomUUID().toString());
                }
            }
        };
    }
}
