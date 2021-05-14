package org.reg.model;

import org.dizitart.no2.objects.Id;

import java.util.ArrayList;

public class Flight {
    @Id
    private String id;
    private String personalKey;
    private String code;
    private String name;
    private String source;
    private String destination;
    private String capacity;
    private String flightClass;

    private ArrayList<String> enrolledPassengers = new ArrayList<String>();

    public ArrayList<String> getEnrolledPassengers() { return enrolledPassengers; }

    public void setEnrolledPassengers(ArrayList<String> enrolledPassengers) { this.enrolledPassengers = enrolledPassengers; }



    public Flight(String id, String personalKey, String code, String name, String source, String destination,
                  String capacity, String flightClass)
    {
        this.id = id;
        this.personalKey = personalKey;
        this.code = code;
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.capacity = capacity;
        this.flightClass = flightClass;
    }

    public Flight(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonalKey() { return personalKey; }

    public void setPersonalKey(String personalKey) { this.personalKey = personalKey; }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

}
