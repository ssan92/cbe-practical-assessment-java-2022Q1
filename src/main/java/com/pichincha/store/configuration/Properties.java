package com.pichincha.store.configuration;

import static lombok.AccessLevel.PRIVATE;

import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@FieldDefaults(level = PRIVATE)
@ConfigurationProperties(prefix = "application", ignoreInvalidFields = false)
public class Properties {

  String productUrl;
}
