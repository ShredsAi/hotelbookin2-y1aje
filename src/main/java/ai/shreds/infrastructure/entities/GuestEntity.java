package ai.shreds.infrastructure.entities;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "guests")
public class GuestEntity {

    @Id
    @Column(name = "guest_id", nullable = false, unique = true)
    private UUID guestId;

    @Column(name = "name", nullable = false)
    private String name;

    @ElementCollection
    @Column(name = "contact_information")
    private Map<String, String> contactInformation;

    @ElementCollection
    @Column(name = "preferences")
    private Map<String, String> preferences;

    // Getters and Setters

    public UUID getGuestId() {
        return guestId;
    }

    public void setGuestId(UUID guestId) {
        this.guestId = guestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(Map<String, String> contactInformation) {
        this.contactInformation = contactInformation;
    }

    public Map<String, String> getPreferences() {
        return preferences;
    }

    public void setPreferences(Map<String, String> preferences) {
        this.preferences = preferences;
    }
}