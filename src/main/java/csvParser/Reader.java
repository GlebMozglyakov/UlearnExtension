package csvParser;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static CSVReader readData(String file)
    {
        try {
            FileReader filereader = new FileReader(file);

            CSVParser parser = new CSVParserBuilder().withSeparator( ';' ).build();

            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withCSVParser(parser)
                    .build();

            return csvReader;
        }
        catch (Exception e) {
            //e.printStackTrace();
            throw new IllegalArgumentException(e);
        }
    }
}
