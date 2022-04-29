package com.company.services;

import com.company.entities.Cabinet;
import com.company.interfaces.Triaj;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TriajService implements Triaj, Serializable {

    private static TriajService single_instance = null;

    public static TriajService getInstance()
    {
        if (single_instance == null) {
            single_instance = new TriajService();
        }
        return single_instance;
    }

    private static final String CSV_SEPARATOR = ",";


    @Override
    public String getSefTriaj(com.company.entities.Triaj obj) {
        return obj.getSefTriaj();
    }



    @Override
    public String toString(com.company.entities.Triaj triaj) {
        return "Triaj{" +
                "number='" + triaj.getNumber() + "\'" +
                "hasBed='" + triaj.getSefTriaj() +
                "'}";
    }

    @Override
    public void writeTriaj(ArrayList<com.company.entities.Triaj> productList) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("triaj.csv", true), "UTF-8"));
            //verify if header exist
            BufferedReader br = new BufferedReader(new FileReader("triaj.csv"));
            if (br.readLine() == null)
            {
                StringBuffer headers = new StringBuffer();
                headers.append("number,sefTriaj");
                bw.write(headers.toString());
                bw.newLine();
            }
            //
            for (com.company.entities.Triaj triaj: productList)
            {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(triaj.getNumber());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(triaj.getNumber());
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        }
        catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }

    @Override
    public ArrayList<com.company.entities.Triaj> readTriaj() {
        BufferedReader br = null;
        try
        {
            //Reading the csv file
            br = new BufferedReader(new FileReader("triaj.csv"));

            //Create List for holding Employee objects
            List<com.company.entities.Triaj> empList = new ArrayList<com.company.entities.Triaj>();

            String line = "";
            //Read to skip the header
            br.readLine();
            //Reading from the second line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(CSV_SEPARATOR);

                if (data.length > 0) {
                    //Save the employee details in Employee object
                    com.company.entities.Triaj obj = new com.company.entities.Triaj(Integer.parseInt(data[0]),
                            data[1]
                    );
                    empList.add(obj);
                }
            }
            //Lets print the Employee List
            for(com.company.entities.Triaj e : empList)
            {
                System.out.println(e.getNumber()+"   "+e.getSefTriaj());
            }
            return (ArrayList<com.company.entities.Triaj>)empList;
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        finally {
            try {
                br.close();
            } catch (IOException ie) {
                System.out.println("Error occured while closing the BufferedReader");
                ie.printStackTrace();
            }
        }
        return null;
    }
}
