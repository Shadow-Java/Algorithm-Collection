import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * TODO
 *
 * @author shadow
 * @date 2023/6/1 10:11
 * @since 1.0
 */
@EnableAsync
@EnableCaching
@SpringBootConfiguration
@Slf4j
public class Application implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }
}
