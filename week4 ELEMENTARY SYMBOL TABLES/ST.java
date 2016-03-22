public class ST<Key, Value>
{
    private Key[] keys;
    private Value[] vals;
    
    public void put(Key key, Value val)

    public Value get(Key key)
    {
        if(isEmpty())   return null;
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0)    return vals[i];
        else return null;
    }

    private int rank(Key key)
    {
        int lo = 0, hi = N-1;
        while(lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if      (cmp  < 0)  hi = mid - 1;
            else if (cmp  > 0)  lo = mid + 1;
            else if (cmp == 0)  return mid;
        }
        return lo;
    }

    public boolean contains(Key key)
    { return get(key) != null; }

    public void delete(Key key)
    { put(key, null); }

    public boolean isEmpty()

    public int size()
}



//stay tuned
