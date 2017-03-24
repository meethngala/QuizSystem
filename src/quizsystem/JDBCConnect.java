/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizsystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Meeth
 */
public class JDBCConnect {

    private Connection con = null;

    /**
     *
     */
    public JDBCConnect() {
        String url = "jdbc:derby:C:\\Users\\Meeth\\Documents\\NetBeansProjects\\QuizSystem\\ExamDB;create=true";
        String username = "meeth";
        String password = "meeth";
        try {
            con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        } // end of try-with-resources

    }

    /**
     *
     * @throws SQLException
     * @throws IOException
     */
    public void takeTest() throws SQLException, IOException {
        try (Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY)) {
            String delete = "DELETE FROM QUIZ";
            String query = " SELECT * FROM Quiz";
            ReadFiles r1 = new ReadFiles();
            r1.readFile("Questions.txt");
            stmt.execute(delete);
            PreparedStatement pStmt = con.prepareStatement("insert into Quiz values (?,?,?,?,?,?,?)");
            for (int i = 0; i < 15; i++) {
                pStmt.setInt(1, Integer.parseInt(r1.getColumns().get(i)[0]));
                pStmt.setString(2, r1.getColumns().get(i)[1]);
                pStmt.setString(3, r1.getColumns().get(i)[2]);
                pStmt.setString(4, r1.getColumns().get(i)[3]);
                pStmt.setString(5, r1.getColumns().get(i)[4]);
                pStmt.setString(6, r1.getColumns().get(i)[5]);
                pStmt.setString(7, r1.getColumns().get(i)[6]);
                pStmt.executeUpdate();
            }
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int qno = rs.getInt("QNO");
                String desc = rs.getString("DESCRIPTION");
                String c1 = rs.getString("CHOICE1");
                String c2 = rs.getString("CHOICE2");
                String c3 = rs.getString("CHOICE3");
                String c4 = rs.getString("CHOICE4");
                String ans = rs.getString("ANSWER");
                //System.out.println("question no:"+ qno + "\n question" + desc);

            }
            Scanner sc = new Scanner(System.in);
            int count = 0;
            ArrayList<Integer> qno = new ArrayList<>();
            Integer temp;
            while (qno.size() != 3) {
                temp = getRandomNumber(1, 14);
                if (!qno.contains(temp)) {
                    qno.add(temp);
                }
            }
            for (int i = 1; i <= 3; i++) {

                rs.absolute(qno.get(i - 1));
                System.out.println("Answer the question ");
                System.out.println(rs.getString("DESCRIPTION"));
                System.out.println(rs.getString("CHOICE1") + "\n" + rs.getString("CHOICE2") + "\n"
                        + rs.getString("CHOICE3") + "\n" + rs.getString("CHOICE4"));
                String input = sc.nextLine();
                while (!(input.equalsIgnoreCase("a") || input.equalsIgnoreCase("b") || input.equalsIgnoreCase("c") || input.equalsIgnoreCase("d"))) {
                    System.out.println("Enter valid choice");
                    input = sc.nextLine();
                }
                if (input.equalsIgnoreCase(rs.getString("ANSWER"))) {

                    count++;
                }

            }
            System.out.println("No of correct ans:" + count);
            System.out.println("No of incorrect ans: " + (3 - count));

        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
    }

    /**
     * generates random number
     * @param min
     * @param max
     * @return
     */
    public static int getRandomNumber(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
