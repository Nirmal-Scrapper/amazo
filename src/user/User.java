package user;

 abstract class User {
	public abstract int Login(String Name,String Password);
	public abstract boolean Signup(String Name,String Password);
	public abstract boolean Update(String Name,String Password);

}
