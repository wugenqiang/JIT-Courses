/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servlet;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author ibm
 */
public class CounterFile {
    private BufferedReader file;
    public CounterFile()
    {
    }
    public String ReadFile(String filePath) throws FileNotFoundException
    {
        String currentRecord = null;
        file = new BufferedReader(new FileReader(filePath));
        String returnStr = null;
        try
        {
            currentRecord = file.readLine();

        }catch(IOException e)
        {
            System.out.println("读取数据错误");
        }
        if(currentRecord==null)
        {
            returnStr = "没有任务记录";
        }
        else
        {
            returnStr=currentRecord;
        }
        return returnStr;
    }

    public synchronized void WriteFile(String filePath,String counter) throws FileNotFoundException
    {
        int Writestr = 0;
        Writestr=Integer.parseInt(counter);
        try
        {
         PrintWriter pw = new PrintWriter(new FileOutputStream(filePath));
         pw.println(Writestr);
         pw.close();
        }catch(IOException e)
        {
                  System.out.println("写入数据错误"+e.getMessage());
        }
    }

}
