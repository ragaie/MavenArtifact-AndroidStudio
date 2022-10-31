package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KPITApi {
    /*
    Description:
       simple function taking path of any file and return number of words inside it.
     Input
     path : String (path for you file)

     Output: int or Exception

     return number of words inside given file with path.
     function could throw generic exception if their any fail happen.
     */
   public int countFileWords(String path) throws Exception {
       File file = new File(path);
       Scanner sc = new Scanner(new FileInputStream(file));
       int count=0;
       while(sc.hasNext()){
           sc.next();
           count++;
       }
       return count;
   }
}
