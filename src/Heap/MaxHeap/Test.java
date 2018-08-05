package Heap.MaxHeap;

public class Test {

    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
        System.out.println(maxHeap.size());
        int N = 50; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)

        for( int i = 0 ; i < N ; i ++ )
            maxHeap.insert( (int)(Math.random() * M) );
        System.out.println(maxHeap.size());
        PrintableMaxHeap.treePrint(maxHeap);

        Integer[] arr = new Integer[N];
        // 将maxheap中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for( int i = 0 ; i < N ; i ++ ){
            arr[i] = maxHeap.extractMax();
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
