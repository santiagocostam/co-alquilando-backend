package com.finalproject.coalquilando.entities.users;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Tenant {

    private final Long tenantId;
    private final String ownerName;
    private final String ownerSurname;
    private final List<Preference> preferences;
}
