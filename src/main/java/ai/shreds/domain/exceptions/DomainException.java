package ai.shreds.domain.exceptions; 
  
 public class DomainException extends RuntimeException { 
     private static final long serialVersionUID = 1L; 
  
     private String message; 
  
     public DomainException(String message) { 
         super(message); 
         this.message = message; 
     } 
  
     public String getMessage() { 
         return message; 
     } 
 } 
 