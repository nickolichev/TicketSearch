package ru.netology.ticket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerTicketsTest {

  RepositoryTickets repository = new RepositoryTickets();
  ManagerTickets manager = new ManagerTickets(repository);

  Ticket Aeroflot = new Ticket(101, 35689, "LHR", "SFO", 700);
  Ticket BritishAirways = new Ticket(321, 14587, "LHR", "SFO", 675);
  Ticket WizzAir = new Ticket(213, 7903, "LHR", "SFO", 610);
  Ticket Lufthansa = new Ticket(404, 25890, "BER", "SFO", 660);
  Ticket Iberia = new Ticket(787, 11254, "LHR", "CDG", 65);
  Ticket KLM = new Ticket(910, 19800, "RTM", "LHR", 580);
  Ticket Finnair = new Ticket(467, 10328, "LHR", "ATH", 240);
  Ticket JetBlue = new Ticket(167, 9303, "LHR", "SFO", 545);
  Ticket Emirates = new Ticket(444, 12000, "LHR", "SFO", 625);
  Ticket LOT = new Ticket(521, 19800, "RTM", "LHR", 570);

  @BeforeEach
  void add() {
    manager.addTicket(Aeroflot);
    manager.addTicket(BritishAirways);
    manager.addTicket(WizzAir);
    manager.addTicket(Lufthansa);
    manager.addTicket(Iberia);
    manager.addTicket(KLM);
    manager.addTicket(Finnair);
    manager.addTicket(JetBlue);
    manager.addTicket(Emirates);
    manager.addTicket(LOT);
  }

  // поиск билетов по аэропорту вылета и прилета
  // + c сортировкой по цене (возрастание)
  @Test
  void searchTicketsByAviaRouteAndPrice() {
    Ticket[] actual = manager.searchTicketsByAviaRouteWithSortedByPrice("LHR", "SFO");
    Ticket[] expected = {WizzAir, JetBlue, Emirates, BritishAirways, Aeroflot};
    Arrays.sort(actual);
    assertArrayEquals(expected, actual);
  }

  // поиск билетов по отсутствующему маршруту
  @Test
  void searchTicketsByMissingAviaRoute() {
    Ticket[] actual = manager.searchTicketsByAviaRouteWithSortedByPrice("ATH", "SFO");
    Ticket[] expected = {};
    Arrays.sort(actual);
    assertArrayEquals(expected, actual);
  }

  // поиск билетов по Id
  // + c сортировкой по цене (возрастание)
  @Test
  void searchTicketsById() {
    Ticket[] actual = manager.searchTicketsById(787, 167, 213);
    Ticket[] expected = {WizzAir, JetBlue, Iberia};
    Arrays.sort(actual);
    assertArrayEquals(expected, actual);
  }

  // поиск билетов по аэропорту вылета и прилета
  // + диапазону продолжительности перелета
  // + c сортировкой по цене (возрастание)
  @Test
  void searchFlightDurationBySelectedAviaRoute() {
    Ticket[] actual = manager.searchTicketsByFlightDurationAndSelectedAviaRoute("LHR", "SFO", 600, 650);
    Ticket[] expected = {WizzAir, Emirates};
    Arrays.sort(actual);
    assertArrayEquals(expected, actual);
  }
}

