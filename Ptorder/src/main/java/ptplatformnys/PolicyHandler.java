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
    public void wheneverPtOrderConfirmed_PtOrderCompletionNotify(@Payload PtOrderConfirmed ptOrderConfirmed){

        if(ptOrderConfirmed.isMe()){
            System.out.println("##### listener PtOrderCompletionNotify : " + ptOrderConfirmed.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPtResultCreated_PtResultCreationNotify(@Payload PtResultCreated ptResultCreated){

        if(ptResultCreated.isMe()){
            System.out.println("##### listener PtResultCreationNotify : " + ptResultCreated.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPtOrderCancelAccepted_PtOrderCancelAccept(@Payload PtOrderCancelAccepted ptOrderCancelAccepted){

        if(ptOrderCancelAccepted.isMe()){
            System.out.println("##### listener PtOrderCancelAccept : " + ptOrderCancelAccepted.toJson());
        }
    }

}
