import javax.swing.plaf.InsetsUIResource;

public class SSList {
    public static class IntNode{
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode sentinel;
    private static int size;
    private IntNode first;

    public SSList(){
        sentinel = new IntNode(34, null);
        size = 0;
    }

    public SSList(int x) {
        sentinel = new IntNode(34, null);
        sentinel.next = new IntNode(x,null);
        size = 1;
    }

    /**
     * add x to the first of the list
     * @param x
     */
    public void addFirst(int x){
        sentinel.next = new IntNode(x,sentinel.next);
        size++;
    }

    /**
     * get the first item of the list
     * @return
     */
    public int getFirst(){
        return sentinel.next.item;
    }

    /**
     * add x to the end of the list
     * @param x
     */
    public void addLast(int x){
        IntNode p = sentinel;
        while(p.next != null){
             p = p.next;
        }
        p.next = new IntNode(x, null);
        size++;
    }

    /**
     * return the last item of the list
     * @return
     */
    public int getLast(){
        IntNode p = sentinel;
        while(p.next != null){
            p = p.next;
        }
        return p.item;
    }

    /**
     * return the size of the list by iteratively
     * @return
     */
    public int iterativesize(){
        int num = 0;
        IntNode p = first;
        while(p != null){
            p = p.next;
            num++;
        }
        return num;
    }

    /**
     * return the size of the list by recursively
     * @param
     */
    public int recursionSize(IntNode x){
            if(x.next == null) return 1;
            else return 1 + recursionSize(x.next);
    }

    public static void main(String[] args) {
        SSList list = new SSList();
        /*list.addFirst(55);
        list.addFirst(34);
        list.addLast(100);*/
        /*System.out.println(list.getFirst());*/
        System.out.println(list.getLast());
        System.out.println(list.recursionSize(list.sentinel));
    }
}

