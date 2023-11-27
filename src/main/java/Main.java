import db.StudentManager;
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

        int index = 0;

        for (Student currentStudent: students) {
            System.out.println(currentStudent.getName() + " " +
                               currentStudent.getSurname() + " " +
                               currentStudent.getUlearnId() + " " +
                               currentStudent.getEmail() + " " +
                               currentStudent.getGroup());
            if (index > 25 && index < 30) {
                StudentManager.addStudent(currentStudent);
            }

            index++;
            if (index > 50) {
                break;
            }
        }

        /*
        for (Section section : sections) {
            System.out.println(section.getName());
        }

         */
    }
}