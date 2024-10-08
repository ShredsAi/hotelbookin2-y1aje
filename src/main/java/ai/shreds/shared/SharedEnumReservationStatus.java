package ai.shreds.shared; 
  
 /** 
  * Enum representing the possible statuses of a reservation. 
  */ 
 public enum SharedEnumReservationStatus { 
  
     /** 
      * The reservation has been made but the guest has not yet checked in. 
      */ 
     BOOKED, 
  
     /** 
      * The guest has checked in. 
      */ 
     CHECKED_IN, 
  
     /** 
      * The reservation has been cancelled. 
      */ 
     CANCELLED 
 }