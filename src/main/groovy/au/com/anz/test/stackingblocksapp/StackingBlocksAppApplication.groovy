package au.com.anz.test.stackingblocksapp

import groovy.util.logging.Slf4j

import au.com.anz.test.stackingblocksapp.cli.InputHandler
import au.com.anz.test.stackingblocksapp.exception.ValidationException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

import static java.lang.Runtime.getRuntime
import static java.lang.String.format

@SpringBootApplication
@Slf4j
class StackingBlocksAppApplication implements CommandLineRunner {

  private static volatile boolean EXIT
  @Autowired
  InputHandler inputHandler

  static void main(String[] args) {
    SpringApplication.run(StackingBlocksAppApplication, args)
  }

  @Override
  void run(String... args) throws Exception {
    log.info("Stacking blocks Application")
    log.info("Press CTRL+Z on windows and CTRL+D on Mac OS to exit...")
    try {
      try (Scanner scanner = new Scanner(System.in)) {
        while (!EXIT) {
          log.info("Please input blocks: ")
          String line = scanner.nextLine()
          try {
            inputHandler.dispatch(line)
          }
          catch (ValidationException ex) {
            log.error("Validation error :${ex.message}")
          }
        }
      }
    }
    catch (Exception e) {
      log.error(format("An error occurred: %s", e))
    }

    getRuntime().addShutdownHook(new Thread(() -> EXIT = true))

  }
}
