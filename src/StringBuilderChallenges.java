import java.util.Scanner;

public class StringBuilderChallenges {

    // Beginner Level Challenges

    // 1. Reverse a String
    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    // 2. Palindrome Checker
    public static boolean isPalindrome(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equals(reversed);
    }

    // 3. Concatenate Multiple Strings
    public static String concatenateStrings(String... strings) {
        StringBuilder result = new StringBuilder();
        for (String str : strings) {
            result.append(str);
        }
        return result.toString();
    }

    // 4. Removing Vowels
    public static String removeVowels(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if ("AEIOUaeiou".indexOf(c) == -1) {
                result.append(c);
            }
        }
        return result.toString();
    }

    // 5. Word Capitalizer
    public static String capitalizeWords(String sentence) {
        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word : words) {
            if (word.length() > 0) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1)).append(" ");
            }
        }
        return result.toString().trim();
    }

    // Medium Level Challenges

    // 1. String Replacement
    public static String replaceSubstring(String input, String target, String replacement) {
        return new StringBuilder(input).toString().replace(target, replacement);
    }

    // 2. Duplicate Character Remover
    public static String removeDuplicateChars(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (result.indexOf(String.valueOf(c)) == -1) {
                result.append(c);
            }
        }
        return result.toString();
    }

    // 3. Inserting at Index
    public static String insertAt(String original, String toInsert, int index) {
        StringBuilder result = new StringBuilder(original);
        result.insert(index, toInsert);
        return result.toString();
    }

    // 4. Frequency Counter
    public static String characterFrequency(String input) {
        int[] freq = new int[256];
        for (char c : input.toCharArray()) {
            freq[c]++;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                result.append((char) i).append(":").append(freq[i]).append(" ");
            }
        }
        return result.toString().trim();
    }

    // 5. Morse Code Converter
    public static String toMorseCode(String input) {
        String[] morseCodes = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.",
                "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                "...-", ".--", "-..-", "-.--", "--.."
        };
        StringBuilder result = new StringBuilder();
        input = input.toUpperCase();
        for (char c : input.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                result.append(morseCodes[c - 'A']).append(" ");
            } else if (c == ' ') {
                result.append(" / ");
            }
        }
        return result.toString().trim();
    }

    // Expert Level Challenges

    // 1. Caesar Cipher Encoder/Decoder
    public static String caesarCipher(String input, int shift) {
        StringBuilder result = new StringBuilder();
        shift = shift % 26 + 26;
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    result.append((char) ('A' + (c - 'A' + shift) % 26));
                } else {
                    result.append((char) ('a' + (c - 'a' + shift) % 26));
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // 2. CamelCase to Snake_case Converter
    public static String camelToSnake(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append('_').append(Character.toLowerCase(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // 3. Expand Compressed Strings
    public static String expandCompressedString(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int count = 0;
            while (i + 1 < input.length() && Character.isDigit(input.charAt(i + 1))) {
                count = count * 10 + (input.charAt(++i) - '0');
            }
            while (count-- > 0) {
                result.append(c);
            }
        }
        return result.toString();
    }

    // 4. Remove Comments from Code
    public static String removeComments(String code) {
        StringBuilder result = new StringBuilder();
        boolean inBlock = false;
        for (int i = 0; i < code.length(); i++) {
            if (inBlock) {
                if (code.startsWith("*/", i)) {
                    inBlock = false;
                    i++;
                }
            } else if (code.startsWith("/*", i)) {
                inBlock = true;
                i++;
            } else if (code.startsWith("//", i)) {
                while (i < code.length() && code.charAt(i) != '\n') i++;
            } else {
                result.append(code.charAt(i));
            }
        }
        return result.toString();
    }

    // 5. Anagram Checker
    public static boolean areAnagrams(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);
        return java.util.Arrays.equals(arr1, arr2);
    }

    // 6. Toggle Case
    public static String toggleCase(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // New feature: Convert Integer to Roman Numerals
    public static String toRomanNumeral(int number) {
        if (number < 1 || number > 3999) {
            return "Invalid number. Enter a number between 1 and 3999.";
        }

        StringBuilder roman = new StringBuilder();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                number -= values[i];
                roman.append(numerals[i]);
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example usage of other methods
        System.out.println(reverseString("hello"));
        System.out.println(isPalindrome("racecar"));
        System.out.println(concatenateStrings("Hello", " ", "World", "!"));
        System.out.println(removeVowels("Beautiful Day"));
        System.out.println(capitalizeWords("hello world"));
        System.out.println(replaceSubstring("foobar", "foo", "bar"));
        System.out.println(removeDuplicateChars("banana"));
        System.out.println(insertAt("hello world", "Java ", 6));
        System.out.println(characterFrequency("apple"));
        System.out.println(toMorseCode("Hello World"));
        System.out.println(caesarCipher("abcXYZ", 3));
        System.out.println(camelToSnake("camelCaseExample"));
        System.out.println(expandCompressedString("a3b2c4"));
        System.out.println(removeComments("/* comment */ code // single line"));
        System.out.println(areAnagrams("listen", "silent"));
        System.out.println(toggleCase("Java123"));

        // New feature: Convert a number to Roman numeral
        System.out.print("Enter a number to convert to Roman numerals: ");
        int number = scanner.nextInt();
        System.out.println("Roman numeral: " + toRomanNumeral(number));

        scanner.close();
    }
}

