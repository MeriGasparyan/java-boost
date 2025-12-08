package com.merigasparyan.jmp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Task2 {
    public static void readFile(File file) {

        RandomAccessFile input = null;
        String line = null;
        Throwable primaryException = null;
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        }
        catch (FileNotFoundException e) {
            primaryException = e;
            System.out.println("File not found");
        }
        catch (IOException e) {
            primaryException = e;
            System.out.println("I/O exception");
        }
        catch (Throwable e)
        {
            primaryException = e;
            throw e;
        }
            finally {
            if (input != null) {
                if (primaryException != null) {
                    try{
                        input.close();
                    }catch (Exception e){
                        primaryException.addSuppressed(e);
                    }
                }else{
                    try{
                        input.close();
                    }catch (Exception e){
                        System.out.println("I/O exception");;
                    }
                }

            }
        }
    }

}
