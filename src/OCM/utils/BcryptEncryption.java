package OCM.utils;

import org.mindrot.jbcrypt.*;

public final class BcryptEncryption implements IEncrypted {

	@Override
	public String encrypt(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt(12));
	}

	@Override
	public Boolean compare(String hashed, String candidate) {
		return BCrypt.checkpw(hashed, candidate);
	}
}
