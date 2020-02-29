package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-29 17:42
 * @Email xjwhhh233@outlook.com
 */
public class ReversePairs {
    int res=0;
    public int reversePairs(int[] nums) {
        sort(nums,0,nums.length-1);
        return res;

    }

    private void merge(int[] nums,int left,int mid,int right){
        int i=left;
        int j=mid+1;
        int[] temp=new int[right-left+1];
        int t=0;
        while(i<=mid&&j<=right){
            if(nums[i]<=nums[j]){
                temp[t++]=nums[i++];
            }else{
                temp[t++]=nums[j++];
                res+=mid-i+1;
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = nums[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = nums[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            nums[left++] = temp[t++];
        }



    }

    private void sort(int[] nums,int left,int right){
        if(left<right){
            int mid = (left+right)/2;
            sort(nums,left,mid);//左边归并排序，使得左子序列有序
            sort(nums,mid+1,right);//右边归并排序，使得右子序列有序
            merge(nums,left,mid,right);//将两个有序子数组合并操作
        }
    }
}
