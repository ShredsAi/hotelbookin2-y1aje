package ai.shreds.shared;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Enum representing the status of a room.
 */
@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum SharedEnumRoomStatus {
    AVAILABLE,
    OCCUPIED,
    OUT_OF_SERVICE
}