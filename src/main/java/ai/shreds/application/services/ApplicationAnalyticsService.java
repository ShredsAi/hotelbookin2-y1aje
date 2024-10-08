package ai.shreds.application.services; 
  
 import ai.shreds.application.ports.ApplicationAnalyticsServicePort; 
 import ai.shreds.shared.dto.SharedAnalyticsEventDTO; 
 import ai.shreds.adapter.primary.AdapterAnalyticsServiceClient; 
  
 import org.springframework.stereotype.Service; 
 import org.springframework.beans.factory.annotation.Autowired; 
  
 import org.slf4j.Logger; 
 import org.slf4j.LoggerFactory; 
  
 @Service 
 public class ApplicationAnalyticsService implements ApplicationAnalyticsServicePort { 
  
     private static final Logger logger = LoggerFactory.getLogger(ApplicationAnalyticsService.class); 
  
     private final AdapterAnalyticsServiceClient adapterAnalyticsServiceClient; 
  
     @Autowired 
     public ApplicationAnalyticsService(AdapterAnalyticsServiceClient adapterAnalyticsServiceClient) { 
         this.adapterAnalyticsServiceClient = adapterAnalyticsServiceClient; 
     } 
  
     @Override 
     public void publishEvent(SharedAnalyticsEventDTO event) { 
         try { 
             // Validate the event data 
             if (event == null) { 
                 throw new IllegalArgumentException("Analytics event cannot be null"); 
             } 
             adapterAnalyticsServiceClient.publishEvent(event); 
             logger.info("Published analytics event: {}", event.getEventType()); 
         } catch (Exception e) { 
             logger.error("Error publishing analytics event", e); 
             throw e; 
         } 
     } 
 } 
 