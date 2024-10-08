package ai.shreds.adapter.primary; 
  
 import ai.shreds.application.ports.ApplicationCheckInServicePort; 
 import ai.shreds.shared.SharedCheckInRequestDTO; 
 import ai.shreds.shared.SharedCheckInResponseDTO; 
 import org.springframework.beans.factory.annotation.Autowired; 
 import org.springframework.web.bind.annotation.PostMapping; 
 import org.springframework.web.bind.annotation.RequestBody; 
 import org.springframework.web.bind.annotation.RestController; 
  
 @RestController 
 public class AdapterGuestCheckInController { 
  
     private final ApplicationCheckInServicePort applicationCheckInService; 
  
     @Autowired 
     public AdapterGuestCheckInController(ApplicationCheckInServicePort applicationCheckInService) { 
         this.applicationCheckInService = applicationCheckInService; 
     } 
  
     @PostMapping("/api/checkin") 
     public SharedCheckInResponseDTO checkIn(@RequestBody SharedCheckInRequestDTO request) { 
         return applicationCheckInService.checkIn(request); 
     } 
 } 
 