public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max=0;
        int width=height.length-1;
        int p=0;
        int q=width;
        while(p<q){
            max=Math.max(max,Math.min(height[p],height[q])*(q-p));
            if(height[p]>height[q]){
                q--;
            }else{
                p++;
            }
        }
        return max;

    }
}
