package model;

public class RequiredActionError extends ActionError{
	String msg;
	public RequiredActionError(String msg) {
		super(msg);
		this.msg=msg;
	}
@Override
public String error() {
	// TODO Auto-generated method stub
	return this.msg;
}
}
