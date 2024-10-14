package main;

public class BasicUtils {
    public static String reversed(String str) {
        if(str == null)
            return null;
        return new StringBuilder(str).reverse().toString();
    }

    public static int vowelCount(String str) {
        if(str == null)
            return 0;
        long count = str.toLowerCase().chars()
                .mapToObj(i -> (char) i)
                .filter(BasicUtils::isVowel)
                .count();

        return (int) count;
    }

    public static boolean isVowel(char c) {
        return "aeiuo".contains(String.valueOf(c));
    }
}
