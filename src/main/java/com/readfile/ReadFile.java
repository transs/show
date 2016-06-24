package com.readfile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Corey.xu on 2016/6/23.
 */
public class ReadFile {
    public static void main(String[] args) {
        try {
            //Files.list(Paths.get("")).forEach(System.out::println);
                ReadFile.test();
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
    public static void test(){
        List<String> wordList = new ArrayList<>();
        List<String> outPut = new ArrayList<>();
        wordList.add("a");
        wordList.add("b");
        outPut.add("nihao,hello,wohaoa");
        outPut.add("wohao,helloa,wohaoa");
        List<String> output = wordList.stream().
                map(String::toUpperCase).
                collect(Collectors.toList());
        output.forEach(System.out::println);
       outPut.stream().flatMap(line -> {Stream.of(line.split(","));return Stream.of("a,b");}).forEach(System.out::println);
        Stream.of(1,2,3,4).filter(n -> n>2).forEach(System.out::println);
        Stream.of("a","b","c","d").map(String::toUpperCase).forEach(System.out::println);
        Stream.of("a","a","b","c","c").distinct().forEach(System.out::println);
        Stream.of("a","a","b","c","c").filter(s -> "a".equals(s)).forEach(System.out::println);
        Stream.of("","","","","").distinct().forEach(System.out::println);
        List<Integer> integers = Stream.of(18,19,20,-1,-3).filter(n -> n>0).collect(Collectors.toList());
        System.out.println(integers.size());
        Map<Boolean, List<Integer>> children = Stream.of(-1,-2,1,2,3).collect(Collectors.partitioningBy(s->s>0));
        System.out.println(  children.get(Boolean.FALSE).size());
        System.out.println(  children.get(Boolean.TRUE).size());
        String concat = Stream.of("A", "B", "C", "D").reduce("", (s, s2) ->s+";");
        String concat1 = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println(concat);
        int sum = Stream.of(1,2,3,4,5).reduce(0,Integer::sum);
        int sum1 = Stream.of(1,2,3,4,5).reduce(0,(a,b)->a+b);

        //  output1.forEach(System.out::println);
    }
    public static class Car {
        public static Car create( final Supplier< Car > supplier ) {
            return supplier.get();
        }

        public static void collide( final Car car ) {
            System.out.println( "Collided " + car.toString() );
        }

        public void follow( final Car another ) {
            System.out.println( "Following the " + another.toString() );
        }

        public void repair() {
            System.out.println( "Repaired " + this.toString() );
        }
    }
}
