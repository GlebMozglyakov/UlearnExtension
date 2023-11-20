package csvParser;

import com.opencsv.CSVReader;

public class Parser {
    private final CSVReader csvReader;

    public Parser(CSVReader csvReader) {
        if (csvReader != null) {
            this.csvReader = csvReader;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void parseCsv() {
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

