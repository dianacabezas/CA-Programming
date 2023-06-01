/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package caintroprogramming;
import java.sql.*;
import java.util.Scanner;
import inpututilities.InputUtilities;
/**
 *
 * @author mileidicabezas
 */
public class CAIntroProgramming {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner myKB= new Scanner(System.in); 
        //Calling the InputUtilities method to validate user input
        InputUtilities myInput = new InputUtilities();
        
        try{
        //Data base connection    
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/NFL-DataBase","root","Nadia2021");
        //If the connection is successful then it will show this message
        System.out.println("Connected to DB...");
        
        //Using boolean variable to get off the loop
        boolean quit = false;
        
        //This variable is for the switch case statement
        int option;
        
        //this will keep going until quit our boolean variable is true
        while(!quit){
         
            //This is the menu that will be printed at startup. I have used many SOPs to make it user friendly
        System.out.println("---------------------------------------------------------------------------------------------------- ");
        System.out.println("                                 WELCOME TO NFL DATA BASE ");
        System.out.println("---------------------------------------------------------------------------------------------------- ");
        System.out.println();
            
        System.out.println("                                    Please select option                                             ");
        System.out.println("                                   **********************                                             ");
        System.out.println("1. List all unique positions found in the database");
        System.out.println();
        System.out.println("2. List all the football players’ names ordered alphabetically in ascending or descending order ");
        System.out.println();
        System.out.println("3.List all captains ID with their first, last name and Team  ");
        System.out.println();
        System.out.println("4.Display a list of the most common injuries and order them by ascending order.");
        System.out.println();
        System.out.println("0. Quit");
        System.out.println();
        
        
       //In this part I am using the input utilities method to validate input obtained from the user.
        option= myInput.askUserforInt("Please enter a number");
        
        switch(option){
            case 1:
                //1. List all unique positions found in the database
                
                
            //Creates a Statement object for sending SQL statements to the database.     
            Statement stmt3=con.createStatement();
            
            //This is the menu that will be printed on as a title os the columns
            System.out.println("-----------   -----------        ------------        ------------");
            System.out.println("ID PLAYERS     LAST NAME          NAME PLAYER         POSITION");
            System.out.println("-----------   -----------        ------------        ------------");
            
            //Sql statement based on the filds that are in our tables        
            String mysql3 ="SELECT pl.id_players,pl.last_name, pl.name_player, p.name_position FROM players pl INNER JOIN position p on pl.id_position=p.id_position;";
            
            //Executing our query using the statemet object that will return the result set
            ResultSet queryResults3 = stmt3.executeQuery(mysql3);
            
            //Iterating through the statemet object using while loop
             while (queryResults3.next()) {
                 
            //Retrieving the columns by column name
             int IDteam= queryResults3.getInt("id_players");
             String lastnamePlayer=queryResults3.getString("last_name");
             String namePlayer=queryResults3.getString("name_player");
             String namePosition=queryResults3.getString("name_position");
            
             //Printing out the data obtained
             System.out.format("%-16s %-16s %-16s %-16s\n",IDteam,lastnamePlayer,namePlayer,namePosition);
           
             }
            
                
                break;
                
            case 2://This is the case to print the players' last name and  name in order asc and desc
                
                                //Using boolean variable to get off the loop
                                boolean quit2 = false;
                                //declaring our variable for the switch case statement 
                                char option2=' ';
                                //while(!quit2){
                                do{
                                 //Submenu 
                                System.out.println("------------------------------------Please select option------------------------------------------- ");
                                System.out.println("a. List all the football players’ names ordered alphabetically in ascending order  ");
                                System.out.println("b. List all the football players’ names ordered alphabetically in descending order ");
                                System.out.println("q. Quit");
        
                                System.out.println("---------------------------------------------------------------------------------------------------- ");
       
        
                                    // we are getting a char this time because the options will be a single letter
                                    option2= myKB.next().charAt(0);
                                    
                                        switch(option2){
                                            
                                            case 'a':
                
                                                   //Creates a Statement object for sending SQL statements to the database.
                                                   Statement stmtasc=con.createStatement();
                                                   
                                                   System.out.println("-------        ---------          ------------");
                                                   System.out.println("ID TEAM        LAST NAME          NAME PLAYER");
                                                   System.out.println("-------        ---------          ------------");
                                                   String mysqlasc ="SELECT p.id_team,p.last_name,p.name_player FROM players p Where id_team='5' ORDER BY name_player ASC";
                    
                                                   //Executing our query using the statemet object that will return the result set
                                                   ResultSet queryResults2 = stmtasc.executeQuery(mysqlasc);
                                                   
                                                   //Iterating through the statemet object using while loop
                                                   while (queryResults2.next()) {
                                                   //Retrieving the columns by column name   
                                                   int IDteam= queryResults2.getInt("id_team");
                                                   String lastnamePlayer=queryResults2.getString("last_name");
                                                   String namePlayer=queryResults2.getString("name_player");
            
                                                    //Printing out the data obtained
                                                    System.out.format("%-16s %-16s %-16s\n",IDteam,lastnamePlayer,namePlayer);
                                                    
                                                                                }
               
                                            break;
                                            case 'b':
                                                   Statement stmtdesc=con.createStatement();
                                                   System.out.println("-------        ---------          ------------");
                                                   System.out.println("ID TEAM        LAST NAME          NAME PLAYER");
                                                   System.out.println("-------        ---------          ------------");
                
                                                   String mysqldesc ="SELECT p.id_team,p.last_name,p.name_player FROM players p Where id_team='5' ORDER BY name_player DESC";
                    
                                                   //Executing our query using the statemet object that will return the result set
                                                   ResultSet queryResultsdesc = stmtdesc.executeQuery(mysqldesc);
                                                   //Iterating through the statemet object using while loop
                                                   while (queryResultsdesc.next()) {
                                                       
                                                   //Retrieving the columns by column name 
                                                   int IDteam= queryResultsdesc.getInt("id_team");
                                                   String lastnamePlayer=queryResultsdesc.getString("last_name");
                                                   String namePlayer=queryResultsdesc.getString("name_player");
            
  
                                                   System.out.format("%-16s %-16s %-16s\n",IDteam,lastnamePlayer,namePlayer);
                                                  
                                                                                 }
                                           
                
                                            case 'q':
                                                
                                                
                                                System.out.println("Goodbye! ");
                                                
                                            break;
                                           
                
                                            default:
                                                    
                                                    System.out.println("\t--------------------------------------------------------------------------");
                                                    System.out.println("\t-        Please select a valid option!!! -The options are 'a' , 'b' and 'q' ");
                                                    System.out.println("\t--------------------------------------------------------------------------");
                                            break;
                
                }
                //this will keep going until quit our boolean variable is true
                }while(option2 !='q');
                
              
            case 3:
                
                //List all captains ID with their first, last name and Team  
                
                //Creates a Statement object for sending SQL statements to the database.
                Statement stmt=con.createStatement();
            
             System.out.println("TEAM NAME    CAPTAIN ID         NAME PLAYER       LAST NAME");
             
             //System.out.print(sentence);
            String mysql ="SELECT team_name,captain,name_player,last_name FROM team,players WHERE captain=id_players";
            
            //Executing our query using the statemet object that will return the result set
            ResultSet queryResults = stmt.executeQuery(mysql);
            
            //Iterating through the statemet object using while loop
             while (queryResults.next()) {
             //Retrieving the columns by column name    
             String nameTeam=queryResults.getString("team_name");
             int Captain= queryResults.getInt("captain");
             String namePlayer=queryResults.getString("name_player");
             String lastnamePlayer=queryResults.getString("last_name");
             
             
             System.out.format("%-16s %-16s %-16s %-16s\n", nameTeam,Captain,namePlayer,lastnamePlayer);
             //System.out.println();
             
           
             }
                break;
                
            case 4:
                //Display a list of the most common injuries and order them by ascending order.
                
                //Creates a Statement object for sending SQL statements to the database.
                Statement stmt4=con.createStatement();
                
                System.out.println("----------       -----------------      ");
                System.out.println("ID INJURY        TOTAL REPETITIONS      ");
                System.out.println("-----------      -----------------      ");
            
          
            String mysql4 ="WITH Total_cte AS(SELECT id_injury, COUNT(*) AS TotalRepetitions FROM injury_record "
                    + "GROUP BY id_injury ORDER BY TotalRepetitions ASC) "
                    + "SELECT * FROM Total_cte WHERE TotalRepetitions=(SELECT MAX(TotalRepetitions)FROM Total_cte )";
                    
            
            ResultSet queryResults4 = stmt4.executeQuery(mysql4);
            
             while (queryResults4.next()) {
            int injury= queryResults4.getInt("id_injury");      
            int Amount= queryResults4.getInt("TotalRepetitions");
  
             System.out.format("%-20s %-20s\n",injury,Amount);
             System.out.println();
             }
                break;
                
            case 0:
                quit=true;
                System.out.println("Thank you for using our application. ");
                break;
            default:
                System.out.println("The options are between 1 and 5");
            break;
        
        }
        
        }
        
            
            
        }catch(SQLException e) {
            
            System.out.println("SQL Error --> ");
                System.out.println(e.getMessage()); 
                System.out.println(e.getSQLState());
                        
        }
        
        catch (ClassNotFoundException e) { 
            
            System.out.println("Class error -- " + e.getMessage ());
        }
    }
    
}
