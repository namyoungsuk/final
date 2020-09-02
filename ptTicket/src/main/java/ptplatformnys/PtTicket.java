package ptplatformnys;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="PtTicket_table")
public class PtTicket {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long customerId;
    private Long ticketId;
    private Long ticketCount;

    @PrePersist
    public void onPrePersist(){
        PtTicketCreated ptTicketCreated = new PtTicketCreated();
        BeanUtils.copyProperties(this, ptTicketCreated);
        ptTicketCreated.publishAfterCommit();


        PtTicketCanceled ptTicketCanceled = new PtTicketCanceled();
        BeanUtils.copyProperties(this, ptTicketCanceled);
        ptTicketCanceled.publishAfterCommit();


        PtTicketUsed ptTicketUsed = new PtTicketUsed();
        BeanUtils.copyProperties(this, ptTicketUsed);
        ptTicketUsed.publishAfterCommit();


    }


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
