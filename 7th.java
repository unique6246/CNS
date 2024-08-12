import java.math.BigInteger;
import java.util.Scanner;

class p7 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter m:");
        BigInteger msg = sc.nextBigInteger();

        System.out.println("Enter p:");
        BigInteger p = sc.nextBigInteger();

        System.out.println("Enter q:");
        BigInteger q = sc.nextBigInteger();

        BigInteger n = p.multiply(q);
        BigInteger z = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        System.out.println("The value of z = " + z);

        BigInteger e = BigInteger.TWO;
        while (e.compareTo(z) < 0) {
            if (gcd(e, z).equals(BigInteger.ONE)) {
                break;
            }
            e = e.add(BigInteger.ONE);
        }
        System.out.println("The value of e = " + e);

        BigInteger d = e.modInverse(z);
        System.out.println("The value of d = " + d);

        BigInteger c = msg.modPow(e, n);
        System.out.println("Encrypted message is : " + c);

        BigInteger msgback = c.modPow(d, n);
        System.out.println("Decrypted message is : " + msgback);
    }

    static BigInteger gcd(BigInteger a, BigInteger b) {
        if (a.equals(BigInteger.ZERO))
            return b;
        else
            return gcd(b.mod(a), a);
    }
}
