public class SparseVector
{
    private HashST<Integer, Double> v;                  //HashST because order not important

    public SparseVector()
    { v = new HashST<Integer, Double>(); }              //empty ST represents all 0s vector

    public void put(int i, double x)
    { v.put(i, x); }                                    //a[i] = value

    public double get(int i)
    {
        if(!v.contains(i)) return 0.0;
        else return v.get(i);                           //return a[i]
    }

    public Iterable<Integer> indices()
    { return v.keys(); }

    public double dot(double[] that)
    {
        double sum = 0.0;                               //dot product is constant time for sparse vectors
        for (int i : indices())
            sum += that[i]*this.get(i);
        return sum;
    }
}
