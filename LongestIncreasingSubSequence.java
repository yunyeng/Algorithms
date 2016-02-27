import java.util.*;

class LongestIncreasingSubSequence {
	
	public static int count(int[] nums){
		int[] longest = new int[nums.length];
		int[] prev    = new int[nums.length];
		int maxInd = 0;
		for(int n : nums){
			longest[maxInd] = 1;
			prev[maxInd]    = -1;
			maxInd++;
		}
		maxInd = 0;
		for(int i=1; i<nums.length; i++){
			for(int j=0; j<i; j++){
				if(nums[i] > nums[j] && longest[j] + 1 > longest[i]){
					longest[i] = longest[j] + 1;
					prev[i] = j;
				}
			}
			if(longest[i] > longest[maxInd])
				maxInd = i;
		}
		return longest[maxInd];
	}
	public static List<Integer> list(int[] nums){
		int[] longest = new int[nums.length]	;
		int[] prev    = new int[nums.length];
		int maxInd = 0;
		for(int n : nums){
			longest[maxInd] = 1;
			prev[maxInd]    = -1;
			maxInd++;
		}
		maxInd = 0;
		for(int i=1; i<nums.length; i++){
			for(int j=0; j<i; j++){
				if(nums[i] > nums[j] && longest[j] + 1 > longest[i]){
					longest[i] = longest[j] + 1;
					prev[i] = j;
				}
			}
			if(longest[i] > longest[maxInd])
				maxInd = i;
		}
		int maxVal = longest[maxInd];
		List<Integer> output = new ArrayList<>();
		while(maxVal-- > 0){
			output.add(0, nums[maxInd]);
			maxInd = prev[maxInd];
		}
		return output;
	}
	
	public static void main(String[] args) {
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		List<Integer> output = list(nums);
		System.out.println(count(nums));
		for(Integer out : output)
			System.out.print(out + " ");
	}
}