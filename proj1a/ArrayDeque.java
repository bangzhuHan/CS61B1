/**
 * @author xh
 * @date 2022/4/8
 * @apiNote
 */
/**
 * 在本练习中，我们强烈建议您将数组视为圆形。
 * 换句话说，如果您的前指针在位置0,并且调用了addFirst，
 * 则前指针应该循环回到数组的末尾(因此双端队列中的新前项将是基础数组中的最后一项)。
 * 这将导致比非循环方法少得多的麻烦。有关更多详细信息，请参见项目1演示幻灯片。
 * 注意：
 * 1、add和remove除了重新规划数组外只要花费常数时间的代价
 * 2、get和size必须是常数时间
 * 3、初始数组长度为8
 * 4、您的程序在任何给定时间使用的内存量必须与项目数量成比例。
 * 例如，如果您向deque添加10，000个项目，然后移除9，999个项目，
 * 您不应该仍然使用长度为10，000左右的数组。对于长度为16或更长的数组，
 * 您的使用系数应始终至少为25%。对于较小的阵列，您的使用系数可以任意低。
 */

public class ArrayDeque<T> {

    private int nextFirst;
    private int nextLast;
    private int capacity;
    private T[]items;
    private int size;
    public ArrayDeque(){
        items=(T[])new Object[8];
        this.capacity=items.length;
        nextFirst=capacity-1;
        nextLast=0;
        size=0;
    }
    private void resize(int capacity){
        T[]a=(T[])new Object[capacity];
        //由于nextFirst和nextLast的位置不确定，只能一个一个地复制到新的数组中
        //从nextFirst右边的第一个点开始复制
        //到nextLast左边的第一个点复制结束
        for (int i=1;i<=size;i++)
            a[i]=items[(++nextFirst)%this.capacity];
        this.capacity=capacity;
        //这两个指针指向什么地方已经不重要了
        nextFirst=0;
        nextLast=size+1;
        items=a;
    }
    public void addFirst(T item) {
        //直接当size等于capacity时调整大小，而不是看两个指针的相对位置
        if (size==capacity)
            resize(capacity*2);
        items[nextFirst]=item;
        size++;
        //nextFirst有可能越界
        nextFirst=nextFirst==0?capacity-1:nextFirst-1;
    }

    public void addLast(T item) {
        if (size==capacity)
            resize(capacity*2);
        items[nextLast]=item;
        size++;
        //nextLast有可能越界
        nextLast=(nextLast+1)%capacity;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        //nextFirst有可能指向最后一个位置
        for (int i=(nextFirst+1)%capacity;i!=nextLast-1;i=(i+1)%capacity)
            System.out.print(items[i]+" ");
        System.out.print(items[nextLast-1]);
    }

    public T removeFirst() {
        //当数组的内容为空的时候，才无法进行remove操作，而不是取决于nextFirst的位置。
        if (size==0)return null;
        nextFirst=(nextFirst+1)%capacity;
        T temp=items[nextFirst];
        items[nextFirst]=null;
        size--;
        if (capacity>=16&&size<capacity/4)
            resize(capacity/2);
        return temp;
    }

    public T removeLast() {
        if (size==0)return null;
        nextLast=nextLast==0?capacity-1:nextLast-1;
        T temp=items[nextLast];
        items[nextLast]=null;
        size--;
        if (capacity>=16&&size<capacity/4)
            resize(capacity/2);
        return temp;
    }

    public T get(int index) {
        if (index>=size)
            return null;
        return items[(nextFirst+1+index)%capacity];
    }
}
