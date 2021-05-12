package org.reg.model;

import org.dizitart.no2.objects.Id;

public class Flight {
    @Id
    private String id;
    private String code;
    private String name;
    private String source;
    private String destination;
    private String capacity;
    private String flightClass;

    public Flight(String id, String code, String name, String source, String destination,
                  String capacity, String flightClass)
    {
        this.id = id;
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

    public void setId() {
        this.id = id;
    }

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
