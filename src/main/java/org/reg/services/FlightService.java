package org.reg.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.reg.exceptions.FieldNotCompletedException;
import org.reg.model.Flight;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static org.reg.services.FileSystemService.getPathToFlight;

public class FlightService {
    private static ObjectRepository<Flight> flightRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFlight("offers-database.db").toFile())
                .openOrCreate("test", "test");

        flightRepository = database.getRepository(Flight.class);
    }

    public static void addFlight(String id, String code, String name, String source, String destination,
                                      String capacity, String flightClass) {
        flightRepository.insert(new Flight(id, code, name, source, destination, capacity, flightClass));
    }

    public static void checkAllFieldCompleted (String code, String name, String source, String destination,
                                               String capacity, String flightClass) throws FieldNotCompletedException {
        if(code.trim().isEmpty() || name.trim().isEmpty() || source.trim().isEmpty() || destination.trim().isEmpty() ||
        capacity.trim().isEmpty() || flightClass.trim().isEmpty()) {
            throw new FieldNotCompletedException();
        }
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }

    public static ObjectRepository<Flight> getFlightRepository() {
        return flightRepository;
    }
}
