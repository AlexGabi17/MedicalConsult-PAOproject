package com.company.services;

import com.company.entities.Asigurare;
import com.company.interfaces.IAudit;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AuditService implements IAudit, Serializable {
    private static AuditService singleInstance = null;

    private AuditService(){

    }

    public static AuditService getInstance()
    {
        if (singleInstance == null)
            singleInstance = new AuditService();

        return singleInstance;
    }

    private static final String CSV_SEPARATOR = ",";
    @Override
    public void writeAudit(String command,String entityType, int numberOfInsertions)
    {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("audit.csv", true), "UTF-8"));
            //verify if header exist
            BufferedReader br = new BufferedReader(new FileReader("audit.csv"));
            if (br.readLine() == null)
            {
                StringBuffer headers = new StringBuffer();
                headers.append("command,entityType,numberOfInsertions,date"); //comanda -> insertie/citire
                bw.write(headers.toString());
                bw.newLine();
            }
            //

            StringBuffer oneLine = new StringBuffer();
            oneLine.append(command);
            oneLine.append(CSV_SEPARATOR);
            oneLine.append(entityType);
            oneLine.append(CSV_SEPARATOR);
            oneLine.append(numberOfInsertions);
            oneLine.append(CSV_SEPARATOR);
            oneLine.append( Calendar.getInstance().getTime() );
            bw.write(oneLine.toString());

            bw.newLine();
            bw.flush();
            bw.close();
        }
        catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }


}
