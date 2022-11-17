public class easyinversioncount {

    /**
     * Returns the number of inversions in an ordered set. O(n^2).
     *
     * @param arr the array to check inversions in
     * @return returns the count of inversions found
     */
    public static int easyInversion(int[] arr){
        int count = 0;
        for (int j = 0; j < arr.length; j++){
            for (int i = j; i < arr.length; i++){
                if (arr[j] > arr[i]){
                    count++;
                }
            }
        }
        return count;
    }
}
