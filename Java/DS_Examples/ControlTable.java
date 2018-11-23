import java.util.HashMap;
import java.util.Map;
 
public class ControlTable
{
    private Map<String,Integer> controlTable;
 
    public ControlTable()
    {
        controlTable = new HashMap<String,Integer>(); 
        populateTable();
    }
 
    public int[] controlTable(int[] asciiCodes)
    {
        int[] index = new int[asciiCodes.length];
        for (int val = 0; val < asciiCodes.length; val++)
        {
            index[val] = controlTable.get(Integer.toHexString(asciiCodes[val]));
        }
        return index;
    }
 
    private void populateTable()
    {
        controlTable.put(Integer.toHexString(65), 01);
        controlTable.put(Integer.toHexString(68), 04);
        controlTable.put(Integer.toHexString(77), 03);
        controlTable.put(Integer.toHexString(83), 02);
    }
 
    public static void main (String...arg)
    {
        int[] asciiCodes = new int[4];
        int[] tableOutput;
        asciiCodes [0] = (int) 'A';
        asciiCodes [1] = (int) 'D';
        asciiCodes [2] = (int) 'M';
        asciiCodes [3] = (int) 'S';
 
        ControlTable controlTable = new ControlTable();
        tableOutput = controlTable.controlTable(asciiCodes);
 
        System.out.println("Input values ");
        System.out.print("( ");
        for (int i = 0; i < asciiCodes.length; i++)
        {
            System.out.print((char)asciiCodes[i] + " ");	
        }
        System.out.print(")\n");
 
        System.out.println("New Index from Control table");
        System.out.print("( ");
        for (int i = 0; i < tableOutput.length; i++)
        {
            System.out.print(tableOutput[i] + " ");
        }
        System.out.print(")");
    } 	
}