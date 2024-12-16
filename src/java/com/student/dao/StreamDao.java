package com.student.dao;

import com.student.SQLQueries.Query;
import com.student.entities.Stream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Nil
 */
public class StreamDao {
    private Connection con;

    public StreamDao(Connection con) {
        this.con = con;
    }
    
     public List<Stream> getAllStreams() {
        List<Stream> streams = new ArrayList<>();
        try {
            String query = Query.GET_STREAMS;
            PreparedStatement state = con.prepareStatement(query);
            ResultSet rs = state.executeQuery();

            while (rs.next()) {
                Stream stream = new Stream();
                stream.setId(rs.getInt("stream_id"));
                stream.setName(rs.getString("stream_name"));
                streams.add(stream);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return streams;
    }
}
