package org.reg.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.reg.model.Flight;

import java.util.List;

import static org.reg.services.FileSystemService.getPathToFlight;

public class FlightService {
    private static ObjectRepository<Flight> flightRepository;
    private static Nitrite database;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFlight("flights-database.db").toFile())
                .openOrCreate("test", "test");

        flightRepository = database.getRepository(Flight.class);
    }

    public static void addFlight(String id, String personalKey, String code, String name, String source, String destination,
                                 String capacity, String flightClass) {
        flightRepository.insert(new Flight(id, personalKey, code, name, source, destination, capacity, flightClass));
    }

    public static ObjectRepository<Flight> getFlightRepository() {
        return flightRepository;
    }

    public static Flight getFlightFromDatabase(String username) {
        for(Flight flight : flightRepository.find()) {
            if(flight.getName().equals(username)) {
                return flight;
            }
        }
        return null;
    }

    public static Nitrite getDatabase() {
        return database;
    }

    public static List<Flight> getAllFlights() {
        return flightRepository.find().toList();
    }


}
