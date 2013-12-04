import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;


public class EncryptionUI extends JFrame{
	private JTextArea textAreaOriginal;
	private JTextArea textAreaEncrypted;
	private Encryptor encryptor;
	Map<String, EncryptionStrategy>encryptionMap;
	private JComboBox comboBox;
	
	public EncryptionUI(){
		initializeEncryptors();
		createGui();
	}
	private void initializeEncryptors(){
		encryptor = new Encryptor();
		encryptionMap = new HashMap<String, EncryptionStrategy>();
		encryptionMap.put("Copy", new CopyEncryptor());
		encryptionMap.put("Reverse", new ReverseEncryptor());
	}
	
	private void createGui(){
		Box box = Box.createVerticalBox();
		add(box);
		textAreaOriginal = new JTextArea(5, 30);
		textAreaOriginal.setBorder(new TitledBorder("Original"));
		box.add(textAreaOriginal);
		
		textAreaEncrypted = new JTextArea(5, 30);
		textAreaEncrypted.setBorder(new TitledBorder("Encrypted"));
		box.add(textAreaEncrypted);
		
		JPanel panel = new JPanel();
		box.add(panel);
		
		JButton buttonEncrypt = new JButton("Encrypt");
		panel.add(buttonEncrypt);
		buttonEncrypt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				onEncrypt();
			}
		});
	
		JButton buttonDecrypt = new JButton("Decrypt");
		panel.add(buttonDecrypt);
		buttonDecrypt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				onDecrypt();
			}
		});

		comboBox = new JComboBox(encryptionMap.keySet().toArray());
		panel.add(comboBox);
		comboBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				onEncryptionSelected();
			}
		});
		onEncryptionSelected();
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	protected void onEncryptionSelected() {
		Object selectedStrategy = comboBox.getSelectedItem();
		EncryptionStrategy strategy = encryptionMap.get(selectedStrategy);
		encryptor.setEncryptionStrategy(strategy);
	}
	protected void onDecrypt() {
		String encrypted = textAreaEncrypted.getText();
		System.out.println(encrypted);
		String decrypted = encryptor.decrypt(encrypted);
		textAreaOriginal.setText(decrypted);
		repaint();
	}
	private void onEncrypt() {
		String decrypted = textAreaOriginal.getText();
		System.out.println(decrypted);
		String encrypted = encryptor.encrypt(decrypted);
		textAreaEncrypted.setText(encrypted);
		repaint();
	}
	public static void main(String[] arg){
		new EncryptionUI();
	}
}
