package utils;

import java.util.Random;

public class TestUtils {
    
    public static String generateRandomEmail() {
        return "test" + System.currentTimeMillis() + "@example.com";
    }
    
    public static String generateRandomPassword() {
        return "Test@" + new Random().nextInt(9999);
    }
    
    public static String generateRandomName() {
        String[] names = {"John", "Jane", "Mike", "Sarah", "David", "Emma"};
        return names[new Random().nextInt(names.length)] + new Random().nextInt(999);
    }
}