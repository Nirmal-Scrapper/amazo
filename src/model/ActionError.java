package model;

public abstract class ActionError {
	String msg;
	public ActionError(String msg) {
		this.msg=msg;
	}
	public abstract String error();
}
