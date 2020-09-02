package ptplatformnys;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="PtTicketManager_table")
public class PtTicketManager {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @PostRemove
    public void onPostRemove(){
        CustomerEntered customerEntered = new CustomerEntered();
        BeanUtils.copyProperties(this, customerEntered);
        customerEntered.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        ptplatformnys.external.PtTicket ptTicket = new ptplatformnys.external.PtTicket();
        // mappings goes here
        PtTicketManagerApplication.applicationContext.getBean(ptplatformnys.external.PtTicketService.class)
            .ptTicketUse(ptTicket);


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




}
