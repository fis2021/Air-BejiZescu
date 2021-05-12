package org.reg.services;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemService {
    private static final String APPLICATION_FOLDER = ".registration-database";
    private static final String FLIGHTS_FOLDER = ".flights-database";
    private static final String USER_FOLDER = System.getProperty("user.home");
    public static final Path APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, APPLICATION_FOLDER);
    public static final Path FLIGHTS_HOME_PATH = Paths.get(USER_FOLDER, FLIGHTS_FOLDER);

    public static Path getPathToFile(String... path) {
        return APPLICATION_HOME_PATH.resolve(Paths.get(".", path));
    }

    public static Path getPathToFlight(String... path) {
        return FLIGHTS_HOME_PATH.resolve(Paths.get(".", path));
    }
}
