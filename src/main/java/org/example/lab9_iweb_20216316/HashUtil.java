package org.example.lab9_iweb_20216316;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;

public class HashUtil {

    public static String generarHash(String password) {

        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] hash = md.digest(
                    password.getBytes(StandardCharsets.UTF_8)
            );

            StringBuilder resultado = new StringBuilder();

            for (byte b : hash) {

                String hexadecimal = Integer.toHexString(0xff & b);

                if (hexadecimal.length() == 1) {
                    resultado.append('0');
                }

                resultado.append(hexadecimal);
            }

            return resultado.toString();

        } catch (Exception e) {

            throw new RuntimeException(e);

        }
    }
}