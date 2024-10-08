package ai.shreds.application.services;

import ai.shreds.application.ports.ApplicationNotificationServicePort;
import ai.shreds.shared.SharedNotificationRequestDTO;
import ai.shreds.adapter.primary.AdapterNotificationServiceClient;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ApplicationNotificationService implements ApplicationNotificationServicePort {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationNotificationService.class);

    private final AdapterNotificationServiceClient notificationServiceClient;

    @Autowired
    public ApplicationNotificationService(AdapterNotificationServiceClient notificationServiceClient) {
        this.notificationServiceClient = notificationServiceClient;
    }

    @Override
    public void sendNotification(SharedNotificationRequestDTO request) {
        try {
            notificationServiceClient.sendNotification(request);
        } catch (Exception e) {
            logger.error("Failed to send notification: {}", e.getMessage(), e);
            // Optionally implement retry logic or additional error handling here
            throw e;
        }
    }
}