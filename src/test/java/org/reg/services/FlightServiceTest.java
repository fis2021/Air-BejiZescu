package org.reg.services;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.reg.model.Flight;

import static org.assertj.core.api.Assertions.assertThat;

class FlightServiceTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All");
    }

    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.FLIGHTS_FOLDER = ".test-flights-database";
        FileSystemService.initFlightsDirectory();
        FileUtils.cleanDirectory(FileSystemService.getFlightsHomeFolder().toFile());
        FlightService.initDatabase();
    }

    @AfterEach
    void tearDown() {
        FlightService.getDatabase().close();
    }

    @Test
    @DisplayName("Database is initialized, and there are no offers")
    void testDatabaseIsInitializedAndNoOfferIsPersisted() {
        assertThat(FlightService.getAllFlights()).isNotNull();
        assertThat(FlightService.getAllFlights()).isEmpty();
    }

    @Test
    @DisplayName("Flight is successfully persisted to Database")
    void testOfferIsAddedToDatabase(){
        FlightService.addFlight("1","key","2005","flight","Craiova","Bucuresti","5000","A");
        assertThat(FlightService.getAllFlights()).isNotEmpty();
        assertThat(FlightService.getAllFlights()).size().isEqualTo(1);
        Flight flight = FlightService.getAllFlights().get(0);
        assertThat(flight).isNotNull();
        assertThat(flight.getId()).isEqualTo("1");
        assertThat(flight.getPersonalKey()).isEqualTo("key");
        assertThat(flight.getCode()).isEqualTo("2005");
        assertThat(flight.getName()).isEqualTo("flight");
        assertThat(flight.getSource()).isEqualTo("Craiova");
        assertThat(flight.getDestination()).isEqualTo("Bucuresti");
        assertThat(flight.getCapacity()).isEqualTo("5000");
        assertThat(flight.getFlightClass()).isEqualTo("A");
    }
}