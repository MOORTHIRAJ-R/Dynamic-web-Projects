package service;
import dao.UserDAO;
public class UserService {

	 UserDAO dao = new UserDAO();
	public int login(String username, String password) {
		return dao.login(username, password);
	}

	public boolean register(String username, String password) {
		 return dao.register(username, password);
	}

}
