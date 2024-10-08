package ai.shreds.shared;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SharedNotificationRequestDTO {

    @NotNull
    private String notificationType;

    @NotNull
    private SharedGuestDTO recipient;

    @NotNull
    private String message;

    @NotNull
    private SharedCheckInRecordDTO checkInDetails;
}