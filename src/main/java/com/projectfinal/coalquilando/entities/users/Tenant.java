package com.projectfinal.coalquilando.entities.users;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Tenant {

    private Long tenantId;
    private String ownerName;
    private String ownerSurname;
    private List<Preference> preferences;
}
