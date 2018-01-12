import java.util.HashSet;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

/**
* Quick Sort Algorithm
* 
* Implements https://en.wikipedia.org/wiki/Quicksort#Lomuto_partition_scheme
* Modified to use a random pivot point.
*
* Time Complexity
* O(n^2)
* omega(nlog(n)) [best]
* theta(nlog(n)) [average]
*
* Space Complexity
* O(log(n))
*/
public class QuickSort {
	public static void main(String[] args) {
		int[] unsorted = {3, 7, 8, 5, 2, 1, 9, 5, 4};
		int loIndex = 0;
		int hiIndex = unsorted.length - 1;
		int[] sorted = quickSort(unsorted, loIndex, hiIndex);
		System.out.println(Arrays.toString(sorted));
	}

	public static int[] quickSort(int[] unsorted, int lo, int hi) {
		int[] partiallySorted = unsorted;
		if (lo < hi) {
			int part = partition(unsorted, lo, hi);
			partiallySorted = quickSort(unsorted, lo, part - 1);
			partiallySorted = quickSort(partiallySorted, part + 1, hi);
		}
		return partiallySorted;
	}

	public static int partition(int[] unsorted, int lo, int hi) {
		Random random = new Random(); // handles already sorted algorithms
		int pivot = random.nextInt(hi + 1 - lo) + lo;
		int i = lo - 1;
		for (int j = lo; j < hi; j++) {
			if (unsorted[j] < pivot) {
				i = i + 1;
				int temp = unsorted[i];
				unsorted[i] = unsorted[j];
				unsorted[j] = temp;
			}
		}
		if (unsorted[hi] < unsorted[i + 1]) {
			int temp = unsorted[i + 1];
			unsorted[i + 1] = unsorted[hi];
			unsorted[hi] = temp;
		}
		return i + 1;
	}
}
