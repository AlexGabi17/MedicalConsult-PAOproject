package com.company.services;

import com.company.entities.Diagnostic;
import com.company.interfaces.Cabinet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CabinetService implements com.company.interfaces.Cabinet, Serializable {
    private static CabinetService single_instance = null;

    public static CabinetService getInstance()
    {
        if (single_instance == null)
            single_instance = new CabinetService();

        return single_instance;
    }

    @Override
    public String toString(com.company.entities.Cabinet cabinet) {
        return "Cabinet{" +
                "number='" + cabinet.getNumber() + "\'" +
                "hasBed='" + cabinet.getHasBed() +
                "'}";
    }

    private static final String CSV_SEPARATOR = ",";


    @Override
    public void writeCabinete(ArrayList<com.company.entities.Cabinet> productList) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("cabinete.csv", true), "UTF-8"));
            //verify if header exist
            BufferedReader br = new BufferedReader(new FileReader("cabinete.csv"));
            if (br.readLine() == null)
            {
                StringBuffer headers = new StringBuffer();
                headers.append("number,hasBed");
                bw.write(headers.toString());
                bw.newLine();
            }
            //
            for (com.company.entities.Cabinet cabinet: productList)
            {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(cabinet.getNumber());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(cabinet.getHasBed());
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
    public ArrayList<com.company.entities.Cabinet>  readCabinete() {
        BufferedReader br = null;
        try
        {
            //Reading the csv file
            br = new BufferedReader(new FileReader("cabinete.csv"));

            //Create List for holding Employee objects
            List<com.company.entities.Cabinet> empList = new ArrayList<com.company.entities.Cabinet>();

            String line = "";
            //Read to skip the header
            br.readLine();
            //Reading from the second line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(CSV_SEPARATOR);

                if (data.length > 0) {
                    //Save the employee details in Employee object
                    com.company.entities.Cabinet obj = new com.company.entities.Cabinet(Integer.parseInt(data[0]),
                            Boolean.parseBoolean(data[1])
                    );
                    empList.add(obj);
                }
            }
            //Lets print the Employee List
            for(com.company.entities.Cabinet e : empList)
            {
                System.out.println(e.getNumber()+"   "+e.getHasBed());
            }
            return (ArrayList<com.company.entities.Cabinet>)empList;
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
