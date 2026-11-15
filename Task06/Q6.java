import java.util.*;

class Patient {
    final String name; final int severity; final long arrival;
    Patient(String name,int severity,long arrival){this.name=name;this.severity=severity;this.arrival=arrival;}
    public String toString(){return name+"(S"+severity+")";}
}
public class Q6 {
    private long counter=0;
    private final PriorityQueue<Patient> queue=new PriorityQueue<>(
        Comparator.comparingInt((Patient p)->p.severity).thenComparingLong(p->p.arrival));
    void admit(String name,int severity){if(severity<1||severity>5)throw new IllegalArgumentException("Severity must be 1..5");queue.add(new Patient(name,severity,counter++));}
    Patient next(){return queue.poll();}
    public static void main(String[] args) {
        Q6 er=new Q6();
        er.admit("Ravi",3);er.admit("Meena",1);er.admit("John",3);
        er.admit("Asha",5);er.admit("Kumar",1);er.admit("Lata",2);er.admit("Sara",2);er.admit("Dev",4);
        StringBuilder order=new StringBuilder();Patient p;
        while((p=er.next())!=null)order.append(p).append(' ');
        System.out.println(order.toString().trim());
        int[] sizes={1000,10000,50000};
        System.out.println("queue_size,add_ns,remove_all_ns");
        for(int n:sizes) {
            PriorityQueue<Integer> q=new PriorityQueue<>();
            long s=System.nanoTime();for(int i=n;i>0;i--)q.add(i);long add=System.nanoTime()-s;
            s=System.nanoTime();while(!q.isEmpty())q.poll();long remove=System.nanoTime()-s;
            System.out.println(n+","+add+","+remove);
        }
        System.out.println("Direct PriorityQueue iteration is not sorted; repeatedly poll a copy to display treatment order.");
    }
}
