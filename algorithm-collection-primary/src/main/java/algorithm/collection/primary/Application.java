package algorithm.collection.primary;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Application
 *
 * @author shadow
 * @date 2023/6/1 10:11
 * @since 1.0
 */
@EnableAsync
@EnableCaching
@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }
}
