package com.leanthoughts.loop.auth.defaults;

import com.tracebucket.idem.domain.Authority;
import com.tracebucket.idem.domain.Client;
import com.tracebucket.idem.domain.Tenant;
import com.tracebucket.idem.init.builder.ClientBuilder;

import java.util.HashSet;
import java.util.List;

/**
 * Created by ffl on 10-06-2015.
 */
public class ClientDefault {
	public ClientDefault() {
	}

	public static Client defaultClient() {
		HashSet authorizedGrantTypes = new HashSet();
		authorizedGrantTypes.add("authorization_code");
		authorizedGrantTypes.add("refresh_token");
		authorizedGrantTypes.add("password");
		HashSet scopes = new HashSet();
		scopes.add("idem-read");
		scopes.add("idem-write");
		scopes.add("organization-read");
		scopes.add("organization-write");
		scopes.add("partner-read");
		scopes.add("partner-write");
        scopes.add("terminal-read");
        scopes.add("terminal-write");
		Client client = ClientBuilder.aClientBuilder().withClientId("loop-gateway").withClientSecret("loop-gateway-secret").withScope(scopes).withAuthorizedGrantTypes(authorizedGrantTypes).build();
		return client;
	}

	public static Client defaultClient(Tenant tenant, List<Authority> authorities) {
		HashSet authorizedGrantTypes = new HashSet();
		authorizedGrantTypes.add("authorization_code");
		authorizedGrantTypes.add("refresh_token");
		authorizedGrantTypes.add("password");
		HashSet scopes = new HashSet();
		scopes.add("idem-read");
		scopes.add("idem-write");
		scopes.add("organization-read");
		scopes.add("organization-write");
		scopes.add("partner-read");
		scopes.add("partner-write");
        scopes.add("terminal-read");
        scopes.add("terminal-write");
		Client client = ClientBuilder.aClientBuilder()
                .withClientId("loop-gateway")
                .withClientSecret("loop-gateway-secret")
                .withScope(scopes)
                .withTenant(tenant)
                .withAuthorities(authorities)
                .withAuthorizedGrantTypes(authorizedGrantTypes)
                .build();
		return client;
	}
}
