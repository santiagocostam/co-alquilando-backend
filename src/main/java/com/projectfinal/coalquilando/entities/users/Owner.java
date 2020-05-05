package com.projectfinal.coalquilando.entities.users;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Owner {

    private Long ownerId;
    private String ownerName;
    private String ownerSurname;
    private List<Preference> preferences; // The list of preferences will be null when the owner isn't a tenant.
}
