public class Main {
    public static void main(String[] args) {
        palindrome();
        easyInversion();
    }

    public static void palindrome() {
        System.out.println(palindromecheck.palindromeCheck("!m b0b")); //false
        System.out.println(palindromecheck.palindromeCheck("never odd or even")); //true
        System.out.println(palindromecheck.palindromeCheck("Able was I ere I saw Elba.")); //true
        System.out.println(palindromecheck.palindromeCheck("A man, a plan, a canal: Panama!")); //true
    }

    public static void easyInversion() {
        int[] testSet = {3, 2, 1};
        int[] testSet2 = {1, 2, 3};
        int[] testSet3 = {1,3,2};
        System.out.println("Number of inversions: " + easyinversioncount.easyInversion(testSet));
        System.out.println("Number of inversions: " + easyinversioncount.easyInversion(testSet2));
        System.out.println("Number of inversions: " + easyinversioncount.easyInversion(testSet3));
    }
}