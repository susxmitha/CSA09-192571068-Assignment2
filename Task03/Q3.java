import java.util.*;

public class Q3 {
    static class BrokenStudent {
        String regNo,name;
        BrokenStudent(String r,String n){regNo=r;name=n;}
        public boolean equals(Object o){return o instanceof BrokenStudent && regNo.equals(((BrokenStudent)o).regNo);}
        // Deliberately missing hashCode()
    }
    static class Student {
        final String regNo,name;
        Student(String r,String n){regNo=r;name=n;}
        public boolean equals(Object o){if(this==o)return true;if(!(o instanceof Student))return false;return regNo.equals(((Student)o).regNo);}
        public int hashCode(){return Objects.hash(regNo);}
        public String toString(){return regNo+" "+name;}
    }
    public static void main(String[] args) {
        Set<BrokenStudent> distinctOnly=new HashSet<>();
        distinctOnly.add(new BrokenStudent("192311001","Arun"));
        distinctOnly.add(new BrokenStudent("192311002","Divya"));
        System.out.println("Test 1 - distinct scans, set size: "+distinctOnly.size());

        Set<BrokenStudent> broken=new HashSet<>();
        broken.add(new BrokenStudent("192311001","Arun"));
        broken.add(new BrokenStudent("192311002","Divya"));
        broken.add(new BrokenStudent("192311001","Arun"));
        System.out.println("Test 2 - broken equals/hashCode, set size: "+broken.size());

        Set<Student> fixed=new HashSet<>();
        fixed.add(new Student("192311001","Arun"));
        fixed.add(new Student("192311002","Divya"));
        fixed.add(new Student("192311001","Arun"));
        System.out.println("Test 3 - corrected HashSet size: "+fixed.size());

        Set<Student> tree=new TreeSet<>(Comparator.comparing(s->s.regNo));
        tree.add(new Student("192311001","Arun"));tree.add(new Student("192311002","Divya"));tree.add(new Student("192311001","Arun"));
        System.out.println("TreeSet size: "+tree.size());
        Map<String,Student> map=new HashMap<>();
        map.put("192311001",new Student("192311001","Arun"));map.put("192311002",new Student("192311002","Divya"));
        map.put("192311001",new Student("192311001","Arun"));
        System.out.println("HashMap size: "+map.size());
        System.out.println("The broken HashSet size is not guaranteed; hash codes are identity-based in this deliberately incorrect class.");
    }
}
