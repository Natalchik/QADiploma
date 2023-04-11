package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLRequests {
        private static final QueryRunner runner = new QueryRunner();
        private static final Connection conn = getConnection();

        public static Connection getConnection() {
            try {
                return DriverManager.getConnection(System.getProperty("db.url"), System.getProperty("db.user"), System.getProperty("db.password"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public static void clearTables() {
            QueryRunner runner = new QueryRunner();

            String clearCreditRequestTableQuery = "DELETE FROM credit_request_entity;";
            String clearOrderTableQuery = "DELETE FROM order_entity;";
            String clearPaymentTableQuery = "DELETE FROM payment_entity;";

            try (
                    Connection conn = DriverManager.getConnection(
                            System.getProperty("db.url"),
                            System.getProperty("db.user"),
                            System.getProperty("db.pass")
                    )
            ) {
                runner.update(conn, clearCreditRequestTableQuery);
                runner.update(conn, clearOrderTableQuery);
                runner.update(conn, clearPaymentTableQuery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @SneakyThrows
        public static String getStatusByCard() {
            String status = "SELECT status FROM payment_entity ORDER BY created DESC";
            return runner.query(conn, status, new ScalarHandler<>());
            }

        @SneakyThrows
        public static String getStatusByCredit() {
            String status = "SELECT status FROM credit_request_entity ORDER BY created DESC";
            return runner.query(conn, status, new ScalarHandler<>());
            }

    }


