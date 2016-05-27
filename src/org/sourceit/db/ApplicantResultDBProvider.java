package org.sourceit.db;

import org.sourceit.entities.ApplicantResult;
import org.sourceit.entities.Profession;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public enum  ApplicantResultDBProvider {
    INSTANCE;
    private Connection connection;

    ApplicantResultDBProvider() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_applicant", "root", "FCNHJYJVJgbntr531");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Class not found: com.mysql.jdbc.Driver " + e);
            throw new RuntimeException("Class not found: com.mysql.jdbc.Driver");
        }
    }

    public ApplicantResult getApplicantResult(long applicantResultID) throws Exception {
        PreparedStatement preparedStatement = null;
        ApplicantResult applicantResult = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM APPLICANT_RESULT WHERE APPLICANT_RESULT_id=?");
            preparedStatement.setInt(1, (int) applicantResultID);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                applicantResult = new ApplicantResult();
                applicantResult.setId(resultSet.getInt("APPLICANT_RESULT_ID"));
                applicantResult.setApplicantId(resultSet.getLong("APPLICANT_ID"));
                applicantResult.setSubjectId(resultSet.getLong("SUBJECT_ID"));
                applicantResult.setMark(resultSet.getInt("MARK"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return applicantResult;
    }

    public List<ApplicantResult> getApplicantResult() throws Exception {

        Statement statement = null;
        List<ApplicantResult> applicantResults = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM APPLICANT_RESULT" +
                    " JOIN profession ON applicant.PROFESSION_ID=profession.PROFESSION_ID");
            ApplicantResult applicantResult = null;
            Profession profession = null;
            while (resultSet.next()) {
                applicantResult = new ApplicantResult();
                applicantResult.setId(resultSet.getInt("APPLICANT_RESULT_ID"));
                applicantResult.setApplicantId(resultSet.getLong("APPLICANT_ID"));
                applicantResult.setSubjectId(resultSet.getLong("SUBJECT_ID"));
                applicantResult.setMark(resultSet.getInt("MARK"));
                applicantResults.add(applicantResult);
            }
        } catch (SQLException e) {
            throw new Exception(e);
        }

        return applicantResults;
    }

    public void saveApplicantResult(ApplicantResult applicantResult) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            if (applicantResult.getId() == -1) {
                System.out.println("new applicant result");
                preparedStatement = connection.prepareStatement("INSERT INTO APPLICANT_RESULT (first_name, last_name," +
                        " profession_id, entrance_year) VALUES (?, ?, ?) ");

//                preparedStatement.setString(1, applicantResult.getFirstName());
//                preparedStatement.setString(2, applicantResult.getLastName());
//                preparedStatement.setInt(3, (int) (long) applicantResult.getProfessionId());


            } else {
                System.out.println("update applicant result");
                preparedStatement = connection.prepareStatement("UPDATE applicant SET first_name=?, last_name=?," +
                        " profession_id=?, entrance_year=?  WHERE applicant_id=?");

//                preparedStatement.setString(1, applicantResult.getFirstName());
//                preparedStatement.setString(2, applicantResult.getLastName());
//                preparedStatement.setInt(3, (int) (long) applicantResult.getProfessionId());
//                preparedStatement.setInt(4, applicantResult.getEntranceYear());
//                preparedStatement.setInt(5, (int) applicantResult.getId());
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

//    public void deleteApplicantResult(long applicantId) throws Exception {
//        PreparedStatement preparedStatement = null;
//
//        try {
//            preparedStatement = connection.prepareStatement("DELETE FROM applicant WHERE applicant_id=?");
//
//            preparedStatement.setInt(1, (int) applicantId);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new Exception(e);
//        } finally {
//            if (preparedStatement != null) {
//                preparedStatement.close();
//            }
//        }
//    }

}
