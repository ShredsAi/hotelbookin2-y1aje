package ai.shreds.shared;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SharedCheckInResponseDTO {
    private String message;
    private SharedRoomDTO roomDetails;
    private Timestamp checkInTime;
}