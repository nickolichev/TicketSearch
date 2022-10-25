package ru.netology.ticket;

public class RepositoryTickets {
  private Ticket[] tickets = new Ticket[0];

  public void save(Ticket ticket) {
    Ticket[] tmp = new Ticket[tickets.length + 1];
    for (int i = 0; i < tickets.length; i++) {
      tmp[i] = tickets[i];
    }
    tmp[tmp.length - 1] = ticket;
    tickets = tmp;
  }

  public Ticket[] findTickets() {
    return tickets;
  }

  public Ticket[] searchByAirportsDeparture(String departure) {
    Ticket[] result = new Ticket[0];
    for (Ticket ticket : tickets) {
      if (departure.equals(ticket.getAirportDeparture())) {
        int length = result.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(result, 0, tmp, 0, result.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        result = tmp;
      }
    }
    return result;
  }

  public Ticket[] searchByAirportsArrival(String arrival) {
    Ticket[] result = new Ticket[0];
    for (Ticket ticket : tickets) {
      if (arrival.equals(ticket.getAirportArrival())) {
        int length = result.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(result, 0, tmp, 0, result.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        result = tmp;
      }
    }
    return result;
  }

  public Ticket[] removeById(int id) {
    int length = tickets.length - 1;
    Ticket[] tmp = new Ticket[length];
    int index = 0;
    for (Ticket item : tickets) {
      if (item.getId() != id) {
        tmp[index] = item;
        index++;
      }
    }
    tickets = tmp;
    return tickets;
  }
}
