package ai.shreds.application.ports; 
  
 import java.util.UUID; 
  
 import ai.shreds.shared.SharedReservationDTO; 
 import ai.shreds.shared.SharedEnumReservationStatus; 
  
 /** 
  * The ApplicationReservationServicePort interface defines the contract for reservation-related operations 
  * in the application layer. It abstracts the interaction with the Reservation Service, providing methods 
  * to validate reservations and update reservation statuses. 
  */ 
 public interface ApplicationReservationServicePort { 
  
     /** 
      * Validates that a reservation exists and is eligible for check-in. 
      * This method checks that: 
      * - The reservation exists. 
      * - The reservation status is 'BOOKED'. 
      * - The current date and time is not before the scheduled check-in date and time. 
      * 
      * @param reservationId the unique identifier of the reservation 
      * @return a SharedReservationDTO containing the reservation details if valid 
      */ 
     SharedReservationDTO validateReservation(UUID reservationId); 
  
     /** 
      * Updates the status of a reservation. 
      * This method is used to update the reservation status, e.g., to 'CHECKED_IN' after a successful check-in. 
      * 
      * @param reservationId the unique identifier of the reservation 
      * @param status the new status of the reservation 
      */ 
     void updateReservationStatus(UUID reservationId, SharedEnumReservationStatus status); 
 } 
 