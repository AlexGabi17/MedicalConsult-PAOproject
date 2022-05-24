package com.company.services;

import com.company.entities.Diagnostic;
import com.company.interfaces.IDiagnostic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DiagnosticService implements IDiagnostic, Serializable {

    private AuditService auditService = AuditService.getInstance();


    private static DiagnosticService single_instance = null;

    private DiagnosticService(){

    }

    public static DiagnosticService getInstance()
    {
        if (single_instance == null)
            single_instance = new DiagnosticService();

        return single_instance;
    }

    @Override
    public String toString(Diagnostic diagnostic){
        return "Diagnostic{" +
                "urgenta='" + diagnostic.getUrgenta() + '\''+
                ",  diagnostic='" + diagnostic.getDiagnostic() +
                '}';
    }



    private static final String CSV_SEPARATOR = ",";
    @Override
    public void writeDiagnostic(List<Diagnostic> productList)
    {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("diagnostice.csv", true), "UTF-8"));
            //verify if header exist
            BufferedReader br = new BufferedReader(new FileReader("diagnostice.csv"));
            if (br.readLine() == null)
            {
                StringBuffer headers = new StringBuffer();
                headers.append("urgenta,diagnostic");
                bw.write(headers.toString());
                bw.newLine();
            }
            //
            for (Diagnostic diagnostic : productList)
            {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(diagnostic.getUrgenta());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(diagnostic.getDiagnostic());
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();

            auditService.writeAudit("insertion", "Diagnostic", productList.size());


        }
        catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }
    @Override
    public List<Diagnostic> readDiagnostic()
    {
        //Delimiters used in the CSV file


        BufferedReader br = null;
        try
        {
            //Reading the csv file
            br = new BufferedReader(new FileReader("diagnostice.csv"));

            //Create List for holding Employee objects
            List<Diagnostic> empList = new ArrayList<Diagnostic>();

            String line = "";
            //Read to skip the header
            br.readLine();
            //Reading from the second line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(CSV_SEPARATOR);

                if (data.length > 0) {
                    //Save the employee details in Employee object
                    Diagnostic obj = new Diagnostic(Integer.parseInt(data[0]),
                            data[1]);
                    empList.add(obj);
                }
            }
            //Lets print the Employee List
            for(Diagnostic e : empList)
            {
                System.out.println(e.getUrgenta()+"   "+e.getDiagnostic());
            }
            auditService.writeAudit("read", "Diagnostic", 0);

            return (ArrayList<Diagnostic>)empList;
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
