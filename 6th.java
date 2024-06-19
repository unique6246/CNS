import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class AESExample {
    private static final String AES_ALGORITHM = "AES";
    private static final String ENCRYPTION_KEY = "ThisIsASecretKey"; // 16, 24, or 32 bytes Long

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the text to encrypt: ");
        String originalText = scanner.nextLine();
        
        try {
            // Encryption
            byte[] encryptedBytes = encrypt(originalText);
            String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
            System.out.println("Encrypted Text: " + encryptedText);

            // Decryption
            String decryptedText = decrypt(Base64.getDecoder().decode(encryptedText));
            System.out.println("Decrypted Text: " + decryptedText);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static byte[] encrypt(String input) throws Exception {
        SecretKeySpec key = new SecretKeySpec(ENCRYPTION_KEY.getBytes(), AES_ALGORITHM);
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(input.getBytes());
    }

    public static String decrypt(byte[] encryptedBytes) throws Exception {
        SecretKeySpec key = new SecretKeySpec(ENCRYPTION_KEY.getBytes(), AES_ALGORITHM);
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }
}
