package csvParser;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileReader;

public class Reader {
    private final String fileName;

    public Reader(String fileName) {
        File file = new File(fileName);

        if (file.exists()) {
            this.fileName = fileName;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getFileName() {
        return fileName;
    }

    public CSVReader readFile()
    {
        try {
            FileReader filereader = new FileReader(fileName);

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
