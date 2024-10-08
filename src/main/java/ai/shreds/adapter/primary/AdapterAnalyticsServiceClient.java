package ai.shreds.adapter.primary;

import ai.shreds.shared.dto.SharedAnalyticsEventDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class AdapterAnalyticsServiceClient implements ApplicationAnalyticsServicePort {

    private static final String EXCHANGE_NAME = "analytics.exchange";
    private static final String ROUTING_KEY = "analytics.checkin";
    private static final Logger logger = LoggerFactory.getLogger(AdapterAnalyticsServiceClient.class);

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public AdapterAnalyticsServiceClient(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void publishEvent(SharedAnalyticsEventDTO event) {
        try {
            rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, event);
        } catch (Exception e) {
            logger.error("Failed to publish analytics event", e);
            throw new RuntimeException("Failed to publish analytics event", e);
        }
    }
}