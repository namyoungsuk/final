package ptplatformnys;

public class Payed extends AbstractEvent {

    private Long id;

    public Payed(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
