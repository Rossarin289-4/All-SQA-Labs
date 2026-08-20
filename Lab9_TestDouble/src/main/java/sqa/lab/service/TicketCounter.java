package sqa.lab.service;

public class TicketCounter {

    private Integer noCheckinCustomer = 0;

    public void changeTicketStatus(boolean isValidTicket) {
        if (isValidTicket) {
            noCheckinCustomer++;
        }
    }

    public int getNoCheckinCustomer() {
        return noCheckinCustomer;
    }

    public void resetNoCheckinCustomer() {
        noCheckinCustomer = 0;
    }
}