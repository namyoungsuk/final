package ptplatformnys;

public class PtTicketUsed extends AbstractEvent {

    private Long id;

    public PtTicketUsed(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
