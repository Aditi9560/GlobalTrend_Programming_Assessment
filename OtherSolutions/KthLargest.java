package assesmentsolutions;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargest {

	public static int kthLargest(int arr[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i : arr) {
			pq.add(i);
		}

		for (int j = 0; j < k-1; j++) {
			pq.poll();
		}

		return pq.peek();
	}

	public static void main(String[] args) {
		int arr[] = { 3, 4, 6, 2, 8 ,9,10,1,10};
		System.out.println("the kth largest element is = "+kthLargest(arr, 2));
		System.out.println("the kth largest element is = "+kthLargest(arr, 3));

	}
}
