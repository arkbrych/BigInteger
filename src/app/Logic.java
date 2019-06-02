package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Logic {

    void start() {

        String fileName = "numbers.txt";
        List<String> listFromFile = ScannerReader(fileName);

        int num1 = Integer.parseInt(listFromFile.get(0));
        int num2 = Integer.parseInt(listFromFile.get(1));
        int num3 = Integer.parseInt(listFromFile.get(2));

        System.out.println("Sum of first three numbers is: " + addInt(num1,num2,num3));

        BigInteger num4 = new  BigInteger(listFromFile.get(3));
        BigInteger num5 = new  BigInteger(listFromFile.get(4));
        System.out.println("Sum of two last number is: " + addBigInteger(num4, num5));


    }


    private List<String> ScannerReader(String fileName) {
        File file = new File(fileName);
        System.out.println(file.getAbsolutePath());
        List<String> list = new ArrayList<>();
        try (
                Scanner scan = new Scanner(file)
        ) {
            while (scan.hasNextLine()) {
                String lineFromFile = scan.nextLine();
                System.out.println(lineFromFile);
                list.add(lineFromFile);
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        return list;
    }

    private int addInt(int num1, int num2,int num3){
        return num1+num2+num3;
    }

    private BigInteger addBigInteger(BigInteger num1, BigInteger num2){
        return num1.add(num2);
    }
}