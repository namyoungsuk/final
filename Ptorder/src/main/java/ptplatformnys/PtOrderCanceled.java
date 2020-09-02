package ptplatformnys;

public class PtOrderCanceled extends AbstractEvent {

    private Long id;
    private Long ptManagerId;
    private Long ptTrainerId;
    private String status;
    private Long ptClassId;
    private String ptClassName;
    private Long customerId;
    private String customerName;

    public PtOrderCanceled(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getPtManagerId() {
        return ptManagerId;
    }

    public void setPtManagerId(Long ptManagerId) {
        this.ptManagerId = ptManagerId;
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
    public Long getPtClassId() {
        return ptClassId;
    }

    public void setPtClassId(Long ptClassId) {
        this.ptClassId = ptClassId;
    }
    public String getPtClassName() {
        return ptClassName;
    }

    public void setPtClassName(String ptClassName) {
        this.ptClassName = ptClassName;
    }
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
