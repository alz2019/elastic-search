package com.alz2019;

import com.alz2019.ElasticsearchApp;
import com.alz2019.config.AsyncSyncConfiguration;
import com.alz2019.config.EmbeddedElasticsearch;
import com.alz2019.config.EmbeddedKafka;
import com.alz2019.config.EmbeddedMongo;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { ElasticsearchApp.class, AsyncSyncConfiguration.class })
@EmbeddedMongo
@EmbeddedElasticsearch
@EmbeddedKafka
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public @interface IntegrationTest {
    // 5s is the spring default https://github.com/spring-projects/spring-framework/blob/29185a3d28fa5e9c1b4821ffe519ef6f56b51962/spring-test/src/main/java/org/springframework/test/web/reactive/server/DefaultWebTestClient.java#L106
    String DEFAULT_TIMEOUT = "PT10S";

    String DEFAULT_ENTITY_TIMEOUT = "PT10S";
}
