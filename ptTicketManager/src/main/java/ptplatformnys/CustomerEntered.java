package ptplatformnys;

public class CustomerEntered extends AbstractEvent {

    private Long id;

    public CustomerEntered(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
