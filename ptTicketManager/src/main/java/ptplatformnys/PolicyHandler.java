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
    public void wheneverPtTicketCreated_PtTicketCreateNoti(@Payload PtTicketCreated ptTicketCreated){

        if(ptTicketCreated.isMe()){
            System.out.println("##### listener PtTicketCreateNoti : " + ptTicketCreated.toJson());
        }
    }
    /*
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPtTicketCreated_PtTicketCreateNoti(@Payload PtTicketCreated ptTicketCreated){

        if(ptTicketCreated.isMe()){
            System.out.println("##### listener PtTicketCreateNoti : " + ptTicketCreated.toJson());
        }
    }

     */
    /*
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPtTicketCanceled_PtTicketCancelNoti(@Payload PtTicketCanceled ptTicketCanceled){

        if(ptTicketCanceled.isMe()){
            System.out.println("##### listener PtTicketCancelNoti : " + ptTicketCanceled.toJson());
        }
    }

     */

}
