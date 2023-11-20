package xlsxParser;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

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

    public Sheet getSheet() throws IOException {
        FileInputStream file = new FileInputStream(fileName);

        XSSFWorkbook workbook = new XSSFWorkbook(file);
        Sheet sheet;

        try {
            sheet = workbook.getSheetAt(0);
        } catch (Exception e) {
            throw new IOException(e);
        }

        return sheet;
    }
}
