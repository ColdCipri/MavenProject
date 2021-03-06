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
import validation.ValidationException;

import java.time.LocalDate;
import java.util.stream.StreamSupport;

import static java.io.FileDescriptor.in;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    TemaFileRepository temaFileRepository = new TemaFileRepository("fisiere/Teme.txt");
    StudentValidator studentValidator;
    TemaValidator temaValidator;
    String filenameStudent = "fisiere/Studenti.xml";
    String filenameTema = "fisiere/Teme.xml";
    String filenameNota = "fisiere/Note.xml";

    StudentXMLRepo studentXMLRepository;
    TemaXMLRepo temaXMLRepository;
    NotaValidator notaValidator;
    NotaXMLRepo notaXMLRepository;
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
    }


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
        service.addTema(new Tema("HW1","Homework for lab4",5,4));
        Tema found = service.findTema("HW1");
        assertEquals("HW1",found.getID());
    }

    @Test
    public void AddGradeInLab4(){
        service.addNota(new Nota("Nota10","33","Tema1",10, LocalDate.of(2018,11,10)),"Congrats!");
        Nota nota = service.findNota("Nota10");
        assertEquals("33",nota.getIdStudent());
    }

    @Test
    public void RuntAllTests(){
        AddStudentInLab4();
        AddAsignmentInLab4();
        AddGradeInLab4();
    }

    //Lab2 Take Home EC
    @Test
    public void addStudentAssertTrue(){
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
        service.addStudent(new Student("id","Name1",922,"email@gmail.com"));
        assertEquals("id",service.findStudent("id").getID());
    }

    //works for BVA too
    @Test
    public void addStudentAssertFalse(){
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
        try {
            service.addStudent(new Student("","Name1",922,"email@gmail.com"));
        } catch (Exception e){
            assertFalse(false);
        }
    }

    @Test
    public void addStudentAssertFalse2(){
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
        try {
            service.addStudent(new Student("id", "Name1", 922, "email@gmail.com"));
        } catch (Exception e){
            assertFalse(false);
        }
    }

    @Test
    public void addStudentAssertFalse3(){
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
        try {
            service.addStudent(new Student("id", "", 922, "email@gmail.com"));
        } catch (Exception e){
            assertFalse(false);
        }
    }

    @Test
    public void addStudentAssertFalse4(){
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
        try {
            service.addStudent(new Student("id", "Name1",-3, "email@gmail.com"));
        } catch (Exception e){
            assertFalse(false);
        }
    }


    //Lab2 Take Home BVA
    @Test
    public void addStudentId(){
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

        Student stud = new Student(" ","Name1",922,"email@gmail.com");
        /*Student stud = new Student("","Name1",922,"email@gmail.com");
        Student stud = new Student("123","Name1",922,"email@gmail.com");
        Student stud = new Student("abc","Name1",922,"email@gmail.com");
        try {
            service.addStudent(stud);
            assertTrue(true);
        } catch (Exception e){
            assertTrue(false);
        }
    }

    @Test
    public void addStudentNume(){
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

        Student stud = new Student("id10"," ",922,"email@gmail.com");
        /*Student stud = new Student("id10","",922,"email@gmail.com");
        Student stud = new Student("id10","abc",922,"email@gmail.com");
        Student stud = new Student("id10","123",922,"email@gmail.com");
        try {
            service.addStudent(stud);
            assertTrue(true);
        } catch (Exception e){
            assertTrue(false);
        }
    }

    @Test
    public void addStudentGrupa(){
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

        Student stud = new Student("id10","Nume1",999999999,"email@gmail.com");
        /*Student stud = new Student("id10","Nume1",0,"email@gmail.com");
        Student stud = new Student("id10","Nume1",1,"email@gmail.com");
        Student stud = new Student("id10","Nume1",-1,"email@gmail.com");
            try {
            service.addStudent(stud);
            assertTrue(true);
        } catch (Exception e){
            assertTrue(false);
        }
    }



    public Tema addTema(Tema tema){
        this.validate(tema);
        return temaFileRepository.save(tema);
    }

    public void validate(Tema entity) throws ValidationException{
        if (entity.getID().equals("") || entity.getID() == null)
            throw new ValidationException("Numar tema invalid!");

        if (entity.getDescriere().equals(""))
            throw new ValidationException("Descriere invalida!");

        if (entity.getDeadline() < 1 || entity.getDeadline() > 14)
            throw new ValidationException("Deadline invalid! Trebuie sa fie intre 1 si 14!");

        if (entity.getPrimire() < 1 || entity.getPrimire() > 14)
            throw new ValidationException("Invalid! Saptamana cand este primita tema trebuie sa fie intre 1 si 14");
    }

    @Test
    public void addTemaIdWBT(){
        try{
            Tema entity = addTema(new Tema("","Lab2",7,5));
            assertFalse(true);
        } catch (Exception e){
            assertFalse(false);
        }
    }

    @Test
    public void addTemaDescriereWBT(){
        try{
            Tema entity = addTema(new Tema("id13","",7,5));
            assertFalse(true);
        } catch (Exception e){
            assertFalse(false);
        }
    }

    @Test
    public void addTemaDeadlineWBT(){
        try{
            Tema entity = addTema(new Tema("id13","Lab2",20,5));
            assertFalse(true);
        } catch (Exception e){
            assertFalse(false);
        }
    }

    @Test
    public void addTemaPrimireWBT(){
        try{
            Tema entity = addTema(new Tema("id13","Lab2",7,0));
            assertFalse(true);
        } catch (Exception e){
            assertFalse(false);
        }
    }

    @Test
    public void addTemaAssertTrueWBT(){
        try{
            Tema entity = addTema(new Tema("id13","Lab2",7,5));
            assertTrue(true);
        } catch (Exception e){
            assertTrue(false);
        }
    }*/

    //Lab4 TH

    @Test
    public void addStudentTD(){
        studentValidator = new StudentValidator();
        temaValidator = new TemaValidator();
        filenameStudent = "fisiere/Studenti.xml";
        filenameTema = "fisiere/Teme.xml";
        filenameNota = "fisiere/Note.xml";

        studentXMLRepository = new StudentXMLRepo(filenameStudent);
        temaXMLRepository = new TemaXMLRepo(filenameTema);
        notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        notaXMLRepository = new NotaXMLRepo(filenameNota);
        service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

        service.addStudent(new Student("10","Vasile", 233,"vasile@gmail.com"));
        Student found = service.findStudent("10");
        assertNotNull(found);
    }

    @Test
    public void addAssignmentTD(){
        this.service.addTema(new Tema("Tema10","Laborator3",11,9));
        Tema found = service.findTema("Tema10");
        System.out.println(found.toString());
        assertNotNull(found);
    }

    @Test
    public void addGradeTD(){
        this.service.addNota(new Nota("Nota10","10","Tema10",10,LocalDate.now()),"Congratulations" );
        Nota found = service.findNota("Nota10");
        assertNotNull(found);
    }

    @Test
    public void IncrIntegr1(){
        addStudentTD();
        addAssignmentTD();
    }

    @Test
    public void IncrIntegr2(){
        addStudentTD();
        addAssignmentTD();
        addGradeTD();
    }
}