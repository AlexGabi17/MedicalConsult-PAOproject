package com.company.services;

import com.company.entities.Triaj;
import com.company.interfaces.ITriaj;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TriajService implements ITriaj, Serializable {

    private AuditService auditService = AuditService.getInstance();


    private static TriajService single_instance = null;

    private TriajService(){

    }

    public static TriajService getInstance()
    {
        if (single_instance == null) {
            single_instance = new TriajService();
        }
        return single_instance;
    }

    private static final String CSV_SEPARATOR = ",";


    @Override
    public String getSefTriaj(Triaj obj) {
        return obj.getSefTriaj();
    }



    @Override
    public String toString(Triaj triaj) {
        return "Triaj{" +
                "number='" + triaj.getNumber() + "\'" +
                "hasBed='" + triaj.getSefTriaj() +
                "'}";
    }

    @Override
    public void writeTriaj(List<Triaj> productList) {
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
            for (Triaj triaj: productList)
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
            auditService.writeAudit("insertion", "Triaj", productList.size());

        }
        catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }

    @Override
    public List<Triaj> readTriaj() {
        BufferedReader br = null;
        try
        {
            //Reading the csv file
            br = new BufferedReader(new FileReader("triaj.csv"));

            //Create List for holding Employee objects
            List<Triaj> empList = new ArrayList<com.company.entities.Triaj>();

            String line = "";
            //Read to skip the header
            br.readLine();
            //Reading from the second line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(CSV_SEPARATOR);

                if (data.length > 0) {
                    //Save the employee details in Employee object
                    Triaj obj = new Triaj(Integer.parseInt(data[0]),
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
            auditService.writeAudit("read", "Triaj", 0);

            return (ArrayList<Triaj>)empList;
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
