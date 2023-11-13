package org.example;

import com.opencsv.CSVReader;

import static csvParser.Parser.parser;
import static csvParser.Reader.readData;

public class Main {
    public static void main(String[] args) {
        CSVReader csvReader = readData("basicprogramming.csv");
        parser(csvReader);
    }
}