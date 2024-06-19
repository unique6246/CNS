import java.util.*;

class ccipher {
    static String encrypt(String s, int key) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i), add = '.';
            if (Character.isUpperCase(c))
                add = (char) ('A' + (c - 'A' + key) % 26);
            else if (Character.isLowerCase(c))
                add = (char) ('a' + (c - 'a' + key) % 26);
            else
                add = c;
            ans += add;
        }
        return ans;
    }

    static String decrypt(String s, int key) {
        return encrypt(s, 26 - key);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to encrypt: ");
        String plainText = sc.nextLine();
        System.out.print("Enter shift value: ");
        int shift = sc.nextInt();
        System.out.println("Original text is " + plainText);
        String encrypted = encrypt(plainText, shift);
        System.out.println("Encrypted Text is " + encrypted);
        System.out.println("Decrypted Text is " + decrypt(encrypted, shift));
        sc.close();
    }
}
