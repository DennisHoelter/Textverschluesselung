
public class Encryptor {
	private EncryptionStrategy encryptionStrategy;
	
	public void setEncryptionStrategy(EncryptionStrategy strategy){
		encryptionStrategy = strategy;
	}
	public String encrypt(String original) {
		return encryptionStrategy.encrypt(original);
	}
	
	public String decrypt(String encrypted){
		return encryptionStrategy.decrypt(encrypted);
	}
	
}
