package ai.shreds.domain.exceptions; 
  
 /** 
  * Exception thrown when an attempt is made to check in a guest to a room that is unavailable. 
  * This could occur if the room is already occupied, out of service, or not available due to maintenance. 
  */ 
 public class DomainExceptionRoomUnavailable extends DomainException { 
  
     /** 
      * Constructs a new DomainExceptionRoomUnavailable with the specified detail message. 
      * 
      * @param message Detailed message explaining the reason for the exception. 
      */ 
     public DomainExceptionRoomUnavailable(String message) { 
         super(message); 
     } 
 } 
 