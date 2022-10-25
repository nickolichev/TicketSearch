package ru.netology.ticket;

public class Ticket implements Comparable<Ticket> {

  private int id;
  private int priceTicket;
  private String airportDeparture;
  private String airportArrival;
  private int flightDuration;

  public Ticket(int id, int priceTicket, String airportDeparture, String airportArrival, int flightDuration) {
    this.id = id;
    this.priceTicket = priceTicket;
    this.airportDeparture = airportDeparture;
    this.airportArrival = airportArrival;
    this.flightDuration = flightDuration;
  }

  public int getId() {
    return id;
  }

  public int getPriceTicket() {
    return priceTicket;
  }

  public String getAirportDeparture() {
    return airportDeparture;
  }

  public String getAirportArrival() {
    return airportArrival;
  }

  public int getFlightDuration() {
    return flightDuration;
  }

  @Override
  public int compareTo(Ticket o) {
    return priceTicket - o.getPriceTicket();
  }
}