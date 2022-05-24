package com.company.repositories;

import com.company.config.DatabaseConfiguration;
import com.company.entities.Asigurare;
import com.company.entities.Diagnostic;
import com.company.services.AsigurareService;
import com.company.services.AuditService;

import java.sql.*;

public class DiagnosticRepository {

    private AuditService auditService = AuditService.getInstance();
    private static DiagnosticRepository singleInstance = null;

    private DiagnosticRepository(){

    }

    public static DiagnosticRepository getInstance()
    {
        if (singleInstance == null)
            singleInstance = new DiagnosticRepository();

        return singleInstance;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS diagnostic " +
                "(id int PRIMARY KEY AUTO_INCREMENT," +
                "urgenta int," +
                "diagnostic varchar(60))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSql);
            auditService.writeAudit("create Table", "diagnostic", 0 );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDiagnostic(Diagnostic diagnostic) {
        String insertPersonSql = "INSERT INTO diagnostic(urgenta, diagnostic) VALUES( '"  + diagnostic.getUrgenta() + "', '" + diagnostic.getDiagnostic() + "')";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) { //try with resources
            stmt.executeUpdate(insertPersonSql); // returns no of altered lines
            auditService.writeAudit("insert", "diagnostic", 1 );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseConfiguration.closeDatabaseConnection();

    }

    public void displayDiagnosticById(int Id) {
        String selectSql = "SELECT * FROM diagnostic WHERE ID=" + Id ;

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) { //try with resources
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next()) {
                System.out.println("Id:" + resultSet.getString(1));
                System.out.println("urgenta:" + resultSet.getInt(2));
                System.out.println("diagnostic:" + resultSet.getString(3));

                System.out.printf("\n");
            }
            auditService.writeAudit("getById", "diagnostic", 0);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseConfiguration.closeDatabaseConnection();

    }

    public void displayDiagnostics() {
        String selectSql = "SELECT * FROM diagnostic" ;

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) { //try with resources
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next()) {
                System.out.println("Id:" + resultSet.getString(1));
                System.out.println("urgenta:" + resultSet.getInt(2));
                System.out.println("diagnostic:" + resultSet.getString(3));

                System.out.printf("\n");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        auditService.writeAudit("getAll", "diagnostic", 0);

        DatabaseConfiguration.closeDatabaseConnection();

    }

    public void updateDiagnosticUrgenta(int urgenta, int id) {
        String updateNameSql = "UPDATE diagnostic SET urgenta=? WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setInt(1, urgenta);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
            auditService.writeAudit("updateUrgenta", "diagnostic", 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseConfiguration.closeDatabaseConnection();

    }

    public void updateDiagnostic(String diagnostic, int id) {
        String updateNameSql = "UPDATE diagnostic SET diagnostic=? WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, diagnostic);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
            auditService.writeAudit("updateDiagnostic", "diagnostic", 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseConfiguration.closeDatabaseConnection();

    }


}
