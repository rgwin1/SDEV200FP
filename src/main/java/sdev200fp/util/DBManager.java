package sdev200fp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import sdev200fp.model.FamilyMember;

public class DBManager {

    
    public static void insertFamilyMember(FamilyMember member) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sdev200fp";
        String user = "root";
        String password = "";
        
         String sql = "INSERT INTO members (firstName, lastName, middleName, dob, email, medicalinfo, notes, photo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
         try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, member.getFirstName());
            stmt.setString(2, member.getLastName());
            stmt.setString(3, member.getMiddleName());
            stmt.setDate(4, Date.valueOf(member.getDateOfBirth()));
            stmt.setString(5, member.getEmail());
            stmt.setString(6, member.getMedicalInfo());
            stmt.setString(7, member.getNotes());
            stmt.setString(8, member.getPhotoString());
            stmt.executeUpdate();
            
         } catch (SQLException e) {
         e.printStackTrace();
         }
    }
    
  public static List<FamilyMember> getAllFamilyMembers() {
    List<FamilyMember> members = new ArrayList<>();

    String url = "jdbc:mysql://localhost:3306/sdev200fp";
    String user = "root";
    String password = "";
    String sql = "SELECT firstName, lastName, middleName, dob, email, medicalinfo, notes, photo FROM members";

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String middleName = rs.getString("middleName");
            LocalDate dob = rs.getDate("dob").toLocalDate();
            String email = rs.getString("email");
            String medicalInfo = rs.getString("medicalinfo");
            String notes = rs.getString("notes");
            String photo = rs.getString("photo");

            FamilyMember member = new FamilyMember(firstName, lastName, middleName, dob, email, medicalInfo, notes, photo);
            members.add(member);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return members;
}

    
    
    
}