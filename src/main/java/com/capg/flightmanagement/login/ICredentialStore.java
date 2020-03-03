package com.capg.flightmanagement.login;

import java.util.Map;

public interface ICredentialStore<ID, P> {
    Map<ID, P> store();
}
