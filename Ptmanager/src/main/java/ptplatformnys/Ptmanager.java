package ptplatformnys;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Ptmanager_table")
public class Ptmanager {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long ptOrderId;
    private Long ptTrainerId;
    private String status;
    private Long trainerId;
    private String trainerName;

    @PostPersist
    public void onPostPersist(){
        PtOrderAccepted ptOrderAccepted = new PtOrderAccepted();
        BeanUtils.copyProperties(this, ptOrderAccepted);
        ptOrderAccepted.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        PtOrderConfirmed ptOrderConfirmed = new PtOrderConfirmed();
        BeanUtils.copyProperties(this, ptOrderConfirmed);
        ptOrderConfirmed.publishAfterCommit();


        PtOrderCancelAccepted ptOrderCancelAccepted = new PtOrderCancelAccepted();
        BeanUtils.copyProperties(this, ptOrderCancelAccepted);
        ptOrderCancelAccepted.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        ptplatformnys.external.Pttrainer pttrainer = new ptplatformnys.external.Pttrainer();
        // mappings goes here
        PtmanagerApplication.applicationContext.getBean(ptplatformnys.external.PttrainerService.class)
            .ptScheduleCancellation(pttrainer);


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getPtOrderId() {
        return ptOrderId;
    }

    public void setPtOrderId(Long ptOrderId) {
        this.ptOrderId = ptOrderId;
    }
    public Long getPtTrainerId() {
        return ptTrainerId;
    }

    public void setPtTrainerId(Long ptTrainerId) {
        this.ptTrainerId = ptTrainerId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }
    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }




}
