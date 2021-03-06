package org.sourceit.db;

import org.sourceit.entities.ApplicantResult;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public enum  ApplicantResultDBProvider {
    INSTANCE;
    private Connection connection;

    ApplicantResultDBProvider() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_applicant", "root",
                    "FCNHJYJVJgbntr531");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Class not found: com.mysql.jdbc.Driver " + e);
            throw new RuntimeException("Class not found: com.mysql.jdbc.Driver");
        }
    }

    public ApplicantResult getApplicantResult(long applicantResultID) throws Exception {
        PreparedStatement preparedStatement = null;
        ApplicantResult applicantResult = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM APPLICANT_RESULT " +
                    "WHERE APPLICANT_RESULT_id=?");
            preparedStatement.setInt(1, (int) applicantResultID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                applicantResult = new ApplicantResult();
                applicantResult.setId(resultSet.getInt("applicant_result_id"));
                applicantResult.setApplicantId(resultSet.getLong("applicant_id"));
                applicantResult.setSubjectId(resultSet.getLong("subject_id"));
                applicantResult.setMark(resultSet.getInt("mark"));
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

    public List<ApplicantResult> getApplicantResults() throws Exception {

        Statement statement;
        List<ApplicantResult> applicantResults = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM APPLICANT_RESULT " +
                    "JOIN (APPLICANT,SUBJECT) ON APPLICANT_RESULT.APPLICANT_ID=APPLICANT.APPLICANT_ID " +
                    "AND APPLICANT_RESULT.SUBJECT_ID=SUBJECT.SUBJECT_ID");
            ApplicantResult applicantResult;
            while (resultSet.next()) {
                applicantResult = new ApplicantResult();
                applicantResult.setId(resultSet.getInt("APPLICANT_RESULT_ID"));
                applicantResult.setApplicantId(resultSet.getLong("APPLICANT_ID"));
                applicantResult.setApplicantName(resultSet.getString("LAST_NAME"));
                applicantResult.setSubjectName(resultSet.getString("SUBJECT_NAME"));
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
                preparedStatement = connection.prepareStatement("INSERT INTO APPLICANT_RESULT" +
                        " (APPLICANT_ID, SUBJECT_ID, MARK) VALUES (?, ?, ?) ");
                preparedStatement.setLong(1, applicantResult.getApplicantId());
                preparedStatement.setLong(2, applicantResult.getSubjectId());
                preparedStatement.setInt(3, applicantResult.getMark());
            } else {
                System.out.println("update APPLICANT RESULT result");
                preparedStatement = connection.prepareStatement("UPDATE APPLICANT_RESULT" +
                        " SET APPLICANT_ID=?, SUBJECT_ID=?, MARK=? WHERE APPLICANT_RESULT_ID=?");
                preparedStatement.setLong(1, applicantResult.getApplicantId());
                preparedStatement.setLong(2, applicantResult.getSubjectId());
                preparedStatement.setInt(3, applicantResult.getMark());
                preparedStatement.setInt(4, (int) (long) applicantResult.getId());
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

    public void deleteApplicantResult(long applicantResultId) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM APPLICANT_RESULT WHERE APPLICANT_RESULT_ID=?");

            preparedStatement.setInt(1, (int) applicantResultId);
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
