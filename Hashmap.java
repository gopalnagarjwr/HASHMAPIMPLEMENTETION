import java.util.ArrayList;
import java.util.LinkedList;

//   => HASHMAP IMPLEMENTION <= 

class Hashmap{
    static class Hashcode<k, v> {
        class Node{
            k key;
            v value;
            Node(k key,v value){
                this.key=key;
                this.value=value;
            }
        }
        int n;
        int N;
        LinkedList<Node> bucket[];
        public Hashcode(){          //Hashmap create then hashcode constructor call
            this.N=4;
            this.bucket=new LinkedList[4];
            for(int i=0; i< bucket.length; i++){
                bucket[i]=new LinkedList<>();
            }
        }
        public void rehash (){             //rehash method bucket size doubal karne ke liye
            LinkedList<Node> oldbucket[] =bucket;
            bucket=new LinkedList[N*2];
            for(int i=0;i<N*2; i++){
                bucket[i]=new LinkedList<>();
            }
            for (int i=0; i<oldbucket.length; i++){
                LinkedList<Node> ll=bucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node=ll.get(j);
                    put(node.key, node.value);
                }
            }
        }
        public int hashfunction(k key){     // hashcode se bucket index nikalne ke liye 
           int bi=key.hashCode();
           return Math.abs(bi)%N;
  
        }
        public int searchdata(k key,int bi){   //key and bucket index ki help se data index
            for (int i=0; i<bucket[bi].size(); i++){
               if(bucket[bi].get(i).key==key){
                   return i;
               }
            }
            return -1;
        }
  
        public  void put(k key ,v value){  //Hashmap me element add karne ke liye
            int bi=hashfunction(key);
            int di=searchdata(key, bi);
  
            if(di == -1){
                bucket[bi].add(new Node(key, value));
                n++;
            }
            else{
                Node data= bucket[bi].get(di);
                data.value=value;
            }
            double lemda=(double)n/N;
            if(lemda>2.0){
                 rehash();
            }
        }
        public ArrayList<k>  getkey(){      // Hashmap ki key ke liye
            ArrayList<k> keys=new ArrayList<>();
            for (int i=0; i< bucket.length; i++){
                for (int j = 0; j < bucket[i].size(); j++) {
                    Node node=bucket[i].get(j);
  
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public v getv(k key) {          // Hashmap key ki help se key ki value
            int bi = hashfunction(key);
            int di = searchdata(key, bi);
  
            if (di == -1) {
                return null;
            } else {
                Node data = bucket[bi].get(di);
                return data.value;
            }
        }
  
        public boolean contains(k key){    //Hashmap me key check karne ke liye
            int bi = hashfunction(key);
            int di = searchdata(key, bi);
            if (di == -1) {
                return false;
            }
            return true;
        }
  
        public void remove(k key){           // element delete karne ke liye
            int bi = hashfunction(key);
            int di = searchdata(key, bi);
            bucket[bi].remove(bucket[bi].get(di));
        }
  
      }
  
  }