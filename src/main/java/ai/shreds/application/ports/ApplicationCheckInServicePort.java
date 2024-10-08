package ai.shreds.application.ports;

import ai.shreds.shared.SharedCheckInRequestDTO;
import ai.shreds.shared.SharedCheckInResponseDTO;

public interface ApplicationCheckInServicePort {
    SharedCheckInResponseDTO checkIn(SharedCheckInRequestDTO request);
}