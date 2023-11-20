import models.Section;
import models.Student;
import org.apache.poi.ss.usermodel.Sheet;
import xlsxParser.Parser;
import xlsxParser.Reader;

public class Main {
    public static void main(String[] args) throws Exception {
        Reader reader = new Reader("basicprogramming.xlsx");

        Sheet sheet = reader.getSheet();
        Parser parser = new Parser(sheet);
        var sections = parser.parseAndGetSections();
        var students = parser.parseAndGetStudents();

        for (Student student: students) {
            System.out.println(student.getName() + " " +
                               student.getSurname() + " " +
                               student.getUlearnId() + " " +
                               student.getEmail() + " " +
                               student.getGroup());
        }


        for (Section section : sections) {
            System.out.println(section.getName());
        }
    }
}