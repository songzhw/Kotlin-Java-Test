package ca.six.kjdemo;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

class Temp {
    public static void main(String[] args) throws Exception {
        String src = "[easy plaintext]";
        String key = "0123456789abcdef";
        byte[] raw = key.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(src.getBytes("utf-8"));

        String result1 = Base64.getEncoder().encodeToString(encrypted);
        System.out.println(result1);

        String result2 = bytesToHex(encrypted);
        System.out.println(result2);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xff);
            if (hex.length() < 2) sb.append(0);
            sb.append(hex);
        }
        return sb.toString();
    }
}
