public class BlackList
{
    public static void main(String[] args)
    {
        SET<String> set = new SET<String>();    //create empty set of strings

        In in = new In(args[0]);
        while(!in.isEmpty())        //read in whitelist
            set.add(in.readString());

        while(!StdIn.isEmpty())
        {
            String word = StdIn.readString();
            if(!set.contains(word))      //print words not in list
                StdOut.println(word);
        }
    }
}
