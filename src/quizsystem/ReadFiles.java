/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizsystem;

/**
 *
 * @author Meeth
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Meeth
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * class to read files
 *
 * @author Meeth
 */
public class ReadFiles {

    private ArrayList<String> rows = new ArrayList();
    private ArrayList<String[]> data = new ArrayList();

    /**
     * file path
     */
    public String filepath = "";

    /**
     * returns data of the files
     *
     * @return
     */
    public ArrayList<String[]> getColumns() {
        return data;
    }

    /**
     * sets the data of the file in the list
     *
     * @param columns
     */
    public void setColumns(ArrayList<String[]> columns) {
        this.data = columns;
    }

    /**
     * method to read file
     *
     * @param filePath
     * @throws IOException
     */
    public void readFile(String filePath) throws IOException, NumberFormatException {
        FileReader filereader = new FileReader(filePath);
        StringTokenizer str;
        //BufferedReader for the file
        BufferedReader reader = new BufferedReader(filereader);
        String line;
        int i = 0;
        //Read data from a file
        while ((line = reader.readLine()) != null) {
            rows.add(i, line);
            i++;
        }

        for (i = 0; i < rows.size(); i++) {
            int j = 0;
            str = new StringTokenizer(rows.get(i), ",");
            int k = str.countTokens();
            String[] columnsArray = new String[str.countTokens()];
            while (str.hasMoreTokens()) {
                columnsArray[j] = str.nextToken();
                j++;
            }
            this.data.add(columnsArray);
        }

    }
}
