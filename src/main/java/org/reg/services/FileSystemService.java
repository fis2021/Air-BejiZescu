package org.reg.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemService {
    public static String APPLICATION_FOLDER = ".registration-database";
    public static String FLIGHTS_FOLDER = ".flights-database";
    private static final String USER_FOLDER = System.getProperty("user.home");
    public static final Path APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, APPLICATION_FOLDER);
    public static final Path FLIGHTS_HOME_PATH = Paths.get(USER_FOLDER, FLIGHTS_FOLDER);

    public static Path getPathToFile(String... path) {
        return APPLICATION_HOME_PATH.resolve(Paths.get(".", path));
    }

    public static Path getPathToFlight(String... path) {
        return FLIGHTS_HOME_PATH.resolve(Paths.get(".", path));
    }

    public static Path getApplicationHomeFolder() {
        return Paths.get(USER_FOLDER, APPLICATION_FOLDER);
    }

    public static Path getFlightsHomeFolder(){
        return Paths.get(USER_FOLDER,FLIGHTS_FOLDER);
    }

    public static void initDirectory() {
        Path applicationHomePath = FileSystemService.getApplicationHomeFolder();
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }

    public static void initFlightsDirectory(){
        Path offersHomePath = FileSystemService.getFlightsHomeFolder();
        if (!Files.exists(offersHomePath))
            offersHomePath.toFile().mkdirs();
    }


}
