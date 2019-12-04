package OJ2019.homework.review;

import javafx.util.Pair;

import java.util.*;

public class sor_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        for(int i=0;i<total;i++){
            int n=scanner.nextInt();

            ArrayList<Integer> arrayList=new ArrayList<>();

            for(int j=0;j<n;j++){
                arrayList.add(scanner.nextInt());
            }

            helper(arrayList);
        }
    }

    private static void helper(ArrayList<Integer> A){
        ArrayList<Integer> copy=new ArrayList<>(A);
        Collections.sort(copy);
        int count=0;

        for(int i=0;i<copy.size();i++){
            if(!copy.get(i).equals(A.get(i))){
                int j=A.indexOf(copy.get(i));
                int temp=A.get(i);
                A.set(i,copy.get(i));
                A.set(j,temp);
                count++;

            }
        }
        System.out.println(count);


    }

    public static int minSwaps(int[] arr)
    {
        int n = arr.length;

        // Create two arrays and use as pairs where first
        // array is element and second array
        // is position of first element
        ArrayList <Pair<Integer, Integer>> arrpos =
                new ArrayList <Pair <Integer, Integer> > ();
        for (int i = 0; i < n; i++)
            arrpos.add(new Pair <Integer, Integer> (arr[i], i));

        // Sort the array by array element values to
        // get right position of every element as the
        // elements of second array.
        arrpos.sort(new Comparator<Pair<Integer, Integer>>()
        {
            @Override
            public int compare(Pair<Integer, Integer> o1,
                               Pair<Integer, Integer> o2)
            {
                if (o1.getKey() > o2.getKey())
                    return -1;

                    // We can change this to make it then look at the
                    // words alphabetical order
                else if (o1.getKey().equals(o2.getKey()))
                    return 0;

                else
                    return 1;
            }
        });

        // To keep track of visited elements. Initialize
        // all elements as not visited or false.
        Boolean[] vis = new Boolean[n];
        Arrays.fill(vis, false);

        // Initialize result
        int ans = 0;

        // Traverse array elements
        for (int i = 0; i < n; i++)
        {
            // already swapped and corrected or
            // already present at correct pos
            if (vis[i] || arrpos.get(i).getValue() == i)
                continue;

            // find out the number of  node in
            // this cycle and add in ans
            int cycle_size = 0;
            int j = i;
            while (!vis[j])
            {
                vis[j] = true;

                // move to next node
                j = arrpos.get(j).getValue();
                cycle_size++;
            }

            // Update answer by adding current cycle.
            if(cycle_size > 0)
            {
                ans += (cycle_size - 1);
            }
        }

        // Return result
        return ans;
    }

}
