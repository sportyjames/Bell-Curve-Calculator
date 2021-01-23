///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package bean;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
///**
// *
// * @author wujiayu
// */
//public class InputCheck {
//    
//    public static boolean validate(student bean){
//        Connection con=null;
//        String DbName = "studentDb";
//        String connectionURL = "jdbc:mysql://localhost:3306/"
//                + DbName;
//        boolean status = true;
//        
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection(connectionURL,"root","mysql1");
//            
//            PreparedStatement ps = con.prepareStatement(
//              "SELECT * FROM studentInfo WHERE IDnumber=?");
//            
//            ps.setInt(1, bean.getId());
//            
//            ResultSet rs= ps.executeQuery();
//            status=rs.next();
//            con.close();
//        }
//        catch(Exception e){
//        }
//        return status;
//    }
//    
//}
//
