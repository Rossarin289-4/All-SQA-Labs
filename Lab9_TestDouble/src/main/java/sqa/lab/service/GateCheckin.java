package sqa.lab.service;

import java.util.HashSet;
import java.util.Set;

public class GateCheckin {

    private Set<Integer> checkinCustomer;
    private TicketCounter ticketCounter;

    public GateCheckin(TicketCounter ticketCounter) {
        this.checkinCustomer = new HashSet<Integer>();
        this.ticketCounter = ticketCounter;
    }

    public void customerEntry(int ticketId) {
        if (customerIsEligible(ticketId)) {
            checkinCustomer.add(ticketId);
            ticketCounter.changeTicketStatus(true);
        }
    }

    public Set<Integer> getPassengersOnBoard() {
        return checkinCustomer;
    }

    public boolean customerIsEligible(int ticketId) {
        return !checkinCustomer.contains(ticketId);
    }
}