package com.company.services;

import com.company.interfaces.Asigurare;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AsigurareService implements Asigurare, Serializable {

    private static AsigurareService single_instance = null;

    public static AsigurareService getInstance()
    {
        if (single_instance == null)
            single_instance = new AsigurareService();

        return single_instance;
    }

    @Override
    public int getId(com.company.entities.Asigurare obj) {
        return obj.getId();
    }

    @Override
    public String getTipAsigurare(com.company.entities.Asigurare obj) {
        return obj.getTipAsigurare();
    }

    @Override
    public String getNumeCasaSanatate(com.company.entities.Asigurare obj) {
        return obj.getNumeCasaSanatate();
    }

    @Override
    public String getDataExpirare(com.company.entities.Asigurare obj) {
        return obj.getDataExpirare();
    }

    @Override
    public void changeTipAsigurare(com.company.entities.Asigurare obj, String tip) {
        obj.setTipAsigurare(tip);
    }

    @Override
    public void changeNumeCasaSanatate(com.company.entities.Asigurare obj, String casa){
        obj.setNumeCasaSanatate(casa);
    }

    @Override
    public void changeDataExpirare(com.company.entities.Asigurare obj, String dataExpirare){
        obj.setDataExpirare(dataExpirare);
    }

    @Override
    public String toString(com.company.entities.Asigurare asigurare){
        return "Asigurare{" +
                "id='" + asigurare.getId() + '\''+
                ",  tipAsigurare='" + asigurare.getTipAsigurare() +'\''+
                ",  numeCasaSanatate='" + asigurare.getNumeCasaSanatate() +'\''+
                ",  dataExpirare='" + asigurare.getDataExpirare() +
                "'}";
    }

    private static final String CSV_SEPARATOR = ",";
    @Override
    public void writeAsigurari(ArrayList<com.company.entities.Asigurare> productList)
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
    public void readAsigurari()
    {
        //Delimiters used in the CSV file


        BufferedReader br = null;
        try
        {
            //Reading the csv file
            br = new BufferedReader(new FileReader("asigurari.csv"));

            //Create List for holding Employee objects
            List<com.company.entities.Asigurare> empList = new ArrayList<com.company.entities.Asigurare>();

            String line = "";
            //Read to skip the header
            br.readLine();
            //Reading from the second line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(CSV_SEPARATOR);

                if (data.length > 0) {
                    //Save the employee details in Employee object
                    com.company.entities.Asigurare obj = new com.company.entities.Asigurare(Integer.parseInt(data[0]),
                            data[1],
                            data[2],
                            data[3]);
                    empList.add(obj);
                }
            }
            //Lets print the Employee List
            for(com.company.entities.Asigurare e : empList)
            {
                System.out.println(e.getId()+"   "+e.getTipAsigurare() + " " +e.getNumeCasaSanatate() + e.getDataExpirare());
            }
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
    }

}
