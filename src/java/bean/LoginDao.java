///*
//    Jiayu Wu
//    3/8/19
//    This class checks if the username and password are found in the database.
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
//public class LoginDao {
//    
//    public static boolean validate(LoginBean bean){
//        Connection con=null;
//        String DbName = "LoginDb";
//        String connectionURL = "jdbc:mysql://localhost:3306/"
//                + DbName;
//        boolean status = false;
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection(connectionURL,"root","mysql1");
//            
//            PreparedStatement ps = con.prepareStatement(
//              "SELECT * FROM UserTable WHERE UserName=? and Password=?");
//            
//            ps.setString(1, bean.getUserName());
//            ps.setString(2, bean.getPassword());
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
