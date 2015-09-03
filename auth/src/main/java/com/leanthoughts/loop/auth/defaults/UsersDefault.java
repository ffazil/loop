package com.leanthoughts.loop.auth.defaults;

import com.tracebucket.idem.domain.Authority;
import com.tracebucket.idem.domain.Tenant;
import com.tracebucket.idem.domain.User;
import com.tracebucket.idem.init.builder.UserBuilder;
import com.tracebucket.idem.init.defaults.AuthoritiesDefault;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ssm
 * @since 13-03-15
 */
public class UsersDefault {
    public static User defaultIdemAdministrator() {
        Set<Authority> authorities = new HashSet<>();
        authorities.add(AuthoritiesDefault.idemAdministrator());
        User user = UserBuilder.anUserBuilder()
                .withUsername("idem")
                .withPassword("idem")
                .withAccountNonExpired(true)
                .withAccountNonLocked(true)
                .withCredentialsNonExpired(true)
                .withEnabled(true)
                .withAuthorities(authorities)
                .build();
        return user;
    }

    public static User defaultIdemAdministrator(Set<Authority> authorities) {
        User user = UserBuilder.anUserBuilder()
                .withUsername("idem")
                .withPassword("idem")
                .withAccountNonExpired(true)
                .withAccountNonLocked(true)
                .withCredentialsNonExpired(true)
                .withEnabled(true)
                .withAuthorities(authorities)
                .build();
        return user;
    }

    public static User defaultTenantAdministrator(Set<Tenant> tenants) {
        Set<Authority> authorities = new HashSet<>();
        authorities.add(AuthoritiesDefault.tenantAdministrator());

        User user = UserBuilder.anUserBuilder()
            .withUsername("acme")
            .withPassword("acme")
            .withAccountNonExpired(true)
            .withAccountNonLocked(true)
            .withCredentialsNonExpired(true)
            .withEnabled(true)
            .withAuthorities(authorities)
            .withTenantInformation(tenants)
            .build();
        return user;
    }

    public static User defaultTenantAdministrator(Set<Tenant> tenants, Set<Authority> authorities) {
        User user = UserBuilder.anUserBuilder()
                .withUsername("acme")
                .withPassword("acme")
                .withAccountNonExpired(true)
                .withAccountNonLocked(true)
                .withCredentialsNonExpired(true)
                .withEnabled(true)
                .withAuthorities(authorities)
                .withTenantInformation(tenants)
                .build();
        return user;
    }
}