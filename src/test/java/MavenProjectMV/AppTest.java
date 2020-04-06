package MavenProjectMV;

import domain.Nota;
import domain.Student;
import domain.Tema;
import org.junit.Test;
import repository.*;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;

import java.time.LocalDate;
import java.util.stream.StreamSupport;

import static java.io.FileDescriptor.in;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    Service service;

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    /*@Test
    public void testAddStudent(){
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        //StudentFileRepository studentFileRepository = new StudentFileRepository(filenameStudent);
        //TemaFileRepository temaFileRepository = new TemaFileRepository(filenameTema);
        //NotaValidator notaValidator = new NotaValidator(studentFileRepository, temaFileRepository);
        //NotaFileRepository notaFileRepository = new NotaFileRepository(filenameNota);

        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

        service.addStudent(new Student("10","Vasile", 233,"vasile@gmail.com"));
        Student found = service.findStudent("10");
        assertNotNull(found);
    }

    @Test
    public void testAddSecondStudent(){
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        //StudentFileRepository studentFileRepository = new StudentFileRepository(filenameStudent);
        //TemaFileRepository temaFileRepository = new TemaFileRepository(filenameTema);
        //NotaValidator notaValidator = new NotaValidator(studentFileRepository, temaFileRepository);
        //NotaFileRepository notaFileRepository = new NotaFileRepository(filenameNota);

        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

        service.addStudent(new Student("11","Vasile", 233,"vasile@gmail.com"));
        Student found = service.findStudent("11");
        assertNotNull(found);
    }

    @Test
    public void testAddFirstAssignment(){
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        //StudentFileRepository studentFileRepository = new StudentFileRepository(filenameStudent);
        //TemaFileRepository temaFileRepository = new TemaFileRepository(filenameTema);
        //NotaValidator notaValidator = new NotaValidator(studentFileRepository, temaFileRepository);
        //NotaFileRepository notaFileRepository = new NotaFileRepository(filenameNota);

        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

        service.addTema(new Tema("11", "Lab 1",2, 4));
        Tema found = service.findTema("11");
        assertEquals("11", found.getID());
    }

    @Test
    public void testAddSecondAssignment(){
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        //StudentFileRepository studentFileRepository = new StudentFileRepository(filenameStudent);
        //TemaFileRepository temaFileRepository = new TemaFileRepository(filenameTema);
        //NotaValidator notaValidator = new NotaValidator(studentFileRepository, temaFileRepository);
        //NotaFileRepository notaFileRepository = new NotaFileRepository(filenameNota);

        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

        //delete tema 3 from xml
        service.deleteTema("3");
        assertEquals(StreamSupport.stream(service.getAllTeme().spliterator(), false).count(),7);
    }

    @Test
    public void runTests(){
        testAddFirstAssignment();
        testAddSecondAssignment();
    }*/
    //BIG BANG INTEGRATION
    @Test
    public void AddStudentInLab4(){
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";
        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        this.service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);
        this.service.deleteStudent("33");
        service.addStudent(new Student("33","TestStudentLab4",933,"email@yahoo.com"));
        assertEquals("33",service.findStudent("33").getID());

    }

    @Test
    public void AddAsignmentInLab4(){
        service.deleteTema("Tema1");
        service.addTema(new Tema("Tema1","Homework for lab4",5,4));
        assertTrue(service.findTema("Tema1").getID().equals("Tema1"));
    }

    @Test
    public void AddGradeInLab4(){
        service.addNota(new Nota("Nota10","33","Tema1",10, LocalDate.of(2018,11,10)),"Congrats!");
        Nota nota = service.findNota("Nota10");
        assertNotNull(nota);
    }

    @Test
    public void RuntAllTests(){
        AddStudentInLab4();
        AddAsignmentInLab4();
        AddGradeInLab4();
    }


}
