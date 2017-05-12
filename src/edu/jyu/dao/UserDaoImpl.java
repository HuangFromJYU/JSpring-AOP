package edu.jyu.dao;

public class UserDaoImpl implements UserDao {

	@Override
	public void add(String user) {
		System.out.println("add " + user);
	}

	@Override
	public String getUser(String id) {
		System.out.println("getUser " + id);
		return id + ":Jason";
	}
}