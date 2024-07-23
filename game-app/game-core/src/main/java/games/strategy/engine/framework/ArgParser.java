package games.strategy.engine.framework;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/** Command line argument parser, parses args formatted as: "-Pkey=value". */
public final class ArgParser {
  public static final String TRIPLEA_PROTOCOL = "triplea:";

  private ArgParser() {}

  /** Move command line arguments to system properties or client settings. */
  public static void handleCommandLineArgs(final String... args) {
    if ((args.length == 1) && args[0].startsWith(TRIPLEA_PROTOCOL)) {
      final String value = URLDecoder.decode(args[0].substring(TRIPLEA_PROTOCOL.length()), StandardCharsets.UTF_8);
      System.setProperty(CliProperties.TRIPLEA_MAP_DOWNLOAD, value);
    } else if ((args.length == 1) && !args[0].contains("=")) {
      System.setProperty(CliProperties.TRIPLEA_GAME, args[0]);
    } else {
      ArgParsingHelper.getTripleaProperties(args)
          .forEach((key, value) -> System.setProperty((String) key, (String) value));
    }
  }

}
