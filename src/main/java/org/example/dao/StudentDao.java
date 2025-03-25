package org.example.dao;

import org.example.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class StudentDao {
    private String url;
    private String user;
    private String password;

    public StudentDao() {
        try (var input = getClass().getClassLoader().getResourceAsStream("postgres.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            this.url = prop.getProperty("db.url");
            this.user = prop.getProperty("db.user");
            this.password = prop.getProperty("db.password");
        } catch (Exception e) {
            throw new RuntimeException("Помилка завантаження конфігурації БД", e);
        }
    }

    public List<Student> getStudentsByMonth(int month) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students_java WHERE EXTRACT(MONTH FROM birth_date) = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, month);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("last_name"),
                        rs.getString("first_name"),
                        rs.getString("middle_name"),
                        rs.getDate("birth_date").toLocalDate(),
                        rs.getString("gradebook_number")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
