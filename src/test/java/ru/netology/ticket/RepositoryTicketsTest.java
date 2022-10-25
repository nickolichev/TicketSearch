package ru.netology.ticket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RepositoryTicketsTest {
  RepositoryTickets repository = new RepositoryTickets();

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
  void save() {
    repository.save(Aeroflot);
    repository.save(BritishAirways);
    repository.save(WizzAir);
    repository.save(Lufthansa);
    repository.save(Iberia);
    repository.save(KLM);
    repository.save(Finnair);
    repository.save(JetBlue);
    repository.save(Emirates);
    repository.save(LOT);
  }

  // найти по аэропорту вылета
  // + c сортировкой по возрастанию цены
  @Test
  void findByAirportsDeparture() {
    Ticket[] actual = repository.searchByAirportsDeparture("LHR");
    Ticket[] expected = {WizzAir, JetBlue, Finnair, Iberia, Emirates, BritishAirways, Aeroflot};
    Arrays.sort(actual);
    assertArrayEquals(expected, actual);
  }

  // найти по аэропорту прилета
  // + c сортировкой по возрастанию цены
  @Test
  void findByAirportsArrival() {
    Ticket[] actual = repository.searchByAirportsArrival("SFO");
    Ticket[] expected = {WizzAir, JetBlue, Emirates, BritishAirways, Lufthansa, Aeroflot};
    Arrays.sort(actual);
    assertArrayEquals(expected, actual);
  }

  // удалить по id билета
  @Test
  void removeTicketById() {
    Ticket[] actual = repository.removeById(467);
    Ticket[] expected = {Aeroflot, BritishAirways, WizzAir, Lufthansa, Iberia, KLM, JetBlue, Emirates, LOT};
    assertArrayEquals(expected, actual);
  }
}