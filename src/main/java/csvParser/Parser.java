package csvParser;

import com.opencsv.CSVReader;

public class Parser {
    public static void parser(CSVReader csvReader) {
        String[] nextRecord;

        try {
            while ((nextRecord = csvReader.readNext()) != null) {
                for (String cell : nextRecord) {

                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
            throw new IllegalArgumentException(e);
        }
    }
}

