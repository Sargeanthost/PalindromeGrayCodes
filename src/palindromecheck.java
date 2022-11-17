public class palindromecheck {

    /**
     * Returns whether {@code str} is a palindrome. Ignores special characters and spaces. O(n)
     * @param str the string to check
     * @return returns whether {@code str} is a palindrome
     */
    public static boolean palindromeCheck(String str) {
        return realChecker(
            str.toLowerCase().replaceAll("\\s+", "").replaceAll("[0-9]", "").replaceAll("[!-/:-@\\[-`{-~]", ""));
    }

    private static boolean realChecker(String str) {
        //Base case
        if (str.length() <= 1) {
            return true;
        }
        //If the ends aren't equal, not a palindrome. If we get to no char or one char left, it's a palindrome.
        if (str.charAt(0) != (str.charAt(str.length() - 1))) {
            return false;
        }
        return realChecker(str.substring(1, str.length() - 1));
    }
}
