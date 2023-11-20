package xlsxParser;

import models.Student;
import models.Section;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class Parser {
    private final Sheet sheet;

    public Parser(Sheet sheet) {
        if (sheet == null) {
            throw new IllegalArgumentException("Лист должен быть проинициализирован");
        }

        this.sheet = sheet;
    }

    public List<Student> parseAndGetStudents() {
        ArrayList<Student> students = new ArrayList<>();
        Iterator<Row> rows = sheet.rowIterator();

        while (rows.hasNext()) {
            Row currentRow = rows.next();
            Iterator<Cell> cells = currentRow.cellIterator();
            int columnIndex = 0;
            Student currentStudent = new Student();

            while (columnIndex < 4) {
                Cell currentCell = cells.next();
                String contentCell = encodeToCP1251(currentCell.getStringCellValue());

                if (isIncorrectStudentCell(contentCell)) {
                    break;
                }

                switch (columnIndex) {
                    case 0:
                        parseNameAndSurnameCurrentStudent(contentCell, currentStudent);
                        break;
                    case 1:
                        parseUlearnIdCurrentStudent(contentCell, currentStudent);
                        break;
                    case 2:
                        parseEmailCurrentStudent(contentCell, currentStudent);
                        break;
                    case 3:
                        parseGroupCurrentStudent(contentCell, currentStudent);
                        break;
                }

                columnIndex++;
            }
            if (currentStudent.getName() != null) {
                students.add(currentStudent);
            }
        }

        return students;
    }

    public List<Section> parseAndGetSections() {
        ArrayList<Section> sections = new ArrayList<Section>();
        Row sectionsRow = sheet.getRow(0);
        Iterator<Cell> sectionsCells = sectionsRow.cellIterator();
        int sectionId = 1;

        while (sectionsCells.hasNext()) {
            Cell sectionCell = sectionsCells.next();
            String contentCell = encodeToCP1251(sectionCell.getStringCellValue().trim());

            if (isCorrectSectionCell(contentCell)) {
                Section section = new Section(sectionId, contentCell);
                sections.add(section);
                sectionId++;
            }
        }

        return sections;
    }

    private void parseNameAndSurnameCurrentStudent(String contentCell, Student currentStudent) {
        String[] data = contentCell.split(" ");

        if (data.length == 2) {
            currentStudent.setName(data[1]);
            currentStudent.setSurname(data[0]);
        }
    }

    private void parseUlearnIdCurrentStudent(String contentCell, Student currentStudent) {
        UUID uuid = UUID.fromString(contentCell);
        currentStudent.setUlearnId(uuid);
    }

    private void parseEmailCurrentStudent(String contentCell, Student currentStudent) {
        currentStudent.setEmail(contentCell);
    }

    private void parseGroupCurrentStudent(String contentCell, Student currentStudent) {
        currentStudent.setGroup(contentCell);
    }

    private boolean isIncorrectStudentCell(String contentCell) {
        return  contentCell.isEmpty() ||
                contentCell.equals("Фамилия Имя") ||
                contentCell.equals("Максимум:");
    }

    private boolean isCorrectSectionCell(String contentCell) {
        return  !contentCell.equals("За весь курс") &&
                !contentCell.equals("Преподавателю о курсе") &&
                !contentCell.isEmpty();
    }

    public static String encodeToCP1251(String stringToEncode) {
        if (stringToEncode == null) {
            throw new IllegalArgumentException();
        }

        byte[] stringBytes = stringToEncode.getBytes(StandardCharsets.UTF_8);

        return new String(stringBytes, Charset.forName("CP1251"));
    }
}