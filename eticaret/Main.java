package eticaret;

import eticaret.business.abstracts.UserService;
import eticaret.business.concretes.UserManager;
import eticaret.core.GoogleManagerAdapter;
import eticaret.dataAccess.concretes.HibernateUserDao;
import eticaret.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserManager(new HibernateUserDao(),new GoogleManagerAdapter());
		
		User user0 = new User(0,"Ayça","Aydemir","a@mail.com","123456");
		userService.register(user0);
		userService.login("a@mail.com","123456");

	}

}
