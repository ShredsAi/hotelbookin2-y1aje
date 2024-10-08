package ai.shreds.domain.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ai.shreds.shared.SharedEnumRoomStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomainEntityRoom {
    private UUID roomId;
    private String roomNumber;
    private String type;
    private List<String> amenities = new ArrayList<>();
    private SharedEnumRoomStatus status;
    private BigDecimal price;
}