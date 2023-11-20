package DailyChanllenge;
public class MinimumAmountofTimetoCollectGarbage {
    public static int garbageCollection(String[] garbage, int[] travel) {
        int g_len = garbage.length;
        int t_len = travel.length;

        int garbage_pickup_time = 0;
        int lastPIndex = 0;
        int lastMIndex = 0;
        int lastGIndex = 0;
        //will be total no of characters
        int ind = 0;
        for(String s: garbage){
            garbage_pickup_time += s.length();
            if(s.contains("P"))lastPIndex = ind;
            if(s.contains("M"))lastMIndex = ind;
            if(s.contains("G"))lastGIndex = ind;

            ind++;
        }

        int prefix_sum []=new int[t_len];
        prefix_sum[0] = travel[0];
        for(int i=1; i<t_len; i++){
            prefix_sum[i] = prefix_sum[i-1] + travel[i];  
        }

        System.out.println("gar:: "+garbage_pickup_time);

        
        if(lastPIndex>0){
            garbage_pickup_time+=prefix_sum[lastPIndex-1];
        }
        if(lastMIndex>0){
            garbage_pickup_time+=prefix_sum[lastMIndex-1];
        }
        if(lastGIndex>0){
            garbage_pickup_time+=prefix_sum[lastGIndex-1];
        }
        return garbage_pickup_time ;

    }

    public static void main(String[] args) {
        String[] garbage = new String[]{"G","P","GP","GG"};
        int[] travel = new int[]{2,4,3};

        System.out.println(garbageCollection(garbage, travel));
    }
}
