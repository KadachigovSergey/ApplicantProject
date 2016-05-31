package org.sourceit.db;

import org.sourceit.entities.SpecialitySubject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public enum  SpecialitySubjectDBProvider {
    INSTANCE;

    private Connection connection;

    SpecialitySubjectDBProvider() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_applicant", "root",
                    "FCNHJYJVJgbntr531");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Class not found: com.mysql.jdbc.Driver " + e);
            throw new RuntimeException("Class not found: com.mysql.jdbc.Driver");
        }
    }

    public SpecialitySubject getSpecialitySubject(long specialitySubjectId) throws Exception {

        PreparedStatement preparedStatement = null;
        SpecialitySubject specialitySubject = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM SPECIALITY_SUBJECT WHERE SP_SB_ID=?");
            preparedStatement.setInt(1, (int) specialitySubjectId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                specialitySubject = new SpecialitySubject();
                specialitySubject.setId(resultSet.getInt("SP_SB_ID"));
                specialitySubject.setProfessionId(resultSet.getLong("Profession_ID"));
                specialitySubject.setSubjectId(resultSet.getLong("Subject_Id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return specialitySubject;
    }

    public List<SpecialitySubject> getSpecialitySubjects() throws Exception {

        Statement statement;
        List<SpecialitySubject> specialitySubjects = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM SPECIALITY_SUBJECT JOIN( profession,subject) " +
                    "ON SPECIALITY_SUBJECT.PROFESSION_ID=profession.PROFESSION_ID " +
                    "and SPECIALITY_SUBJECT.SUBJECT_ID=SUBJECT.SUBJECT_ID" );
            SpecialitySubject specialitySubject;
            while (resultSet.next()) {
                specialitySubject = new SpecialitySubject();
                specialitySubject.setProfessionId(resultSet.getInt("profession_id"));
                specialitySubject.setProfessionName(resultSet.getString("profession_name"));
                specialitySubject.setSubjectId(resultSet.getInt("subject_id"));
                specialitySubject.setSubjectName(resultSet.getString("subject_name"));
                specialitySubject.setId(resultSet.getInt("SP_SB_ID"));
                specialitySubjects.add(specialitySubject);
            }
        } catch (SQLException e) {
            throw new Exception(e);
        }
        return specialitySubjects;
    }

    public void saveSpecialitySubject(SpecialitySubject specialitySubject) throws Exception {

        PreparedStatement preparedStatement = null;
        try {
            if (specialitySubject.getId() == -1) {
                preparedStatement = connection.prepareStatement("INSERT INTO SPECIALITY_SUBJECT (PROFESSION_ID" +
                        ",SUBJECT_ID) VALUES (?, ?) ");
                preparedStatement.setInt(1,(int) specialitySubject.getProfessionId());
                preparedStatement.setInt(2,(int) specialitySubject.getSubjectId());

            } else {
                preparedStatement = connection.prepareStatement("UPDATE SPECIALITY_SUBJECT SET PROFESSION_ID=?," +
                        " SUBJECT_ID=? WHERE SP_SB_ID=?");
                preparedStatement.setLong(1, specialitySubject.getProfessionId());
                preparedStatement.setLong(2, specialitySubject.getSubjectId());
                preparedStatement.setInt(3, (int)(long)specialitySubject.getId());
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

    public void deleteSpecialitySubject(long specialitySubjectId) throws Exception {

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM SPECIALITY_SUBJECT WHERE SP_SB_id=?");

            preparedStatement.setInt(1, (int) specialitySubjectId);
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
