package ptplatformnys.external;

public class PtTicket {

    private Long id;
    private Long customerId;
    private Long ticketId;
    private Long ticketCount;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public Long getTicketId() {
        return ticketId;
    }
    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }
    public Long getTicketCount() {
        return ticketCount;
    }
    public void setTicketCount(Long ticketCount) {
        this.ticketCount = ticketCount;
    }

}
