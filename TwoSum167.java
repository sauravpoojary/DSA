public class TwoSum167 {

    private static int binarySearch(int []a,int s,int e,int t){
        while(s<=e){
            int m = s + (e-s)/2;
            if(a[m] == t){
                return m;
            }

            if(a[m] > t){
                e = m - 1;
            }else{
                s = m+1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int []numbers = new int[]{5,25,75};

        int target = 100;

        int len = numbers.length;
        int []res = new int[2];

        for(int i=0; i<len; i++){
            int diff = target - numbers[i];
            int y = binarySearch(numbers,i+1,len-1,diff);
            if(y != -1){
                res[0] = i+1;
                res[1] = y+1;
                break;
            }
        }

        System.out.println(res[0] + "::::" +res[1]);


        //Better solution taking O(LOGN)

        // public int[] twoSum(int[] numbers, int target) {
        //     int n = numbers.length;
        //     int l = 0;
        //     int h = n-1;
        //     while(l<=h){
        //         int sum = numbers[l] + numbers[h];
        //         if(sum == target){
        //             return new int[]{l+1,h+1};
        //         }
        //         if(target<sum){
        //             h--;
        //         }else{
        //             l++;
        //         }
        //     }
    
        //     return new int[]{-1,-1};
        // }
    }
}