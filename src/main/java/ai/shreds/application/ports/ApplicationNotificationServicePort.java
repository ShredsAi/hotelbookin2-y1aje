package ai.shreds.application.ports;

import ai.shreds.shared.SharedNotificationRequestDTO;

/**
 * Interface defining the contract for sending notifications within the application.
 */
public interface ApplicationNotificationServicePort {
    /**
     * Sends a notification based on the provided request details.
     *
     * @param request the notification request containing recipient details, message, and check-in information
     */
    void sendNotification(SharedNotificationRequestDTO request);
}