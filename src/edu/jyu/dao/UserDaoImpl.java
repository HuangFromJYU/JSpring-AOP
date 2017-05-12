package edu.jyu.dao;

public class UserDaoImpl implements UserDao{

	@Override
	public void add(String user) {
		System.out.println("add "+user);
	}
}
