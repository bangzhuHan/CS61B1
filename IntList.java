import org.w3c.dom.ls.LSOutput;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int first, IntList rest) {
        this.first = first;
        this.rest = rest;
    }

    public static void main(String[] args) {
        IntList l = new IntList(13,null);
         l =  new IntList(15,l);
         l = new IntList(110,l);
         l = new IntList(3,l);
        System.out.println(l.size1());
        System.out.println(l.iterativeSize());
        System.out.println(l.get(0));
    }

    /**
     * Return the size of the List
     */

    public int size1(){
        if(rest == null)return 1;
        else return 1 + this.rest.size1();
    }

    /** Return the size of the list using no recursion! */
    public int iterativeSize(){
        IntList p = this;
        int totalSize = 0;
        while(p != null){
            totalSize++;
            p = p.rest;
        }
        return totalSize;
    }

    /**
     * Return the ith item of the list
     */
    public int get(int i){
        if(i == 0)  return first;
        else return rest.get(i -1);
    }
}
