package com.student.dao;

import com.student.SQLQueries.Query;
import com.student.entities.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nil
 */
public class StudentDao {
    private Connection con;

    public StudentDao() {
    }

    public StudentDao(Connection con) {
        this.con = con;
    }
    
    
    public boolean addNewStudent(Student st){
        try{
            String query = Query.INSERT_NEW_STUDENT;
            PreparedStatement psmt = this.con.prepareStatement(query);
            psmt.setInt(1, st.getS_roll());
            psmt.setString(2, st.getS_name());
            psmt.setString(3, st.getS_stream());
            psmt.setString(4, st.getS_reg());
            
            int result = psmt.executeUpdate();
            if(result > 0){
                return true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteStudent(int roll){
        try{
            String query = Query.DELETE_STUDENT_BY_ROLL;
            PreparedStatement psmt = this.con.prepareStatement(query);
            psmt.setInt(1, roll);
            int result = psmt.executeUpdate();
            if(result > 0){
                return true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
     public boolean updateStudentByNameOrRoll(int roll, String name, String stream){
        try{
            String query = Query.UPDATE_USER_BY_NAME_OR_ROLL;
            PreparedStatement psmt = this.con.prepareStatement(query);
            psmt.setInt(1, roll);
            psmt.setString(2, name);
            psmt.setString(3, stream);
            psmt.setInt(4, roll);
            psmt.setString(5, name);
            
            int result = psmt.executeUpdate();
            if(result > 0){
                return true;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return false;
    }
    
    public boolean isStudentExists(int roll){
        try{
            String query = Query.IS_ROLL_IN_DB;
            PreparedStatement psmt = this.con.prepareStatement(query);
            psmt.setInt(1, roll);
            
            ResultSet set = psmt.executeQuery();
            if (set.next()) {
                int count = set.getInt("student_count");
                if(count > 0){
                    return true;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public List<Student> searchStudentByRoll(int roll) {
        List<Student> student_list = new ArrayList<>();
        try {
            String query = Query.SEARCH_STUDENT_BY_ROLL;
            PreparedStatement psmt = this.con.prepareStatement(query);
            psmt.setInt(1, roll);
            ResultSet set = psmt.executeQuery();
            while (set.next()) {
                Student stu = new Student();
                stu.setS_roll(set.getInt("s_roll"));
                stu.setS_name(set.getString("s_name"));
                stu.setS_stream(set.getString("s_stream"));
                stu.setS_reg(set.getString("s_reg"));
                student_list.add(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return student_list;
}

    
    public List<Student> searchStudentByName(String name){
        List<Student> student_list = new ArrayList<>();
        try {
            String query = Query.SEARCH_STUDENT_BY_NAME;
            PreparedStatement psmt = this.con.prepareStatement(query);
            psmt.setString(1, name);
            ResultSet set = psmt.executeQuery();
            while (set.next()) {
                Student stu = new Student();
                stu.setS_roll(set.getInt("s_roll"));
                stu.setS_name(set.getString("s_name"));
                stu.setS_stream(set.getString("s_stream"));
                stu.setS_reg(set.getString("s_reg"));
                student_list.add(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student_list;
    }
    
    public List<Student> searchStudentByStream(String name){
        List<Student> student_list = new ArrayList<>();
        try {
            String query = Query.SEARCH_STUDENT_BY_STREAM;
            PreparedStatement psmt = this.con.prepareStatement(query);
            psmt.setString(1, name);
            ResultSet set = psmt.executeQuery();
            while (set.next()) {
                Student stu = new Student();
                stu.setS_roll(set.getInt("s_roll"));
                stu.setS_name(set.getString("s_name"));
                stu.setS_stream(set.getString("s_stream"));
                stu.setS_reg(set.getString("s_reg"));
                student_list.add(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student_list;
    }
    
    public List<Student> searchAllStudent(){
        List<Student> student_list = new ArrayList<>();
        try {
            String query = Query.SEARCH_ALL_STUDENT;
            PreparedStatement psmt = this.con.prepareStatement(query);
            ResultSet set = psmt.executeQuery();
            while (set.next()) {
                Student stu = new Student();
                stu.setS_roll(set.getInt("s_roll"));
                stu.setS_name(set.getString("s_name"));
                stu.setS_stream(set.getString("s_stream"));
                stu.setS_reg(set.getString("s_reg"));
                student_list.add(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student_list;
    }
    
   
    
}
