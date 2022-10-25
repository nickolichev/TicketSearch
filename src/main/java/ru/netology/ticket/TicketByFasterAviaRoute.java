package ru.netology.ticket;

import java.util.Comparator;

public class TicketByFasterAviaRoute implements Comparator<Ticket> {

  @Override
  public int compare(Ticket o1, Ticket o2) {
    return Integer.compare(o1.getFlightDuration(), o2.getFlightDuration());
  }
}