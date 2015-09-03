package com.leanthoughts.loop.auth.defaults;

import com.tracebucket.idem.domain.Authority;
import com.tracebucket.idem.init.builder.AuthorityBuilder;

import java.util.HashSet;

/**
 * @author ssm
 * @since 13-03-15
 */
public class AuthoritiesDefault {
    public static Authority idemAdministrator() {
        HashSet scopes = new HashSet();
        scopes.add("idem-read");
        scopes.add("idem-write");
        Authority authority = AuthorityBuilder.anAuthorityBuilder()
                .withRole("IDEM_ADMINISTRATOR")
                .withScopes(scopes)
                .build();
        return authority;
    }

    public static Authority tenantAdministrator() {
        HashSet scopes = new HashSet();
        scopes.add("idem-read");
        scopes.add("idem-write");
        scopes.add("organization-read");
        scopes.add("organization-write");
        scopes.add("partner-read");
        scopes.add("partner-write");
        Authority authority = AuthorityBuilder.anAuthorityBuilder()
                .withRole("TENANT_ADMINISTRATOR")
                .withScopes(scopes)
                .build();
        return authority;
    }

    public static Authority tenantManager() {
        HashSet scopes = new HashSet();
        scopes.add("idem-read");
        scopes.add("idem-write");
        scopes.add("organization-read");
        scopes.add("partner-read");
        scopes.add("partner-write");
        Authority authority = AuthorityBuilder.anAuthorityBuilder()
                .withRole("TENANT_MANAGER")
                .withScopes(scopes)
                .build();
        return authority;
    }

    public static Authority customerServiceAgent() {
        HashSet scopes = new HashSet();
        scopes.add("idem-read");
        scopes.add("idem-write");
        scopes.add("partner-read");
        scopes.add("partner-write");
        Authority authority = AuthorityBuilder.anAuthorityBuilder()
                .withRole("CUSTOMER_SERVICE_AGENT")
                .withScopes(scopes)
                .build();
        return authority;
    }
}