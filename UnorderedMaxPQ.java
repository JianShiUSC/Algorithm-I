//Priority queue: unordered array implementation
public class UnorderedMaxPQ<Key extends Comparable<Key>>
{
    private Key[] pq;   //pq[i] = ith element on pq
    private int N;      //number of elements on pq

    public UnorderedMaxPQ(int capacity)     //no generic array creation
    { pq = (Key[]) new Comparable[capacity]; }

    public boolean isEmpty()
    { return N == 0; }

    public void insert(Key x)
    { pq[N++] = x; }

    public Key delMax()
    {
        int max = 0;
        for(int i = 1; i < N; i++)      //less() and exch() similar to sorting methods
            if(less(max, i))    max = i;
        exch(max, N-1);
        return pq[--N];     //null out entry to prevent loitering(滞留)
    }
}


//Priority queue: Binary heap implementation
public class MaxPQ<Key extends Comparable<Key>>
{
    private Key[] pq;
    private int N;

    public MaxPQ(int capacity)      //fixed capacity (for simplicity)
    { pq = (Key[]) new Comparable[capacity+1]; }

    public boolean isEmpty()        //PQ ops
    { return N == 0; }
    public void insert(Key key)
    {
        pq[++N] = key;
        swim(N);
    }
    public Key delMax()
    {
        Key max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N+1] = null;             //prevent loitering
        return max;
    }

    private void swim(int k)
    {
        while(k > 1 && less(k/2, k))
        {
            exch(k, k/2);
            k = k/2;                //parent of node at k is at k/2
        }
    }
    private void sink(int k)
    {
        while(2*k <= N)
        {
            int j = 2*k;
            if(j < N && less(j, j+1))   j++;        //children of node at k are 2k and 2k+1
            if(!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j)
    { return pq[i].compareTo(pq[j]) < 0; }
    private void exch(int i, int j)     //array helper functions
    { Key t = pq[i]; pq[i] = pq[j]; pq[j] = t; }
}
