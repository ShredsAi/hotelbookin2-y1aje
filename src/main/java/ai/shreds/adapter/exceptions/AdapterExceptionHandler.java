package ai.shreds.adapter.exceptions; 
  
 import org.springframework.web.bind.annotation.ControllerAdvice; 
 import org.springframework.web.bind.annotation.ExceptionHandler; 
 import org.slf4j.Logger; 
 import org.slf4j.LoggerFactory; 
  
 @ControllerAdvice 
 public class AdapterExceptionHandler { 
  
     private static final Logger logger = LoggerFactory.getLogger(AdapterExceptionHandler.class); 
  
     @ExceptionHandler(Exception.class) 
     public void handleException(Exception exception) { 
         // Log the exception details 
         logger.error("An exception occurred: {}", exception.getMessage(), exception); 
         // Additional handling can be added here if necessary 
         // Since the method returns void, we rely on default exception handling for the response 
     } 
 } 
 