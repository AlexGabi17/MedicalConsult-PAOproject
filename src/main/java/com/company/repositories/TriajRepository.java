package com.company.repositories;

import com.company.config.DatabaseConfiguration;
import com.company.entities.Diagnostic;
import com.company.entities.Triaj;
import com.company.services.AuditService;

import java.sql.*;

public class TriajRepository {
    private AuditService auditService = AuditService.getInstance();
    private static TriajRepository singleInstance = null;

    private TriajRepository(){

    }

    public static TriajRepository getInstance()
    {
        if (singleInstance == null)
            singleInstance = new TriajRepository();

        return singleInstance;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS triaj " +
                "(id int PRIMARY KEY AUTO_INCREMENT," +
                "sefTriaj varchar(60))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSql);
            auditService.writeAudit("create Table", "triaj", 0 );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTriaj(Triaj triaj) {
        String insertPersonSql = "INSERT INTO triaj(sefTriaj) VALUES( '"  + triaj.getSefTriaj() + "')";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) { //try with resources
            stmt.executeUpdate(insertPersonSql); // returns no of altered lines
            auditService.writeAudit("insert", "triaj", 1 );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseConfiguration.closeDatabaseConnection();

    }

    public void displayTriajById(int Id) {
        String selectSql = "SELECT * FROM triaj WHERE ID=" + Id ;

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) { //try with resources
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next()) {
                System.out.println("Id:" + resultSet.getString(1));
                System.out.println("sefTriaj:" + resultSet.getString(2));


                System.out.printf("\n");
            }
            auditService.writeAudit("getById", "triaj", 0);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseConfiguration.closeDatabaseConnection();

    }

    public void displayDiagnostics() {
        String selectSql = "SELECT * FROM triaj" ;

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) { //try with resources
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next()) {
                System.out.println("Id:" + resultSet.getString(1));
                System.out.println("sefTriaj:" + resultSet.getString(2));

                System.out.printf("\n");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        auditService.writeAudit("getAll", "triaj", 0);

        DatabaseConfiguration.closeDatabaseConnection();

    }

    public void updateSefTriaj(String sefTriaj, int id) {
        String updateNameSql = "UPDATE triaj SET sefTriaj=? WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, sefTriaj);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
            auditService.writeAudit("updateSefTriaj", "triaj", 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseConfiguration.closeDatabaseConnection();

    }

    public void deleteById(int id) {
        String updateNameSql = "DELETE FROM triaj WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            auditService.writeAudit("delete", "triaj", -1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseConfiguration.closeDatabaseConnection();

    }

}
