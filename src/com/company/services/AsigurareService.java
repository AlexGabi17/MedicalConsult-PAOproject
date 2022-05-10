package com.company.services;

import com.company.entities.Asigurare;
import com.company.interfaces.IAsigurare;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AsigurareService implements IAsigurare, Serializable {

    private static AsigurareService singleInstance = null;

    private AsigurareService(){

    }

    public static AsigurareService getInstance()
    {
        if (singleInstance == null)
            singleInstance = new AsigurareService();

        return singleInstance;
    }

    @Override
    public String toString(Asigurare asigurare){
        return "Asigurare{" +
                "id='" + asigurare.getId() + '\''+
                ",  tipAsigurare='" + asigurare.getTipAsigurare() +'\''+
                ",  numeCasaSanatate='" + asigurare.getNumeCasaSanatate() +'\''+
                ",  dataExpirare='" + asigurare.getDataExpirare() +
                "'}";
    }

    private static final String CSV_SEPARATOR = ",";
    @Override
    public void writeAsigurari(List<Asigurare> productList)
    {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("asigurari.csv", true), "UTF-8"));
            //verify if header exist
            BufferedReader br = new BufferedReader(new FileReader("asigurari.csv"));
            if (br.readLine() == null)
            {
                StringBuffer headers = new StringBuffer();
                headers.append("id,TipAsigurare,NumeCasaSanatate,DataExpirare");
                bw.write(headers.toString());
                bw.newLine();
            }
            //
            for (com.company.entities.Asigurare asigurari: productList)
            {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(asigurari.getId());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(asigurari.getTipAsigurare());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(asigurari.getNumeCasaSanatate());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(asigurari.getDataExpirare());
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
    public List<Asigurare> readAsigurari()
    {
        //Delimiters used in the CSV file


        BufferedReader br = null;
        try
        {
            //Reading the csv file
            br = new BufferedReader(new FileReader("asigurari.csv"));

            //Create List for holding Employee objects
            List<Asigurare> empList = new ArrayList<com.company.entities.Asigurare>();

            String line = "";
            //Read to skip the header
            br.readLine();
            //Reading from the second line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(CSV_SEPARATOR);

                if (data.length > 0) {
                    //Save the employee details in Employee object
                    Asigurare obj = new Asigurare(Integer.parseInt(data[0]),
                            data[1],
                            data[2],
                            data[3]);
                    empList.add(obj);
                }
            }
            //Lets print the Employee List
            for(Asigurare e : empList)
            {
                System.out.println(e.getId()+"   "+e.getTipAsigurare() + " " +e.getNumeCasaSanatate() + e.getDataExpirare());
            }
            return (ArrayList<Asigurare>) empList;
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
