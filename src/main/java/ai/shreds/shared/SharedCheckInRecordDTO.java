package ai.shreds.shared;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SharedCheckInRecordDTO implements Serializable {
    private UUID checkInId;
    private UUID reservationId;
    private UUID guestId;
    private UUID roomId;
    private Timestamp checkInTime;
    private UUID staffId;
}