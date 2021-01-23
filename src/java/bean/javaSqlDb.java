// Jiayu Wu
// 3/8/19
// This class connects database to mySQL. It also has computation classes
package bean;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author wujiayu
 */
public class javaSqlDb {
    private String dbName;
    private ArrayList<ArrayList<String>> data;
    private Connection dbConn;
    int count;
    ArrayList<Integer> IDnumber;
    
    
    public javaSqlDb()
    {
        this.dbName="";
        this.data = null;
        this.dbConn = null;
    }
    public javaSqlDb(String dbName)
    {
        this.dbName = dbName;
        this.data = null;
        setDbConn();
    }

    public String getDbName() {
        return dbName;
    }
    
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public ArrayList<ArrayList<String>> getData(String tableName,String[] tableHeaders) {
        int columnCount = tableHeaders.length;
        ResultSet rs = null;
        Statement s = null;
        String dbQuery = "SELECT * FROM " + tableName;
        this.data = new ArrayList<>();
        
        
        try{
           
            s = this.dbConn.createStatement();
            
            rs = s.executeQuery(dbQuery);
            
            while(rs.next()) {
            ArrayList<String> row = new ArrayList <>();
                for(int i=0; i<columnCount; i++)
                {
                    row.add(rs.getString(tableHeaders[i]));                    
                    
                }
                this.data.add(row);
            }
            
        }
            catch(SQLException err)
                    {
                    System.out.println("unable to get the data from database!");
                    System.exit(0);
                    }
            return this.data;
    }
    
    public void setData(ArrayList<ArrayList<String>> data) {
        this.data = data;
    }

    public Connection getDbConn() {
        return dbConn;
    }

    public void setDbConn() {
        String connectionURL = "jdbc:mysql://localhost:3306/"+ this.dbName;
        this.dbConn = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.dbConn = DriverManager.getConnection(connectionURL,"root","mysql1");
        }
        catch(SQLException err)
        {
            System.out.println("SQL Connection error.");
            System.exit(0);
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("Class For Name not found");
            System.exit(0);
        }
    }
    
    public void closeDbConn(){
        try{
            this.dbConn.close();
        }
        catch(Exception err)
        {
            System.out.println("DB closing error");  
            System.exit(0);
        }
    }
   
   
    public void createDb(String newDbName){
        this.dbName = newDbName;
        String connectionURL = "jdbc:mysql://localhost:3306/";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.dbConn = DriverManager.getConnection(connectionURL,"root","mysql1");
            Statement s = dbConn.createStatement();
            int result = s.executeUpdate("Create DATABASE " + newDbName);
            System.out.println("Database created");
            this.dbConn.close();
            
                    
        }
        
        catch(Exception err){
            System.out.println("DB creation error "+ newDbName);
            System.exit(0);
        }   
    }
    public void createTable(String newTable, String dbName)
    {
        Statement s;
        
        setDbName(dbName);
        setDbConn();
        try{
            s = this.dbConn.createStatement();
            s.execute(newTable);
            System.out.println("New table created.");
            this.dbConn.close();
        }
        catch(SQLException err)
        {
            System.out.println("Error creating table "+ newTable);
            System.exit(0);
        }
    }
    
    public void insertData(String username, String password){
       
        String dbQuery1 = "INSERT INTO UserTable VALUES " +
                          "(?,?) ";
        try{
            PreparedStatement ps = dbConn.prepareStatement(dbQuery1);
            ps.setString(1,username); 
            ps.setString(2,password);
            ps.executeUpdate();
    }
        catch(Exception e1){
            System.out.println("do not insert");
        }
        
    }
    
    public void insertStudentData(int ID, int grade){
        
        String dbQuery = "INSERT INTO studentInfo VALUES " +
                         "(?,?) ";
        try{
            PreparedStatement ps = dbConn.prepareStatement(dbQuery);
            ps.setInt(1,ID); 
            ps.setInt(2,grade);
            ps.executeUpdate();
        }
        catch(Exception e1){
            System.out.println("do not insert");
        }
    }
    
    public int getNumberOfStudent()
    {
        count = 0;
        String dbQuery = "SELECT COUNT(*) AS rowcount FROM studentInfo" ; 
       
        
        try{
            Statement s = dbConn.createStatement();
            ResultSet rs = s.executeQuery(dbQuery);
            
            while (rs.next()) {
            count = rs.getInt("rowcount") ;
            }
        }
        catch(Exception e1){
            System.out.println("do not insert");
        }
        
        return count;

            
        
    }
    
    public ArrayList<Integer> orderGrade(){
        String dbQuery = "SELECT IDnumber FROM studentInfo ORDER BY grade DESC ";
        
        
        
        try{
            Statement s = dbConn.createStatement();
            ResultSet rs = s.executeQuery(dbQuery);
            
            //Stores properties of a ResultSet object, including column count
            ResultSetMetaData rsmd = rs.getMetaData(); 
            int columnCount = rsmd.getColumnCount();
            
            IDnumber = new ArrayList<>(columnCount);
            
            while (rs.next()) {              
            int i = 1;
            while(i <= columnCount) {
            IDnumber.add(rs.getInt(i++));
            }
            }
        }   
        catch(Exception e1){
            System.out.println("do not insert");
        }
        
        return IDnumber;
    }
    
    public int getA2(int stuNumber){
                
                double a2double = stuNumber*0.07;
                int a2 = (int)Math.round(a2double);
                return a2;
                
    }
    
    public int getB1(int a2){
                
                int b1 = a2 + 1;
                return b1;
    }
    
    public int getB2(int stuNumber,int b1){
        
                double b2double = stuNumber*0.24-1;
                int b2 = b1+(int)Math.round(b2double);
                return b2;
    }
    
    public int getC1(int b2){
                
                int c1 = b2 + 1;
                return c1;
    }
    
    public int getC2(int stuNumber,int c1){
        
                double c2double = stuNumber*0.38-1;
                int c2 = c1 +(int)Math.round(c2double);
                return c2;
    }
    
    public int getD1(int c2){
                
                int d1 = c2 + 1;
                return d1;
    }
    
    public int getD2(int stuNumber,int d1){
        
                double d2double = stuNumber*0.24-1;
                int d2 = d1 +(int)Math.round(d2double);
                return d2;
    }
    
    public int getF1(int d2){
                
                int f1 = d2 + 1;
                return f1;
    }
    
        
    public int getF2(int stuNumber,int f1){
                
                double f2double = stuNumber*0.07-1;
                int f2 = f1 +(int)Math.round(f2double);
                return f2;
    }
    
    
    
    
    
    
    
    
    public boolean validate(String username, String password)
    {
      
       boolean status = false;
       
       String dbQuery2 = "SELECT * FROM UserTable WHERE username = ? and password = ?";
                          
       
       try{
           
          PreparedStatement ps = dbConn.prepareStatement(dbQuery2);
          ps.setString(1,username);
          ps.setString(2,password);
          
          ResultSet rs = ps.executeQuery();
          status = rs.next();
       }
       catch(Exception e){
           
       }
       return status;
    }
    
    
    public boolean validate2(int ID)
    {
      
       boolean status = true;
       
       String dbQuery2 = "SELECT * FROM studentInfo WHERE IDnumber=?";
                          
       
       try{
           
          PreparedStatement ps = dbConn.prepareStatement(dbQuery2);
          ps.setInt(1,ID);
          
          ResultSet rs = ps.executeQuery();
          status = rs.next();
       }
       catch(Exception e){
           
       }
       return status;
    }
    
    public boolean isNumber(String s) 
	{ 
		for (int i = 0; i < s.length(); i++) 
		if (Character.isDigit(s.charAt(i)) 
			== false) 
			return false; 

		return true; 
	} 

        

    
    
    
    
    public static void main(String[] args){
        
        javaSqlDb dbObj = new javaSqlDb("studentDb");
//        ArrayList<Integer> num =obj.orderGrade();
//        System.out.println(num);
        String str = "67a0"; 

		// Function returns 1 if all elements 
		// are in range '0 - 9' 
		if (dbObj.isNumber(str)) 
			System.out.println("Integer"); 

		// Function returns 0 if the 
		// input is not an integer 
		else
			System.out.println("String"); 
		
	} 
    }

  
        
    
    
    


