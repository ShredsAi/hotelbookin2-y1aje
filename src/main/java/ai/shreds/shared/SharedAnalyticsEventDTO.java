package ai.shreds.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SharedAnalyticsEventDTO {
    private String eventType;
    private Instant timestamp;
    private UUID reservationId;
    private UUID guestId;
    private UUID roomId;
    private UUID staffId;
}