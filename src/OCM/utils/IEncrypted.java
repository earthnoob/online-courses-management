package OCM.utils;

public interface IEncrypted {
	public String encrypt(String password);
	public Boolean compare(String hashed, String candidate);
}
