package eticaret.dataAccess.concretes;

import java.util.List;

import eticaret.dataAccess.abstracts.UserDao;
import eticaret.entities.concretes.User;

public class HibernateUserDao implements UserDao{
	

	@Override
	public void add(User user) {
		System.out.println("Hibernate ile database'e eklendi  " + user.getName());
		
	}

	@Override
	public void delete(User user) {
		System.out.println(user.getName() + user.getLastName() + " deleted");
		
	}

	@Override
	public void update(User user) {
		System.out.println(user.getName() + user.getLastName() + " updated");
		
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
