import java.util.*;

public class Q7 {
    static volatile long sink;
    static long testArrayList(int n,int repeats) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++)list.add(i);
        long s=System.nanoTime();
        for(int i=0;i<repeats;i++){list.add(0,-i);list.remove(0);}
        sink=list.size();return System.nanoTime()-s;
    }
    static long testArrayDeque(int n,int repeats) {
        ArrayDeque<Integer> deque=new ArrayDeque<>();
        for(int i=0;i<n;i++)deque.addLast(i);
        long s=System.nanoTime();
        for(int i=0;i<repeats;i++){deque.addFirst(-i);deque.removeFirst();}
        sink=deque.size();return System.nanoTime()-s;
    }
    public static void main(String[] args) {
        int[] sizes={1000,10000,50000};int repeats=2000;
        System.out.println("size,structure,front_add_remove_ns");
        for(int n:sizes) {
            // Warm-up
            testArrayList(Math.min(n,1000),100);testArrayDeque(Math.min(n,1000),100);
            long a=testArrayList(n,repeats),d=testArrayDeque(n,repeats);
            System.out.println(n+",ArrayList,"+a);
            System.out.println(n+",ArrayDeque,"+d);
        }
        System.out.println("Diagnosis: ArrayList shifts approximately n elements on each front insertion/removal.");
        System.out.println("Redesign: ArrayDeque uses a circular array and changes head/tail indices, giving amortized O(1) operations at either end.");
        System.out.println("Trade-off: ArrayDeque has no indexed get; retain ArrayList for random-access playlist browsing.");
    }
}
