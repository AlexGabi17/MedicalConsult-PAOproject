package com.company.repositories;

import com.company.config.DatabaseConfiguration;
import com.company.entities.Cabinet;
import com.company.entities.Diagnostic;
import com.company.services.AuditService;

import java.sql.*;

public class CabinetRepository {
    private AuditService auditService = AuditService.getInstance();
    private static CabinetRepository singleInstance = null;

    private CabinetRepository(){

    }

    public static CabinetRepository getInstance()
    {
        if (singleInstance == null)
            singleInstance = new CabinetRepository();

        return singleInstance;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS cabinet " +
                "(id int PRIMARY KEY AUTO_INCREMENT," +
                "hasBed BOOLEAN)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSql);
            auditService.writeAudit("create Table", "cabinet", 0 );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCabinet(Cabinet cabinet) {
        String insertPersonSql = "INSERT INTO cabinet(hasBed) VALUES( "  + cabinet.getHasBed() + ")";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) { //try with resources
            stmt.executeUpdate(insertPersonSql); // returns no of altered lines
            auditService.writeAudit("insert", "cabinet", 1 );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseConfiguration.closeDatabaseConnection();

    }

    public void displayCabinetById(int Id) {
        String selectSql = "SELECT * FROM cabinet WHERE ID=" + Id ;

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) { //try with resources
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next()) {
                System.out.println("Id:" + resultSet.getString(1));
                System.out.println("cabinet:" + resultSet.getBoolean(2));

                System.out.printf("\n");
            }
            auditService.writeAudit("getById", "cabinet", 0);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseConfiguration.closeDatabaseConnection();

    }

    public void displayDiagnostics() {
        String selectSql = "SELECT * FROM cabinet" ;

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) { //try with resources
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next()) {
                System.out.println("Id:" + resultSet.getString(1));
                System.out.println("cabinet:" + resultSet.getBoolean(2));

                System.out.printf("\n");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        auditService.writeAudit("getAll", "cabinet", 0);

        DatabaseConfiguration.closeDatabaseConnection();

    }

    public void updateHasBed(boolean hasBed, int id) {
        String updateNameSql = "UPDATE cabinet SET hasBed=? WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setBoolean(1, hasBed);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
            auditService.writeAudit("updateHasBed", "cabinet", 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseConfiguration.closeDatabaseConnection();

    }

    public void deleteById(int id) {
        String updateNameSql = "DELETE FROM cabinet WHERE id=?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            auditService.writeAudit("delete", "cabinet", -1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseConfiguration.closeDatabaseConnection();

    }

}
