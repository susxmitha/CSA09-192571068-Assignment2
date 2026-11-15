import java.util.*;
import java.util.function.Supplier;

public class Q1 {
    static String[] fields(int n) {
        String[] a = new String[n];
        for (int i=0;i<n;i++) a[i]="FIELD"+i+"=VALUE"+i;
        return a;
    }
    static String plus(String[] a) {
        String s="";
        for(String x:a) s += x + "|";
        return s;
    }
    static String builder(String[] a) {
        StringBuilder b=new StringBuilder();
        for(String x:a) b.append(x).append('|');
        return b.toString();
    }
    static String buffer(String[] a) {
        StringBuffer b=new StringBuffer();
        for(String x:a) b.append(x).append('|');
        return b.toString();
    }
    static long bench(Supplier<String> fn, int repeats) {
        long start=System.nanoTime();
        for(int i=0;i<repeats;i++) fn.get();
        return (System.nanoTime()-start)/repeats;
    }
    static long usedMemory() {
        Runtime r=Runtime.getRuntime();
        return r.totalMemory()-r.freeMemory();
    }
    public static void main(String[] args) {
        int[][] workloads={{6,1},{50,10000},{200,2000}};
        System.out.println("fields,tickets,plus_ns_per_ticket,builder_ns_per_ticket,buffer_ns_per_ticket,heap_before_bytes,heap_after_bytes");
        for(int[] w:workloads) {
            String[] a=fields(w[0]); int reps=w[1];
            for(int i=0;i<Math.min(1000,reps);i++){plus(a);builder(a);buffer(a);}
            System.gc();
            long before=usedMemory();
            long p=bench(()->plus(a),reps);
            long b=bench(()->builder(a),reps);
            long sb=bench(()->buffer(a),reps);
            long after=usedMemory();
            System.out.println(w[0]+","+reps+","+p+","+b+","+sb+","+before+","+after);
        }
        System.out.println("Heap readings are approximate snapshots and are affected by JVM garbage collection; repeat trials and do not treat them as exact allocation counts.");
        System.out.println("Estimated intermediates: repeated + creates successive String results; builder/buffer reuse a mutable buffer and create a final String.");
        System.out.println("Recommendation: StringBuilder for a thread-confined ticket; use a thread-safe logging facility or queued logging for shared logs.");
    }
}
