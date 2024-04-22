import java.io.File;

public class FileFinderDemo
{
   public static void main(String[] args)
   {
    //  File startingDirectory = new File("C:/Users/caoy/Documents/Courses/23Fall&24Spring_Courses/");
	  File startingDirectory = new File(".");
	//  File startingDirectory = new File(".");
      String extension = ".java";
	  System.out.println("Create a FileFinder object, and then call the find() method: ");
	  FileFinder finder = new FileFinder(startingDirectory);
      finder.find(extension);
      
      System.out.println("\nCall the static find() method: ");
      find(startingDirectory, extension);
      
      System.out.println("\nCall the static find_v2() method: ");
      extension = ".doc";
      //extension = ".txt";
      boolean find = find_v2(startingDirectory, extension);
      
      if(!find)
         System.out.println("Did not find the file with given extension: " + extension);
          
   }
   
   /**
   Prints all files whose names end in a given extension.
   @param aFile a file or directory
   @param extension a file extension (such as ".java")
*/
public static void find(File aFile, String extension)
{            
   if (aFile.isDirectory())
   {
      for (File child : aFile.listFiles())
      {
         find(child, extension);
      }
   }
   else
   {
      String fileName = aFile.toString();
      if (fileName.endsWith(extension))
      {
         System.out.println(fileName);
      }
   }
}
   

/**
 * Prints all files whose names end in a given extension.
   @param aFile a file or directory
   @param extension a file extension (such as ".java")
 * @param aFile
 * @param extension
 * @return boolean value indicates whether find or not
 */
 public static boolean find_v2(File aFile, String extension)
 {            
   boolean find = false;
   if (aFile.isDirectory())
   {
      for (File child : aFile.listFiles())
      {
         find = find_v2(child, extension) || find;  //as long as one file matched then find = true;
      }
      return find;
   }
   else
   {
      String fileName = aFile.toString();
      if (fileName.endsWith(extension))
      {
         System.out.println(fileName);
         return true;
      }
      return false;

   }
 }



}
