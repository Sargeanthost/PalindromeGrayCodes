public class Main {
    public static void main(String[] args) {
        System.out.println("Palindromes");
        palindrome();
        System.out.println("Slow inversion");
        easyInversion();
        System.out.println("Fast inversion");
        fastInversion();
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
        int[] testSet3 = {1, 3, 2};
        int[] testSet4 = {8, 4, 2, 1};
        int[] testSet5 = {20, 9, 1, 15, 10, 7};
        System.out.println("Number of slow inversions: " + easyinversioncount.easyInversion(testSet));
        System.out.println("Number of slow inversions: " + easyinversioncount.easyInversion(testSet2));
        System.out.println("Number of slow inversions: " + easyinversioncount.easyInversion(testSet3));
        System.out.println("Number of slow inversions: " + easyinversioncount.easyInversion(testSet4));
        System.out.println("Number of slow inversions: " + easyinversioncount.easyInversion(testSet5));
    }

    public static void fastInversion(){
        int[] testSet = {3, 2, 1};
        int[] testSet2 = {1, 2, 3};
        int[] testSet3 = {1, 3, 2};
        int[] testSet4 = {8, 4, 2, 1};
        int[] testSet5 = {20, 9, 1, 15, 10, 7};
        System.out.println("Number of fast inversions: " + fastinversioncount.fastInversion(testSet));
        System.out.println("Number of fast inversions: " + fastinversioncount.fastInversion(testSet2));
        System.out.println("Number of fast inversions: " + fastinversioncount.fastInversion(testSet3));
        System.out.println("Number of fast inversions: " + fastinversioncount.fastInversion(testSet4));
        System.out.println("Number of fast inversions: " + fastinversioncount.fastInversion(testSet5));
    }
}