import java.util.Arrays;

public class Median {

    public static double findMedian(int a[], int n){
        // First we sort the array
        Arrays.sort(a);

        // check for even case
        if (n % 2 != 0)
            return (double)a[n / 2];

        return (double)(a[(n - 1) / 2] + a[n / 2]) / 2.0;
    }
}
