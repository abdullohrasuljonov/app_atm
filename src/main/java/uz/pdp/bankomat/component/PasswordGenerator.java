package uz.pdp.bankomat.component;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class PasswordGenerator {
    public String genRandomPassword(int len) {
        final String chars = "0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(chars.length());//
            stringBuilder.append(chars.charAt(randomIndex));
        }

        return stringBuilder.toString();
    }

}