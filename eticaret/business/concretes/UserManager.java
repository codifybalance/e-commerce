package eticaret.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eticaret.business.abstracts.UserService;
import eticaret.core.GoogleService;
import eticaret.dataAccess.abstracts.UserDao;
import eticaret.entities.concretes.User;

public class UserManager implements UserService{
	private UserDao userDao;
	private GoogleService googleService;
	
	private List<String> emailArr = new ArrayList<String>();
	private List<String> passwordArr = new ArrayList<String>();

	
	public UserManager(UserDao userDao,GoogleService googleService) {
		super();
		this.userDao = userDao;
		this.googleService = googleService;
	}
	
	
	public static final Pattern ValidEmailRegex = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static boolean emailValidation(String emailStr) {
		        Matcher matcher = ValidEmailRegex.matcher(emailStr);
		        return matcher.find();
		}

	@Override
	public void register(User user) {
		if(user.getPassword().length()<6  || user.getPassword() == null) {
			System.out.println("Parola en az 6 karakter olmalýdýr.");
			return;
		}
		if(user.getName().length()<=2 || user.getLastName().length()<=2){
			System.out.println("ad ve soyad 2 karakterden az olmamalý.");
			return;
		}
		if (emailArr.contains(user.geteMail())) {
			System.out.println("Bu email daha önce kullanýldý");
			return;
		}
		if(user.getName()== null || 
					user.getLastName()== null || 
					user.geteMail()== null ||
					user.getPassword()== null) 
		{
			System.out.println("tüm alanlar zorunludur.");
			return;
		}
		if (!(emailValidation(user.geteMail()))) {
			System.out.println("Geçerli bir mail adresi girmediniz.");
			return ;
		}
		if (emailValidation(user.geteMail())) {
			emailArr.add(user.geteMail());
			passwordArr.add(user.getPassword());
			this.userDao.add(user);
			this.googleService.registerToSystem(" Kayýt iþlemi tamamlandý " + user.getName());
		
		}else {
			System.out.println("Hesap bilgilerinizeksik yada yanlýþ girilmediðiden emin olun");
		}	
	}

	@Override
	public void login(String email, String password) {
		if(emailArr.contains(email) || passwordArr.contains(password)) {
			System.out.println("Login olundu");
		} 
		else {
			System.out.println("Email veya parolanýz doðru giriniz.");
		}
		
	}
	



}
