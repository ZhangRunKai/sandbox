package com.oj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootTest
class SandboxSocketApplicationTests {

    @Test
    void contextLoads() {
        File file = new File("E:\\test.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] b =new  byte[100];
            int len;
            while((len=fileInputStream.read(b))!=-1){
                System.out.println(b);
                System.out.println(len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
