package ru.netology.ticket;

import java.util.Arrays;

public class ManagerTickets {

  private RepositoryTickets repository;

  public ManagerTickets(RepositoryTickets repository) {
    this.repository = repository;
  }

  public void addTicket(Ticket ticket) {
    repository.save(ticket);
  }

  public Ticket[] searchTicketsByAviaRouteWithSortedByPrice(String departure, String arrival) {
    Ticket[] tickets = repository.findTickets();
    Ticket[] result = new Ticket[0];
    for (Ticket ticket : tickets) {
      if (departure.equals(ticket.getAirportDeparture()) && arrival.equals(ticket.getAirportArrival())) {
        Ticket[] tmp = new Ticket[result.length + 1];
        for (int i = 0; i < result.length; i++) {
          tmp[i] = result[i];
        }
        tmp[tmp.length - 1] = ticket;
        result = tmp;
      }
    }
    Arrays.sort(result);
    return result;
  }

  public Ticket[] searchTicketsById(int id1, int id2, int id3) {
    Ticket[] tickets = repository.findTickets();
    Ticket[] result = new Ticket[0];
    for (Ticket ticket : tickets) {
      if (ticket.getId() == id1 || ticket.getId() == id2 || ticket.getId() == id3) {
        Ticket[] tmp = new Ticket[result.length + 1];
        for (int i = 0; i < result.length; i++) {
          tmp[i] = result[i];
        }
        tmp[tmp.length - 1] = ticket;
        result = tmp;
      }
    }
    Arrays.sort(result);
    return result;
  }

  public Ticket[] searchTicketsByFlightDurationAndSelectedAviaRoute(String departure, String arrival, int minFlightDuration, int maxFlightDuration) {
    Ticket[] tickets = repository.findTickets();
    Ticket[] result = new Ticket[0];
    for (Ticket ticket : tickets) {
      if (departure.equals(ticket.getAirportDeparture()) && arrival.equals(ticket.getAirportArrival())) {
        if (ticket.getFlightDuration() >= minFlightDuration && ticket.getFlightDuration() <= maxFlightDuration) {
          Ticket[] tmp = new Ticket[result.length + 1];
          for (int i = 0; i < result.length; i++) {
            tmp[i] = result[i];
          }
          tmp[tmp.length - 1] = ticket;
          result = tmp;
        }
      }
    }
    Arrays.sort(result);
    return result;
  }
}

