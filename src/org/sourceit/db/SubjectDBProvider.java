package org.sourceit.db;

import org.sourceit.entities.Profession;
import org.sourceit.entities.Subject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public enum  SubjectDBProvider {
    INSTANCE;

    private Connection connection;

    SubjectDBProvider() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_applicant", "root", "FCNHJYJVJgbntr531");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Class not found: com.mysql.jdbc.Driver " + e);
            throw new RuntimeException("Class not found: com.mysql.jdbc.Driver");
        }
    }

    public Subject getSubject(long subjectId) throws Exception {
        PreparedStatement preparedStatement = null;
        Subject subject = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM subject WHERE subject_id=?");
            preparedStatement.setInt(1, (int) subjectId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                subject = new Subject();
                subject.setId(resultSet.getInt("subject_id"));
                subject.setSubjectName(resultSet.getString("SUBJECT_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return subject;
    }

    public List<Subject> getSubjects() throws Exception {

        Statement statement = null;
        List<Subject> subjects = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM subject");
            Subject subject = null;
            Profession profession = null;
            while (resultSet.next()) {
                subject = new Subject();
                subject.setId(resultSet.getInt("Subject_id"));
                subject.setSubjectName(resultSet.getString("Subject_name"));
                subjects.add(subject);
            }
        } catch (SQLException e) {
            throw new Exception(e);
        }

        return subjects;
    }

    public void saveSubject(Subject subject) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            if (subject.getId() == -1) {
                preparedStatement = connection.prepareStatement("INSERT INTO Subject (Subject_name) VALUES (?) ");

                preparedStatement.setString(1, subject.getSubjectName());


            } else {
                preparedStatement = connection.prepareStatement("UPDATE Subject SET Subject_name=? WHERE Subject_id=?");

                preparedStatement.setString(1, subject.getSubjectName());
                preparedStatement.setInt(2, (int) subject.getId());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void deleteSubject(long subjectId) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM Subject WHERE Subject_id=?");

            preparedStatement.setInt(1, (int) subjectId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

}
