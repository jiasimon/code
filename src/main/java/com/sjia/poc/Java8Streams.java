package com.sjia.poc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.*;
import java.util.stream.Stream;

public class Java8Streams {

    public static void main(String[] args) throws IOException {

        String singerFilePath = "/Users/sjia/dev/workspaces/hankerRank/src/main/java/com/sjia/poc/singer.txt";
        String dataFilePath = "/Users/sjia/dev/workspaces/hankerRank/src/main/java/com/sjia/poc/data.txt";

        // 1) Integer Stream only print 1-9
        System.out.println("1) Integer Stream range(1, 10) without right bound");
        IntStream.range(1, 10).forEach(System.out::println);
        // IntStream.range(1,20);
        System.out.println(" 1-20 average: " + IntStream.range(1, 21).average());
        System.out.println();

        // 1b) list average
        List<Integer> test1b = Arrays.asList(1, 3, 7, 13, 15);
        System.out.println("1b) list average, " + test1b);
        double result1b = test1b.stream().mapToInt(x -> x).average().getAsDouble();
        System.out.println("test1b.stream().mapToInt( x -> x).average().getAsDouble()"
                + " is: " + result1b);
        System.out.println();


        // 2. Integer Stream with skip. skip(5) to skip the first 5 number
        System.out.println("2) Integer Stream with skip. skip(5) to skip the first 5 number");
        IntStream.range(1, 10).skip(5).forEach(x -> System.out.println(x));
        System.out.println();
        // 2b Integer Stream for only even number
        System.out.println("2b) Integer Stream with skip. skip(6) and print only even number");
        IntStream.range(1, 20).skip(6).forEach(x -> {
            if (x % 2 == 0) System.out.println(x);
        });
        IntStream.range(1, 20).skip(6).forEach(x -> {
            if (x % 2 == 0) System.out.println(x * x);
        });
        System.out.println();


        // 3. Integer Stream with sum
        System.out.println("3) Integer Stream with sum 1 to 9");
        System.out.println(IntStream.range(1, 10).sum());
        System.out.println();
        // 3b. Normal Stream with sum
        System.out.println("3b) {3, 9, 27, 81,243} sum: ");
        int[] tmp3b = {3, 9, 27, 81, 243};
        System.out.println(Arrays.stream(tmp3b).sum());


        // 4. Stream.of, sorted and findFirst
        System.out.println("4) Stream.of, sorted and findFirst");
        Stream.of("Amy", "Adam", "Anna")
                .sorted()
                .forEach(System.out::println);
        System.out.println("4) only print First");
        Stream.of("Amy", "Adam", "Anna")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
        System.out.println();


        // 5. Stream from Array, sort, filter and print
        System.out.println("5) Stream from Array, sort, filter and print");
        String[] names = {"Sophie", "Simon", "Peter", "Sam", "Sarah", "James", "Eric", "Alex"};
        Stream.of(names).filter(x -> x.startsWith("S")).sorted().forEach(System.out::println);
        System.out.println("Stream sort desc, Comparator.reverseOrder()");
        Arrays.stream(names)
                .filter(x -> x.startsWith("S"))
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        System.out.println("input contain Eri: " + Arrays.stream(names).anyMatch(x -> x.contains("Eri")));
        System.out.println();


        // 6. compare int[] and List <Integer> Stream
        System.out.println("6) average of squares of  int array and List <Integer>");
        Arrays.stream(new int[]{2, 4, 6, 8, 10})
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);

        List<Integer> testDate = Arrays.asList(2, 4, 6, 8, 10);
        // Cannot resolve method 'average' in 'Stream'
        //testDate.stream().map( x-> x*x).average().ifPresent(System.out::println);
        System.out.println("list Stream,  mapToInt(Integer::intValue)");
        testDate.stream().map(x -> x * x).mapToInt(Integer::intValue).average().ifPresent(System.out::println);
        System.out.println("list Stream,  mapToInt(i -> i)");
        testDate.stream().map(x -> x * x).mapToInt(i -> i).average().ifPresent(System.out::println);
        testDate.stream().map(x -> x * x).mapToInt(i -> i).average().getAsDouble();
        System.out.println();


        // 7. Stream from List, filter and print
        System.out.println("7) Stream from List ");
        List<String> people = Arrays.asList("Sophie", "Simon", "Peter", "Sam", "Sarah", "James", "Eric", "Alex");
        people.stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("p"))
                .forEach(System.out::println);

        // 7b stream to List
        List<String> result7b = people.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("List to UpperCase is: " + result7b);


        // 7c start with S and length is 5
        List<String> result7c = people.stream().filter(x -> (x.length() == 5) && x.startsWith("S"))
                .collect(Collectors.toList());
        System.out.println("List filter start with S and length is 5 is: " + result7c);
        System.out.println();


        // 8. Stream rows from text file, sort, filter, and print
        System.out.println("8) Stream rows from text file");

        Stream<String> singer = Files.lines(Paths.get(singerFilePath));
        singer.sorted()
                .filter(x -> x.length() > 8)
                .forEach(System.out::println);
        singer.close();
        System.out.println();


        // 9. Stream rows from text file and save to List
        System.out.println("9) Stream rows from text file to List");
        // Files.lines(Paths.get())
        List<String> singerZhou = Files.lines(Paths.get(singerFilePath))
                .filter(x -> x.contains("Zhou"))
                .collect(Collectors.toList());  // From stream to List
        singerZhou.forEach(x -> System.out.println(x));
        System.out.println();


        // 10. Stream rows from CSV file and count
        System.out.println("10) Stream rows from csv ");
        Stream<String> rows1 = Files.lines(Paths.get(dataFilePath));
        int rowCount = (int) rows1
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .count();
        System.out.println("data.txt has " + rowCount + " rows.");
        rows1.close();
        System.out.println();


        // 11. Stream rows from CSV file, parse data from rows
        // Column "product,category,price" did not fit , tmp remove
        // spark.read.format("csv").option("header", "true")  , try .skip(1)
        System.out.println("11) Stream rows from csv, parse rows ");
        Stream<String> rows2 = Files.lines(Paths.get(dataFilePath));
        rows2
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[2]) > 800)
                .forEach(x -> System.out.println(x[0] + "  " + x[1] + "  " + x[2]));
        rows2.close();
        System.out.println();


        // 12. Stream rows from CSV file, store fields in HashMap
        System.out.println("12) Stream rows from csv, store fields in HashMap ");
        Stream<String> rows3 = Files.lines(Paths.get(dataFilePath));
        Map<String, Integer> map = new HashMap<>();
        map = rows3
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[2]) > 300)
                .collect(Collectors.toMap(
                        x -> x[0],
                        x -> Integer.parseInt(x[2])));
        rows3.close();
        for (String key : map.keySet()) {
            System.out.println(key + "  " + map.get(key));
        }
        System.out.println();

        // 13. Reduction - sum
        System.out.println("13) Sum operation ");
        double total = Stream.of(7.3, 1.5, 4.8)
                .reduce(0.0, (a, b) -> a + b);
        System.out.println("Total = " + total);
        System.out.println(" 1 to 10 sum is: " + IntStream.range(1, 11).sum());
        System.out.println();


        // 14. Reduction - summary statistics
        System.out.println("14) Reduction - summary statistics ");
        IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
                .summaryStatistics();
        System.out.println(summary);
        System.out.println();

        // 15. Sum filter Null
        System.out.println("15) Sum - filter Null ");
        List<Integer> test01 = Arrays.asList(2, 4, 6, 8, null, 10);
        int sum1 = test01.stream().filter(i -> i != null).mapToInt(i -> i).sum();
        System.out.println("test01.stream().filter( i -> i != null ).mapToInt( i -> i).sum() is: " + sum1);
        System.out.println("test01.stream().filter( i -> i != null ).mapToInt( Integer::intValue).sum() is: "
                + test01.stream().filter(i -> i != null).mapToInt(Integer::intValue).sum());
        System.out.println();

        // 16 String array with flatmap
        System.out.println("16) String array with flatmap ");
        String data[][] = new String[][]{
                {"a1", "a2", "a3"}, {"b1", "b2"}, {"a1", "c1"}
        };

        Arrays.stream(data).flatMap(x -> Arrays.stream(x)).forEach(System.out::println);
        Arrays.stream(data).filter(x -> x.length > 2).forEach(x -> System.out.println(x[0] + x[1] + x[2]));
        System.out.println();


        // 17 String List with flatmap
        System.out.println("17) String List with flatmap ");
        List<List<String>> data17 = new ArrayList<List<String>>();
        List<String> list1 = Arrays.asList("a1", "a2", "a3");
        List<String> list2 = Arrays.asList("b1", "b2");
        List<String> list3 = Arrays.asList("a1", "c1");
        data17.add(list1);
        data17.add(list2);
        data17.add(list3);
        data17.stream().forEach(x -> System.out.println(x.toString()));
        data17.stream().flatMap(x -> x.stream()).forEach(System.out::println);
        System.out.println();


        // 18 Word Counts
/*        System.out.println("18) Word Counts ");
        Stream<String> singerTxt = Files.lines(Paths.get(singerFilePath));
        System.out.println("total word is: " + singerTxt.flatMap(line -> Arrays.stream(line.split("\\s+"))).count());
        System.out.println();*/

        // 19 Word Frequency Counts
        System.out.println("19) Word Frequency Counts ");
/*
        Stream<String> singer2 = Files.lines(Paths.get(singerFilePath));
        Stream<String> tokenizedFileData = singer2.flatMap(line -> Arrays.stream(line.split("\\s+")));
        // Stream<String> countPrep = tokenizedFileData.map(word -> (word, 1)); // Spark way did not work
        // tokenizedFileData.forEach(System.out::println);

        Map<String, Integer> newCounterMap = tokenizedFileData.collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));
        System.out.println("newCounterMap is : " + newCounterMap);
        System.out.println("newCounterMap keySet: " + newCounterMap.keySet());
        System.out.println("newCounterMap entrySet: " + newCounterMap.entrySet());
        List<String> test19b = new ArrayList<>();
        for (String key : newCounterMap.keySet()) {
            if (newCounterMap.get(key) > 1) test19b.add(key + ": " + newCounterMap.get(key));
        }
        System.out.println(test19b);
        // only output frequency more than 2
        // [zhou: 2, liu: 2, li: 2]

        System.out.println("newCounterMap filter by count, to list: " +
                newCounterMap.entrySet().stream().filter(entry -> entry.getValue() > 1)
                        .map(entry -> entry.getKey() + ": " +
                                entry.getValue()).collect(Collectors.toList()));

        // newCounterMap filter by count, to list: [zhou=2, liu=2, li=2]


//        Map<String, Long> counterMap = new HashMap<>();
//        tokenizedFileData.collect(Collectors.groupingBy(k -> k, ()-> counterMap,
//                Collectors.counting()) ).forEach( (k, v) -> System.out.println(k.toString() + " " + v.toString()));

        System.out.println();

*/

        // ways to build streams
        // a constant stream
        Stream.generate(() -> "one");

        // a growing stream
        // Stream.iterate("+" , s -> s + "+");

        // a random stream
        ThreadLocalRandom.current().ints();

        // a stream on the letters of a String
        IntStream stream = "hello".chars();

        // a stream on a regular expression
        // Stream <String> words = Pattern.compile("[^\\p{javaLetter}]").splitAsStream(book);


        // a Stream on the lines of a text file
        Stream<String> lines = Files.lines(Paths.get(singerFilePath));


        // StreamBuilder pattern
        Stream.Builder<String> builder = Stream.builder();

        // by chaining the add method
        builder.add("Andy").add("Bob").add("Cain");
        builder.accept("Dave");

        // call the build() method
        Stream<String> stream01 = builder.build();
        stream01.forEach(System.out::println);

        // Map Filter Reduce


        //20 Keyboard Row LeetCode#500
        System.out.println("20) Keyboard Row,  filter by regex ");
        String[] testData = {"Hello", "Alaska", "Dad", "Peace", "Peter"};
        List<String> result = Arrays.stream(testData).filter(w -> w.toLowerCase().
                matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).collect(Collectors.toList());
        System.out.println(result);
        Arrays.stream(testData).filter(w -> w.toLowerCase().
                matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).forEach(System.out::println);
        System.out.println();


        //21  Reverse Words in a String III, LeetCode#557
        System.out.println("21) Reverse Words in a String III ");
        String test21 = "Let's take LeetCode contest";
        System.out.println(Arrays.stream(test21.split(" ")).map(str -> new StringBuilder(str).
                reverse().toString()).collect(Collectors.joining(" ")));
        System.out.println();


        //22 Reverse Words in a String. LeetCode#151
        System.out.println("22) Reverse Words in a String ");
        String test22 = "the sky is blue";
        System.out.println("input is: " + test22);
        // (Arrays.asList(test22.split(" ")).stream()  any better way ? for one line code
        List<String> test22List = Arrays.asList(test22.split(" "));
        Collections.reverse(test22List);
        System.out.println(test22List.stream().collect(Collectors.joining(" ")));

        // IntStream to reverse Array
        String[] test22d = test22.trim().split(" +");
        System.out.println(IntStream.range(1, test22d.length + 1).mapToObj(i -> test22d[test22d.length - i]).
                collect(Collectors.joining(" ")));


        String test22b = "  hello world!  ";
        System.out.println("input is: " + test22b);
        List<String> test22bList = Arrays.asList(test22b.trim().split(" "));
        Collections.reverse(test22bList);
        System.out.println(test22bList.stream().collect(Collectors.joining(" ")));

        String test22c = "a good   example";
        System.out.println("input is: " + test22c);
        List<String> test22cList = Arrays.asList(test22c.trim().split(" +"));
        //List<String> test22cList = Arrays.asList(test22c.trim().split("\\s+"));
        Collections.reverse(test22cList);
        System.out.println(test22cList.stream().collect(Collectors.joining(" ")));
        System.out.println();

        //23 Distribute Candies. LeetCode#575
        System.out.println("23) Distribute Candies. LeetCode#575 ");
        int[] candies = {1, 1, 2, 2, 2, 2, 3, 3, 4, 4, 4, 4};
        System.out.println("canies is " + Arrays.toString(candies));
        System.out.println("result is: " + Math.min(candies.length / 2,
                (Arrays.stream(candies).distinct().count())));
        System.out.println();

        //24 character count of a String. LeetCode#657
        System.out.println("24) character count of a String. LeetCode#657 ");
        String word = "UUUPLLRRRPURLLUP";
        // Java11
/*        Map<String, Long> charCount = word.codePoints().mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(word + " Java11 codePoints, charCount: " + charCount);*/
        // Java8
        Map<String, Long> charCount8 = IntStream.range(0, word.length())
                .mapToObj(i -> word.substring(i, i + 1))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(word + " Java8 IntStream, charCount: " + charCount8);
        Map<String, Long> charCount8b = word.chars().mapToObj(c -> Character.toString((char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println();

        // 25  Jewels and Stones LeetCode#771
        //
        String Jewel = "aAc";
        String Stone = "aAAbbbbdxyza";
        System.out.println("25) Jewels and Stones. LeetCode#771 ");
        System.out.printf("stone is %s \n", Stone);
        System.out.println("Jewel count is : " +
                (int) Stream.of(Stone.split("")).filter(Jewel::contains).count());
        System.out.println();


        // 26  returns a comma-separated string,  if the number is even,preceded by the letter 'e',
        // and preceded by the letter 'o' if the number is odd
        // input list is (3,44), the output should be 'o3,e44'
        System.out.println("26) comma-separated string based on even odd ");
        List<Integer> testDate26 = Arrays.asList(2, 5, 6, 10, 19, 22, 24, 31);
        System.out.println("testDate26 is : " + testDate26);
        String result26 = testDate26.stream().map(x -> (x % 2 == 0) ? "e" + x : "o" + x)
                .collect(Collectors.joining(";"));
        System.out.println("result26 is : " + result26);
        System.out.println();


        // 27 smallest range  LeetCode #908
        System.out.println("27) smallest range of int Array ");
        int[] test27 = {5, 2, 4, 12, 35, 15, 6};
        int K = 3;
        int result27 = Arrays.stream(test27).max().getAsInt() -
                Arrays.stream(test27).min().getAsInt() - 2 * K;
        System.out.println("result27 smallest range is : " + result27);
        System.out.println();


        // 28 Squares of a Sorted Array  LeetCode #977
        System.out.println("28) Squares of a Sorted Array ");
        int[] test28 = {-11, -8, -17, -2, -1, 5, 2, 4, 12, 35, 15, 6};
        System.out.println("test28 input is: " + Arrays.toString(test28));

        int[] result28 = Arrays.stream(test28).map(x -> x * x).sorted().toArray();

        System.out.println("result28 is : " + Arrays.toString(result28));
        System.out.println();

    }

    }
