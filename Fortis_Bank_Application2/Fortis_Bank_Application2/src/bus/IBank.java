package bus;

public interface IBank {
	
	public abstract void closeAccount(Account acc);
	public abstract void openAccount(Account acc);
	
	
	public abstract int reset();
	public abstract long getAccountNumber();
	
	
}
