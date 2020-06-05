package com.finalproject.coalquilando.entities.users;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Owner {

    private final Long ownerId;
    private final String ownerName;
    private final String ownerSurname;
    private final List<Preference> preferences; // The list of preferences will be null when the owner isn't a tenant.
}
