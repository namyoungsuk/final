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
    public void wheneverPayed_PtTicketCreate(@Payload Payed payed){

        if(payed.isMe()){
            System.out.println("##### listener PtTicketCreate : " + payed.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayCanceled_PtTicketCancel(@Payload PayCanceled payCanceled){

        if(payCanceled.isMe()){
            System.out.println("##### listener PtTicketCancel : " + payCanceled.toJson());
        }
    }
    /*
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayCanceled_PtTicketCancel(@Payload PayCanceled payCanceled){

        if(payCanceled.isMe()){
            System.out.println("##### listener PtTicketCancel : " + payCanceled.toJson());
        }
    }

     */

}
