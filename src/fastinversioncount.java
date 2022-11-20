import java.util.Arrays;

public class fastinversioncount {
    // Merge count will work alongside a merge sort. There are two steps, partition and merge. When partitioning,
    // there are no extra steps; it is the same as merge sort. When merging, we count the inversions in the current
    // bucket. For an even numbered starting array, this will be something like [20,1] (1 inversion present). Then,
    // they will be sorted. This guarantees that when merging with another array, we only have to go up until a
    // single inversion is found, then all remaining elements will have an inversion with the current number. If not,
    // then it will go through the entire to-merge array (worst case). Good case example:
    // I([20,1]) => 1 | I([12,3]) => 2 ==> M([1,20],[3,12]) => I([1,3]) => 0 | I([1,12]) => 0 / I([20,3]) => 1 | I([20,
    // 12]) => 1.
    // Short circuit example:
    //  M([20,21],[6,7]) => I([20,6]) => 1. Since anything to the right of 20 is greater, we add I(x) * 2, so there
    //  is no need to check 21 for any case.

    private static int merge(int[] arr, int left, int mid, int right) {
        int[] leftA = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightA = Arrays.copyOfRange(arr, mid + 1, right + 1);
        int count = 0;
        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftA.length && j < rightA.length) {
            if (leftA[i] <= rightA[j]) {
                arr[k++] = leftA[i++];//ordered
            } else {
                arr[k++] = rightA[j++];//inversion
                count += (mid + 1) - (left + i);//short circuit
            }
        }
        //remake arr
        while (i < leftA.length) {
            arr[k++] = leftA[i++];
        }
        while (j < rightA.length) {
            arr[k++] = rightA[j++];
        }
        return count;
    }

    private static int fastInversion(int[] arr, int left, int right) {
        int count = 0;

        // if not arr of n = 1, then it is not split into base components of merge sort yet
        if (right > left) {
            int mid = (left + right) / 2;

            count += fastInversion(arr, left, mid); //left
            count += fastInversion(arr, mid + 1, right); //right

            count += merge(arr, left, mid, right); // merge sub arrs
        }
        return count;
    }

    /**
     * Counts the inversions between two ordered arrays.
     *
     * @param arr array
     * @return returns inversions in the array
     */
    public static int fastInversion(int[] arr) {
        //arr, index of first elem, index of last elem
        return fastInversion(arr, 0, arr.length - 1);
    }
}
