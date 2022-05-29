package com.company.repositories;

import com.company.config.DatabaseConfiguration;
import com.company.entities.Asigurare;
import com.company.services.AsigurareService;
import com.company.services.AuditService;

import java.sql.*;

public class AsigurareRepository {

    private AuditService auditService = AuditService.getInstance();
    private static AsigurareRepository singleInstance = null;

    private AsigurareRepository(){

    }

    public static AsigurareRepository getInstance()
    {
        if (singleInstance == null)
            singleInstance = new AsigurareRepository();

        return singleInstance;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS asigurare " +
                "(id int PRIMARY KEY AUTO_INCREMENT," +
                "tipAsigurare varchar(60)," +
                "numeCasaSanatate varchar(60)," +
                "dataExpirare varchar(60))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSql);
            auditService.writeAudit("create Table", "asigurare", 0 );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAsigurare(Asigurare asigurare) {
        String insertPersonSql = "INSERT INTO asigurare(tipAsigurare, numeCasaSanatate, dataExpirare) VALUES( '"  + asigurare.getTipAsigurare() + "', '" + asigurare.getNumeCasaSanatate() + "' , '" + asigurare.getDataExpirare() + "')";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) { //try with resources
            stmt.executeUpdate(insertPersonSql); // returns no of altered lines
            auditService.writeAudit("insert", "asigurare", 1 );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayAsigurareById(int Id) {
        String selectSql = "SELECT * FROM asigurare WHERE ID=" + Id ;

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) { //try with resources
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next()) {
                System.out.println("Id:" + resultSet.getString(1));
                System.out.println("tipAsigurare:" + resultSet.getString(2));
                System.out.println("numeCasaAsigurare:" + resultSet.getString(3));
                System.out.println("dataExpirare:" + resultSet.getString(4));
                System.out.printf("\n");
            }
            auditService.writeAudit("getById", "asigurare", 0);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseConfiguration.closeDatabaseConnection();
    }

    public void displayAsigurari() {
        String selectSql = "SELECT * FROM asigurare" ;

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) { //try with resources
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next()) {
                System.out.println("Id:" + resultSet.getString(1));
                System.out.println("tipAsigurare:" + resultSet.getString(2));
                System.out.println("numeCasaAsigurare:" + resultSet.getString(3));
                System.out.println("dataExpirare:" + resultSet.getString(4));
                System.out.println("\n");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        auditService.writeAudit("getAll", "asigurare", 0);

        DatabaseConfiguration.closeDatabaseConnection();

    }

    public void updateAsigurareTip(String tip, int id) {
        String updateNameSql = "UPDATE asigurare SET tipAsigurare=? WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, tip);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
            auditService.writeAudit("updateTip", "asigurare", 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseConfiguration.closeDatabaseConnection();

    }

    public void updateAsigurareNumeCasaSanatate(String nume, int id) {
        String updateNameSql = "UPDATE asigurare SET numeCasaSanatate=? WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, nume);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
            auditService.writeAudit("updateCasaSanatate", "asigurare", 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseConfiguration.closeDatabaseConnection();

    }

    public void updateAsigurareDataExpirare(String dataExpirare, int id) {
        String updateNameSql = "UPDATE asigurare SET dataExpirare=? WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, dataExpirare);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
            auditService.writeAudit("updateDataExpirare", "asigurare", 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseConfiguration.closeDatabaseConnection();

    }

    public void deleteById(int id) {
        String updateNameSql = "DELETE FROM asigurare WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            auditService.writeAudit("delete", "asigurare", -1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseConfiguration.closeDatabaseConnection();

    }

}
