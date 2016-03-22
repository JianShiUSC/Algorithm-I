//in iteration i, pick integer r between 0 and i uniformly at random.
//Swap a[i] and a[r].
public class StdRandom
{
    ...
    public static void shuffle(Object[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        {
            int r = StdRandom.uniform(i + 1);   //between 0 and i
            exch(a, i, r);
        }
    }
}
