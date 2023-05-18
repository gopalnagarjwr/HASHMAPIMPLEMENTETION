import java.util.*;

import org.w3c.dom.Node;



public class Main {
    public static void main(String[] args) {
        Hashmap.Hashcode<String, Integer> map=new Hashmap.Hashcode<>();
        map.put("india",135);
        map.put("china",145);
        map.put("usa",90);
        map.put("Ingland",75);
        map.put("shree lanka",50);
            
        System.out.println(map.contains("india"));
        map.remove("china");

        ArrayList<String> arr=map.getkey();
        for (int i = 0; i <arr.size() ; i++) {
            System.out.println(arr.get(i)+" "+map.getv(arr.get(i)));
        }

    }
}
