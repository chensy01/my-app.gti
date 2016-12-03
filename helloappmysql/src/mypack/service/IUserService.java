package mypack.service;

import mypack.Entity.Users;

public interface IUserService {
	Users save(String username, String password);
	
	boolean login(String username, String password);
	
	Users get(String username);
	
	boolean isExists(String username);
	
}
