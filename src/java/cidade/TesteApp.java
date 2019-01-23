/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cidade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class TesteApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
System.out.println("conectando...");
Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con =  DriverManager.getConnection("jdbc:mysql://127.0.0.1/tcc","root","root");
            System.out.println("conectado");
            PreparedStatement Statement = con.prepareStatement("Select * from cidades");
ResultSet result = Statement.executeQuery();
int num = 0;
while(result.next()) {
    
    num = num+1;
    System.out.println(num+" "+result.getString("nome"));
}
        } catch (Exception e) {
            System.out.println(""+e);
        }

    }

}
