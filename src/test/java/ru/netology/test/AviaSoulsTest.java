package ru.netology.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.*;

import java.util.Comparator;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("MSC", "SPB", 3500, 1630, 1750);
    Ticket ticket2 = new Ticket("MSC", "SPB", 2700, 630, 800);
    Ticket ticket3 = new Ticket("MSC", "SPB", 2000, 200, 350);
    Ticket ticket4 = new Ticket("SMR", "ORN", 1800, 1500, 1620);
    Ticket ticket5 = new Ticket("SMR", "ORN", 2000, 1100, 1230);
    Ticket ticket6 = new Ticket("SPB", "KLG", 1200, 1500, 1600);
    Ticket ticket7 = new Ticket("NVSB", "VDVS", 1800, 1520, 1620);


    @Test
    void shouldSearch() {
        AviaSouls service = new AviaSouls();
        service.add(ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7);

        Ticket[] expected = {ticket3, ticket2, ticket1};
        Ticket[] actual = service.search("MSC", "SPB");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearch2() {
        AviaSouls service = new AviaSouls();
        service.add(ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7);

        Ticket[] expected = {ticket7};
        Ticket[] actual = service.search("NVSB", "VDVS");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearch3() {
        AviaSouls service = new AviaSouls();
        service.add(ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7);

        Ticket[] expected = {};
        Ticket[] actual = service.search("MSC", "VDVS");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchAndSort() {
        AviaSouls service = new AviaSouls();
        service.add(ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7);

        Ticket[] expected = {ticket1, ticket3, ticket2};

        Comparator<Ticket> flightTimeComparator = new TicketTimeComparator();

        Ticket[] actual = service.searchAndSort("MSC", "SPB", flightTimeComparator);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchAndSort2() {
        AviaSouls service = new AviaSouls();
        service.add(ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7);

        Ticket[] expected = {ticket7};

        Comparator<Ticket> flightTimeComparator = new TicketTimeComparator();

        Ticket[] actual = service.searchAndSort("NVSB", "VDVS", flightTimeComparator);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchAndSort3() {
        AviaSouls service = new AviaSouls();
        service.add(ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7);

        Ticket[] expected = {};

        Comparator<Ticket> flightTimeComparator = new TicketTimeComparator();

        Ticket[] actual = service.searchAndSort("NVSB", "MSC", flightTimeComparator);
        Assertions.assertArrayEquals(expected, actual);

    }
}
