package com.readfile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Corey.xu on 2016/6/23.
 */
public class ReadFile {
    public static void main(String[] args) {
        try {
            //Files.list(Paths.get("")).forEach(System.out::println);
                ReadFile.show("");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void show(String str) throws Exception{
        System.out.println("=============================1");
        Files.list(Paths.get(str)).forEach(System.out::println);
        System.out.println("=============================2");
        Files.list(Paths.get(str)).filter(f->!f.getFileName().toString().startsWith(".")).forEach(System.out::println);
        System.out.println("=============================3");
        Files.walk(Paths.get(str)).filter(f->!f.getFileName().toString().startsWith(".")).forEach(System.out::println);
        System.out.println("=============================4");
        Files.walk(Paths.get(str)).filter(f->!f.toString().contains(File.separator+".")).limit(3).forEach(System.out::println);
        System.out.println("=============================5");
        Files.walk(Paths.get(str))
               .filter(f->!f.toString().contains("."))
                .forEach(System.out::println);

    }
}
