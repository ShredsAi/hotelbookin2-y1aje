package ai.shreds.application.ports;

import ai.shreds.shared.SharedAnalyticsEventDTO;

public interface ApplicationAnalyticsServicePort {

    /**
     * Publishes a check-in event to the Analytics Service for tracking and analysis.
     *
     * @param event the analytics event containing details such as event type, timestamp, reservationId, guestId, roomId, and staffId.
     */
    void publishEvent(SharedAnalyticsEventDTO event);
}