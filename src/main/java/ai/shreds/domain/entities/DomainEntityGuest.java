package ai.shreds.domain.entities;

import java.util.Map;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomainEntityGuest {
    private UUID guestId;
    private String name;
    private Map<String, String> contactInformation;
    private Map<String, String> preferences;
}