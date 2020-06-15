package com.deploy.jenkinsdocker.file;

import java.io.*;

/**
 * 　　* @Description:
 * 　　* @param
 * 　　* @return
 * 　　* @throws
 * 　　* @author YY Shen
 * 　　* @date $ $
 *
 */
public class OutputStreamReader {

    public static void main(String[] args) {
        //字符流
        try {
            FileReader fr = new FileReader("/Users/zibingya/files/test/a/touch.txt");
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter("/Users/zibingya/files/test/a/touchc.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            String str;
            while ((str = br.readLine()) != null){
                System.out.println(str);
                bw.write(str);
                bw.flush();
            }



            fr.close();
            br.close();
            fw.close();
            bw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
