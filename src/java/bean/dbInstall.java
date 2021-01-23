// Jiayu Wu
// 3/8/19
// This class installs database and table
package bean;


public class dbInstall {
    public static void main(String[] args)
    {
        String studentInfoTb;
        String UserTable;
        String CurveTable;
        javaSqlDb objDb = new javaSqlDb();
        objDb.createDb("studentDb");
        objDb.createDb("LoginDb");
       
        studentInfoTb = "CREATE TABLE studentInfo ( " +
                "IDnumber int,"+
                "grade int"+
                   ");";
        
        UserTable = "CREATE TABLE UserTable ( " +
                "UserName varchar(30),"+
                "Password varchar(30)"+
                ");";
        
        CurveTable = "CREATE TABLE CurveTable ( " +
                "IDnumber int," +
                "grade int"+
                ");";

        objDb.createTable(studentInfoTb,"studentDb");
        objDb.createTable(CurveTable,"studentDb");
        objDb.createTable(UserTable,"LoginDb");
    }
    
}

