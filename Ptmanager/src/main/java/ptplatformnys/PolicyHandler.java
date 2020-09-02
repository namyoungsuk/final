package ptplatformnys;

import ptplatformnys.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPtOrdered_PtOrderRequest(@Payload PtOrdered ptOrdered){

        if(ptOrdered.isMe()){
            System.out.println("##### listener PtOrderRequest : " + ptOrdered.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPtScheduleConfirmed_PtScheduleConfirmationNotify(@Payload PtScheduleConfirmed ptScheduleConfirmed){

        if(ptScheduleConfirmed.isMe()){
            System.out.println("##### listener PtScheduleConfirmationNotify : " + ptScheduleConfirmed.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPtCancelOrdered_PtCancelOrderRequest(@Payload PtCancelOrdered ptCancelOrdered){

        if(ptCancelOrdered.isMe()){
            System.out.println("##### listener PtCancelOrderRequest : " + ptCancelOrdered.toJson());
        }
    }

}
