package com.capg.flightmanagement.login;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AuthenticationDaoImpl<ID, P>
        implements IAuthenticationDao<ID, P>, ICredentialStore<ID, P> {
	
    private Set<ID> loginStore = new HashSet<>();

    @Override
    public boolean login(ID idArg, P passwordArg) {
        Map<ID, P> store = this.store();
        P password = store.get(idArg);
        if (!passwordArg.equals(password)) {
            return false;
        }
        loginStore.add(idArg);
        return true;
    }

    @Override
    public void logout(ID id) {
        loginStore.remove(id);
    }


}
