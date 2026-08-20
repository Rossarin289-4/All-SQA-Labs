package sqa.lab.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GateCheckinTest {

    @Test
    void shouldCheckinCustomer() {

        //create Mock
        TicketCounter mockTicketCounter = Mockito.mock(TicketCounter.class);

        //creat SUT
        GateCheckin gateCheckin = new GateCheckin(mockTicketCounter);

        //scan ticket
        gateCheckin.customerEntry(101);

        //verify customer is check in
        assertTrue(gateCheckin.getPassengersOnBoard().contains(101));

        //verify TicketCounter was called
        Mockito.verify(mockTicketCounter)
                .changeTicketStatus(true);
    }
}