package Heap.MaxHeap;

import java.util.ArrayList;
import java.util.List;

/**
 * 在堆的有关操作中，需要比较堆中元素的大小，所以T需要extends Comparable
 * @param <T>
 */
public class MaxHeap<T extends Comparable<T>> {

    private List<T> data;  // 堆一般采用数组来实现，若采用数组，即需要创建泛型数组，比较麻烦。所以这里使用ArrayList<T>

    // 构造函数, 构造一个空堆
    public MaxHeap() {
        data = new ArrayList<>();
    }

    public T get(int index) {
        return data.get(index);
    }

    // 返回堆中的元素个数
    public int size()  {
        return this.data.size();
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    // 向最大堆中插入一个新的元素 elem
    public void insert(T elem) {
        data.add(elem);
        int k = data.size()-1;
        shiftUp(k);
    }

    // 从最大堆中取出堆顶元素, 即堆中所存储的最大数据
    public T extractMax(){
        T elem = data.get(0);
        int lastIndex = data.size()-1;
        data.set(0, data.get(lastIndex));
        data.remove(lastIndex);
        shiftDown(0);
        return elem;
    }

    /**
     * 最大堆的核心辅助函数：向上调整
     *
     * 数组实现的堆中（从0开始计数），第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
     * @param k 需要调整位置的元素的索引
     */
    private void shiftUp(int k) {
        while (k > 0 && data.get((k-1)/2).compareTo(data.get(k)) < 0) {
            swap((k-1)/2, k);
            k = (k-1)/2;
        }
    }

    /**
     * 最大堆的核心辅助函数：向下调整
     *
     * 数组实现的堆中（从0开始计数），第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
     * @param k 需要调整位置的元素的索引
     */
    private void shiftDown(int k) {
        while (2*k+1 < data.size()) {
            int j = 2*k+1;
            if(j+1 < data.size() && data.get(j).compareTo(data.get(j+1)) < 0)
                j++;
            if (data.get(k).compareTo(data.get(j)) >= 0) break;
            swap(k,j);
            k = j;
        }
    }

    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j){
        T t = data.get(i);
        data.set(i,data.get(j));
        data.set(j, t);
    }
}
