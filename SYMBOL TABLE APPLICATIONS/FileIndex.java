import java.io.File;
public class FileIndex
{
    public static void main(String[] args)
    {
        ST<String, SET<File>> st = new ST<String, SET<File>>();     //symbol table

        for (String filename : args)
        {
            File file = new File(filename);     //list of file names from command line
            In in = new In(file);
            while(!in.isEmpty())
            {
                String key = in.readString();       //for each word in file, add file to corresponding set
                if(!st.contains(key))
                    st.put(key, new SET<File>());
                SET<File> set = st.get(key);
                set.add(file);
            }
        }

        while(!StdIn.isEmpty())
        {
            String query = StdIn.readString();      //process queries
            StdOut.println(st.get(query));
        }
    }
}
