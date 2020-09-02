package ptplatformnys;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Pttrainer_table")
public class Pttrainer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long ptOrderId;
    private Long ptManagerId;
    private String status;
    private String ptResult;
    private String ptClassDate;

    @PostUpdate
    public void onPostUpdate(){
        PtScheduleConfirmed ptScheduleConfirmed = new PtScheduleConfirmed();
        BeanUtils.copyProperties(this, ptScheduleConfirmed);
        ptScheduleConfirmed.publishAfterCommit();


        PtResultCreated ptResultCreated = new PtResultCreated();
        BeanUtils.copyProperties(this, ptResultCreated);
        ptResultCreated.publishAfterCommit();


        PtScheduleCanceled ptScheduleCanceled = new PtScheduleCanceled();
        BeanUtils.copyProperties(this, ptScheduleCanceled);
        ptScheduleCanceled.publishAfterCommit();


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
    public Long getPtManagerId() {
        return ptManagerId;
    }

    public void setPtManagerId(Long ptManagerId) {
        this.ptManagerId = ptManagerId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getPtResult() {
        return ptResult;
    }

    public void setPtResult(String ptResult) {
        this.ptResult = ptResult;
    }
    public String getPtClassDate() {
        return ptClassDate;
    }

    public void setPtClassDate(String ptClassDate) {
        this.ptClassDate = ptClassDate;
    }




}
