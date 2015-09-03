package com.leanthoughts.loop.auth.defaults;

import com.tracebucket.idem.domain.Tenant;
import com.tracebucket.idem.init.builder.TenantBuilder;

/**
 * Created by Vishwajit on 03-08-2015.
 */
public class TenantDefault {
    public static final String DEFAULT_ORGANIZATION_UID = "02728694-ee2d-4112-b103-c8ffa906b6e5";
    public static Tenant standardTenant() {
        Tenant tenant = TenantBuilder.aTenantBuilder()
                .withDescription("Acme Corporation")
                .withLogo("Acme")
                .withUrl("www.acme.ex")
                .withName(DEFAULT_ORGANIZATION_UID)
                .build();
        return tenant;
    }
}
