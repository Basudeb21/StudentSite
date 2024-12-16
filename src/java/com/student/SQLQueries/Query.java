package com.student.SQLQueries;

/**
 *
 * @author Nil
 */
public interface Query {
    public static final String GET_STREAMS = "SELECT * FROM `stream` WHERE 1";
    public static final String INSERT_NEW_STUDENT = "INSERT INTO `student_tbl`(`s_roll`, `s_name`, `s_stream`, `s_reg`) VALUES (?, ?, ?, ?)";
    public static final String IS_ROLL_IN_DB = "SELECT COUNT(*) AS student_count FROM student_tbl WHERE s_roll = ?";
    public static final String SEARCH_STUDENT_BY_ROLL = "SELECT * FROM `student_tbl` WHERE s_roll = ?";
    public static final String SEARCH_STUDENT_BY_NAME = "SELECT * FROM `student_tbl` WHERE s_name = ?";
    public static final String SEARCH_STUDENT_BY_STREAM = "SELECT * FROM `student_tbl` WHERE s_stream = ?";
    public static final String SEARCH_ALL_STUDENT = "SELECT * FROM `student_tbl` WHERE 1";
    public static final String UPDATE_USER_BY_NAME_OR_ROLL = "UPDATE `student_tbl` SET `s_roll`= ?,`s_name`= ? ,`s_stream`= ? WHERE `s_roll` = ? OR `s_name` = ?";
    public static final String DELETE_STUDENT_BY_ROLL = "DELETE FROM `student_tbl` WHERE `s_roll` = ?";
}
