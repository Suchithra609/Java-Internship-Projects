package level3.librarymgmt;
import java.sql.*;
public class LibraryService {
    public void addBook(Book book){
        String sql =
        "INSERT INTO books(title,author,available) VALUES(?,?,?)";
        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1,book.getTitle());
            ps.setString(2,book.getAuthor());
            ps.setBoolean(3,book.isAvailable());
            int rows=ps.executeUpdate();
            if(rows>0){
                System.out.println("Book Added Successfully");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void viewBooks(){
        String sql="SELECT * FROM books";
        try(Connection con=DBConnection.getConnection();
            Statement st=con.createStatement()){
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                System.out.println(
                "ID: "+rs.getInt("book_id")
                +" Title: "+rs.getString("title")
                +" Author: "+rs.getString("author")
                +" Available: "+rs.getBoolean("available"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void addUser(User user){
        String sql=
        "INSERT INTO users(name,email) VALUES(?,?)";
        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,user.getName());
            ps.setString(2,user.getEmail());
            ps.executeUpdate();
            System.out.println("User Added Successfully");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void borrowBook(int userId,int bookId){
        try(Connection con=DBConnection.getConnection()){
            con.setAutoCommit(false);
            PreparedStatement ps1=
            con.prepareStatement(
            "UPDATE books SET available=false WHERE book_id=?");
            ps1.setInt(1,bookId);
            ps1.executeUpdate();
            PreparedStatement ps2=
            con.prepareStatement(
            "INSERT INTO transactions(user_id,book_id,issue_date,status)"
            +" VALUES(?,?,CURDATE(),'Borrowed')");
            ps2.setInt(1,userId);
            ps2.setInt(2,bookId);
            ps2.executeUpdate();
            con.commit();
            System.out.println("Book Borrowed Successfully");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void returnBook(int bookId){
        try(Connection con=DBConnection.getConnection()){
            PreparedStatement ps1=
            con.prepareStatement(
            "UPDATE books SET available=true WHERE book_id=?");
            ps1.setInt(1,bookId);
            ps1.executeUpdate();
            PreparedStatement ps2=
            con.prepareStatement(
            "UPDATE transactions SET return_date=CURDATE(),status='Returned'"
            +" WHERE book_id=? AND status='Borrowed'");
            ps2.setInt(1,bookId);
            ps2.executeUpdate();
            System.out.println("Book Returned Successfully");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}