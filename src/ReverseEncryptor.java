
public class ReverseEncryptor implements EncryptionStrategy {

	@Override
	public String encrypt(String text) {
		return revert(text);
	}

	@Override
	public String decrypt(String encrypted) {
		return revert(encrypted);
	}
	private String revert(String string){
		StringBuffer buffer = new StringBuffer(string);  
		buffer = buffer.reverse();  
		return buffer.toString();
	}
}
