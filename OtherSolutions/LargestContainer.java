package assesmentsolutions;

public class LargestContainer {
	public static int maxArea(int[] height) {
		int l=0;
		int r=height.length-1;
		int max=0;
		
		while(l<r) {
			int currheight=Math.min(height[l], height[r]);
			int currwidth=r-l;
			int area=currheight*currwidth;
			
			max=Math.max(max, area);
			
			if(height[l]<height[r]) {
				l++;
			}
			else {
				r--;
			}
		}
		
		return max;
	}
	public static void main(String[] args) {
		int height[]= {3,4,5,6,7};
		System.out.println("maximum water that can be contained is "+maxArea(height));
	}

}
