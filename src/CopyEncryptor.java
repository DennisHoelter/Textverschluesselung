
public class CopyEncryptor implements EncryptionStrategy {

	@Override
	public String encrypt(String text) {
		return text;
	}

	@Override
	public String decrypt(String encrypted) {
		return encrypted;
	}

}
