import java.util.*;

public class Q4 {
    static volatile int sink;
    static long lookup(Map<Integer,Integer> m,int count,int size) {
        long s=System.nanoTime();int x=0;
        for(int i=0;i<count;i++) x+=m.get(i%size);
        sink=x;return System.nanoTime()-s;
    }
    static long iterate(Map<Integer,Integer> m) {
        long s=System.nanoTime();int x=0;
        for(Map.Entry<Integer,Integer> e:m.entrySet())x+=e.getValue();
        sink=x;return System.nanoTime()-s;
    }
    public static void main(String[] args) {
        int[] sizes={100,1000,10000}; final int lookups=100000;
        System.out.println("medicines,map,100000_lookups_ns,iteration_ns,code_order");
        for(int n:sizes) {
            Map<Integer,Integer> h=new HashMap<>(),t=new TreeMap<>(),lh=new LinkedHashMap<>();
            for(int i=n-1;i>=0;i--){h.put(i,i*10);t.put(i,i*10);lh.put(i,i*10);}
            for(Map.Entry<Integer,?> e:h.entrySet()){} // warm-up traversal
            System.out.println(n+",HashMap,"+lookup(h,lookups,n)+","+iterate(h)+",NO");
            System.out.println(n+",TreeMap,"+lookup(t,lookups,n)+","+iterate(t)+",YES");
            System.out.println(n+",LinkedHashMap,"+lookup(lh,lookups,n)+","+iterate(lh)+",NO (insertion order)");
        }
        System.out.println("HashMap: average O(1) put/get, iteration O(n), no guaranteed order.");
        System.out.println("TreeMap: O(log n) put/get, sorted-key iteration O(n). LinkedHashMap: average O(1), insertion-order iteration O(n).");
        System.out.println("Hashtable is legacy synchronized API; prefer HashMap plus explicit concurrency control when required.");
    }
}
