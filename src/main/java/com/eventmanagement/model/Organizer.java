
package com.eventmanagement.model;

import java.util.Objects;

public class Organizer extends Person {

    private String phone;

    public Organizer() {
        super();
    }

    public Organizer(int organizerId, String organizerName,
                     String email, String phone) {
        super(organizerId, organizerName, email);
        this.phone = phone;
    }

    public int getOrganizerId() {
        return getId();
    }

    public void setOrganizerId(int organizerId) {
        setId(organizerId);
    }

    public String getOrganizerName() {
        return getName();
    }

    public void setOrganizerName(String organizerName) {
        setName(organizerName);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getRole() {
        return "Organizer";
    }

    @Override
    public String toString() {
        return super.toString() + "\nPhone: " + phone;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Organizer)) {
            return false;
        }

        Organizer other = (Organizer) obj;
        return getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
