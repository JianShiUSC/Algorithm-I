public class LookupCSV
{
    public static void main(String[] args)
    {
        In in = new In(args[0]);
        int keyField = Integer.parseInt(args[1]);       //process input file
        int valField = Integer.parseInt(args[2]);

        ST<String, String> st = new ST<String, String>();
        while(!in.isEmpty())
        {
            String line = in.readLine();
            String[] tokens = line.split(",");
            String key = tokens[keyField];          //build symbol table
            String val = tokens[valField];
            st.put(key, val);
        }

        while(!StdIn.isEmpty())
        {
            String s = StdIn.readString();          //process lookups with standard I/O
            if (!st.contains(s)) StdOut.println("Not found");
            else                 StdOut.println(st.get(s));
        }
    }
}
