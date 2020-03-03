package com.capg.flightmanagement.login;


public interface IAuthenticationDao<ID,P> {
	boolean login(ID id,P password);
	void logout(ID id);
}
