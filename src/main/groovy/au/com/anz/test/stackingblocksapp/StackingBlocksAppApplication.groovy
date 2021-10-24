package au.com.anz.test.stackingblocksapp

import groovy.util.logging.Slf4j

import au.com.anz.test.stackingblocksapp.cli.CommandService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

import static java.lang.Runtime.getRuntime
import static java.lang.String.format

@SpringBootApplication
@Slf4j
class StackingBlocksAppApplication implements CommandLineRunner {

  private static volatile boolean EXIT;
  @Autowired
  CommandService blockCommandService;

  static void main(String[] args) {
    SpringApplication.run(StackingBlocksAppApplication, args)
  }

  @Override
  void run(String... args) throws Exception {
    log.info("Stacking blocks Application")
    log.info("Press Ctrl+C to exit...")
    try {
      try (Scanner scanner = new Scanner(System.in)) {
        while (!EXIT) {
          log.info("Input blocks = ")
          String line = scanner.nextLine();
          blockCommandService.execute(line)
        }
      }
    }
    catch (Exception e) {
      log.error(format("An error occurred: %s", e.getMessage()));
    }

    getRuntime().addShutdownHook(new Thread(() -> EXIT = true));

  }
}
