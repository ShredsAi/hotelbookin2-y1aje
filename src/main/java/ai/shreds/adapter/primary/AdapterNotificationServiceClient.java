package ai.shreds.adapter.primary; 
  
 import org.springframework.amqp.rabbit.core.RabbitTemplate; 
 import org.springframework.amqp.AmqpException; 
 import org.springframework.stereotype.Service; 
 import org.springframework.beans.factory.annotation.Autowired; 
 import ai.shreds.shared.SharedNotificationRequestDTO; 
 import ai.shreds.application.ports.ApplicationNotificationServicePort; 
  
 import lombok.extern.slf4j.Slf4j; 
  
 @Service 
 @Slf4j 
 public class AdapterNotificationServiceClient implements ApplicationNotificationServicePort { 
  
     private final RabbitTemplate rabbitTemplate; 
  
     private static final String NOTIFICATION_EXCHANGE = "notification.exchange"; 
     private static final String NOTIFICATION_ROUTING_KEY = "notification.routing.key"; 
  
     @Autowired 
     public AdapterNotificationServiceClient(RabbitTemplate rabbitTemplate) { 
         this.rabbitTemplate = rabbitTemplate; 
     } 
  
     @Override 
     public void sendNotification(SharedNotificationRequestDTO request) { 
         try { 
             rabbitTemplate.convertAndSend(NOTIFICATION_EXCHANGE, NOTIFICATION_ROUTING_KEY, request); 
             log.info("Notification message sent successfully"); 
         } catch (AmqpException ex) { 
             log.error("Failed to send notification message", ex); 
             // According to business rule, we should log the exception but not rethrow it 
         } 
     } 
 } 
 