package com.leanthoughts.loop.auth.config;

import com.leanthoughts.loop.auth.defaults.AuthoritiesDefault;
import com.leanthoughts.loop.auth.defaults.ClientDefault;
import com.leanthoughts.loop.auth.defaults.TenantDefault;
import com.leanthoughts.loop.auth.defaults.UsersDefault;
import com.tracebucket.idem.domain.Authority;
import com.tracebucket.idem.domain.Client;
import com.tracebucket.idem.domain.Tenant;
import com.tracebucket.idem.domain.User;
import com.tracebucket.idem.repository.jpa.AuthorityRepository;
import com.tracebucket.idem.repository.jpa.ClientRepository;
import com.tracebucket.idem.repository.jpa.TenantRepository;
import com.tracebucket.idem.repository.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sadath on 11-Jun-2015.
 */
@Configuration
public class InitialConfiguration implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TenantRepository tenantRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Tenant tenant = tenantRepository.findByName(TenantDefault.DEFAULT_ORGANIZATION_UID);
        if(tenant == null) {
            tenant = tenantRepository.save(TenantDefault.standardTenant());
        }
        //Authority idemAdministrator = authorityRepository.findByRole("IDEM_ADMINISTRATOR");
        Authority tenantAdministrator = authorityRepository.findByRole("TENANT_ADMINISTRATOR");
        List<Authority> authorities = new ArrayList<Authority>();
        /*if(idemAdministrator == null) {
            authorities.add(AuthoritiesDefault.idemAdministrator());
        }*/
        if(tenantAdministrator == null) {
            authorities.add(AuthoritiesDefault.tenantAdministrator());
        }
        if(authorities.size() > 0) {
            authorityRepository.save(authorities);
        }
        //User userAdmin = (User)userRepository.findByUsername("sequre");
        User userAdmin = (User)userRepository.findByUsername("acme");
        List<User> users = new ArrayList<User>();
/*        if(userAdmin == null) {
            Set<Authority> authoritySet = new HashSet<Authority>();
            authoritySet.add(authorityRepository.findByRole("IDEM_ADMINISTRATOR"));
            users.add(UsersDefault.defaultIdemAdministrator(authoritySet));
        }*/
        if(userAdmin == null) {
            Set<Authority> authoritySet = new HashSet<Authority>();
            authoritySet.add(authorityRepository.findByRole("TENANT_ADMINISTRATOR"));
            Set<Tenant> tenants = new HashSet<Tenant>();
            tenants.add(tenant);
            users.add(UsersDefault.defaultTenantAdministrator(tenants, authoritySet));
        }
        if(users.size() > 0) {
            userRepository.save(users);
        }
        Client client = clientRepository.findByClientId("loop-gateway");
        if(client == null) {
            clientRepository.save(ClientDefault.defaultClient(tenant, authorities));
        }
        /**
         *  [1]     Authority: Idem Administrator//Removed
         *  [2]     Authority: Tenant Administrator
         *  [3]     Authority: Tenant Manager
         *  [4]     Authority: Customer Service Agent
         *  [5]     User: sequre/sequre     --> Idem Administrator//Removed
         *  [6]     User: client/client     --> Tenant Administrator
         *  [7]     User: manager/manager   --> Tenant Manager
         *  [8]     User: agent/agent       --> Customer Service Agent
         *  [9]     Client: sequre-admin/sequre-admin-secret
         *  [10]    Scope: idem-read
         *  [11]    Scope: idem-write
         *  [12]    Scope: organization-read
         *  [13]    Scope: organization-write
         *  [14]    Scope: partner-read
         *  [15]    Scope: partner-write
         *  [16]    Scope: terminal-read
         *  [17]    Scope: terminal-write
         */
    }
}