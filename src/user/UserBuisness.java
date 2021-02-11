package user;

public class UserBuisness {
	public int Login(String Name, String Password) {
		UserDAO ob = new UserDAO();
		int id = ob.Login(Name, Password);
		boolean flag = ob.Update(String.valueOf(id), "1");
		if (!flag)
			System.out.println("status update error user id" + id + " name=" + Name);
		return id;
	}

	public boolean SignUp(String Name, String Password) {
		UserDAO ob = new UserDAO();
		boolean flag = ob.Signup(Name, Password);
		if (!flag)
			System.out.println("sign up error user name=" + Name);
		return flag;
	}

	public boolean StatusUpdate(String id, String status) {
		UserDAO ob = new UserDAO();
		boolean flag = ob.Update(id, "1");
		if (!flag)
			System.out.println("status update error user id" + id);
		return flag;
	}
}
