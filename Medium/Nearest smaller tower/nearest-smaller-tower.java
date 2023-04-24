//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			int [] ans = ob.nearestSmallestTower(arr);
			for(int i = 0; i < n; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution{
	private int[] lns(int[] arr) {
		int[] lns = new int[arr.length];
		Arrays.fill(lns, -1);
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				stack.pop();
			}
			if (!stack.isEmpty()) {
				lns[i] = stack.peek();
			}
			stack.push(i);
		}
		return lns;
	}

	private int[] rns(int[] arr) {
		int[] rns = new int[arr.length];
		Arrays.fill(rns, -1);
		Stack<Integer> stack = new Stack<>();
		for (int i = arr.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				stack.pop();
			}
			if (!stack.isEmpty()) {
				rns[i] = stack.peek();
			}
			stack.push(i);
		}
		return rns;
	}

	int[] nearestSmallestTower(int[] arr) {
		int[] lns = lns(arr);
		int[] rns = rns(arr);
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int leftDist = lns[i] == -1 ? Integer.MAX_VALUE : i - lns[i];
			int rightDist = rns[i] == -1 ? Integer.MAX_VALUE : rns[i] - i;
			if (leftDist < rightDist || (leftDist == rightDist && lns[i] != -1 && arr[lns[i]] <= arr[rns[i]])) {
				result[i] = lns[i];
			} else {
				if (leftDist > rightDist || (leftDist == rightDist && rns[i] != -1 && arr[rns[i]] < arr[lns[i]])) {
					result[i] = rns[i];
				} else {
					result[i] = -1;
				}
			}
		}
		return result;
	}
}