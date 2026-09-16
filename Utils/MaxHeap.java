package Utils;

public class MaxHeap {

    private int[] Heap;
    private int size;
    private int maxsize;

    public MaxHeap(int maxsize){
        this.size = 0;
        this.maxsize = maxsize;
        Heap = new int[this.maxsize];
    }

    //Returning position of parent
    private int parent(int pos) { return (pos-1)/2;}

    //Returning left children
    private int leftChild(int pos) { return (2*pos) + 1;}

    //Returning right children
    private int rightChild(int pos) { return (2*pos) + 2;}

    //Returning true if given node is leaf
    private boolean isLeaf(int pos){
        if(pos > (size / 2) && pos <= size){
            return true;
        }

        return false;
    }

}
