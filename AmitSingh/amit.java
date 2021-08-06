import java.io.*; 
import java.io.IOException;
import java.util.*;

public class FileOrg {
  public static void main(String[] args) {
    try {
      File myObj = new File("pawan2001102.txt");
      if (myObj.createNewFile()) 
      {
        System.out.println("File created: " + myObj.getName());
        
        // To read the write content on the File............
        
        FileWriter myWriter = new FileWriter("Viney2001169.txt");
        
        System.out.println("Enter the content for file");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        myWriter.write(str);
        myWriter.close();
        
        // To show the output of the file.
        
        System.out.println("The content of the files are as Follows");
        String line = null;
        FileReader fileReader = new FileReader("pawan2001102.txt");
      
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        while((line = bufferedReader.readLine()) != null)
        {
            System.out.println(line);
        }
        
        /* always close the file after use */
        bufferedReader.close();
        
      } 
      else {
        System.out.println("File already exists.");
      }
    }
    catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();

    }
  }
}