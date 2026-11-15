import java.util.*;

public class Q2 {
    static volatile long sink;
    static long time(Runnable r) { long s=System.nanoTime(); r.run(); return System.nanoTime()-s; }
    static ArrayList<Integer> array(int n){ArrayList<Integer>a=new ArrayList<>();for(int i=0;i<n;i++)a.add(i);return a;}
    static LinkedList<Integer> linked(int n){LinkedList<Integer>a=new LinkedList<>();for(int i=0;i<n;i++)a.add(i);return a;}
    public static void main(String[] args) {
        int[] sizes={1000,10000,30000};
        System.out.println("size,structure,append_ns,front_insert_remove_ns,middle_insert_remove_ns,get_middle_ns,iterate_ns");
        for(int n:sizes) {
            final ArrayList<Integer> a1=array(n);
            final LinkedList<Integer> l1=linked(n);
            long aa=time(()->{for(int i=0;i<2000;i++)a1.add(i);});
            long la=time(()->{for(int i=0;i<2000;i++)l1.add(i);});

            final ArrayList<Integer> a2=array(n);
            final LinkedList<Integer> l2=linked(n);
            long af=time(()->{for(int i=0;i<300;i++){a2.add(0,-i);a2.remove(0);}});
            long lf=time(()->{for(int i=0;i<300;i++){l2.add(0,-i);l2.remove(0);}});

            final ArrayList<Integer> a3=array(n);
            final LinkedList<Integer> l3=linked(n);
            final int mid=n/2;
            long am=time(()->{for(int i=0;i<100;i++){a3.add(mid,-i);a3.remove(mid);}});
            long lm=time(()->{for(int i=0;i<100;i++){l3.add(mid,-i);l3.remove(mid);}});

            final ArrayList<Integer> a4=array(n);
            final LinkedList<Integer> l4=linked(n);
            long ag=time(()->{long x=0;for(int i=0;i<20000;i++)x+=a4.get(mid);sink=x;});
            long lg=time(()->{long x=0;for(int i=0;i<20000;i++)x+=l4.get(mid);sink=x;});

            final ArrayList<Integer> a5=array(n);
            final LinkedList<Integer> l5=linked(n);
            long ai=time(()->{long x=0;for(int v:a5)x+=v;sink=x;});
            long li=time(()->{long x=0;for(int v:l5)x+=v;sink=x;});
            System.out.println(n+",ArrayList,"+aa+","+af+","+am+","+ag+","+ai);
            System.out.println(n+",LinkedList,"+la+","+lf+","+lm+","+lg+","+li);
        }
        System.out.println("Up Next recommendation: ArrayDeque for frequent operations at both ends; it does not provide indexed access.");
    }
}
