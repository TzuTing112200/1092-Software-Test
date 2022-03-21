import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class fackPaypalService_1 implements paypalService
{
    public String doDonate()
    {
        return "successed";
    }
}

class fackPaypalService_2 implements paypalService
{
    public String doDonate()
    {
        return "succeed";
    }
}

class fackPaypalService_3 implements paypalService
{
    public String doDonate()
    {
        return "others";
    }
}

@ExtendWith(MockitoExtension.class)
class SoftwareTesting2021Test {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
    }

    @Mock
    Date mockDate;

    @Mock
    Hospital mockHospital;

    SoftwareTesting2021 softwareTesting2021 = new SoftwareTesting2021();
    Student feverStudent = new Student();

    // If a  fever student enter the class on Wednesday, verify that hospital doesn’t do any treatment.
    @org.junit.jupiter.api.Test
    public void test_a() throws InterruptedException{
        softwareTesting2021.setHospital(mockHospital);

        when(mockDate.getWeekday()).thenReturn(4);
        softwareTesting2021.date = mockDate;

        assertTrue(feverStudent.getTemperature() > 37);
        softwareTesting2021.enterClass(feverStudent);

        verify(mockHospital, never()).treatment(feverStudent);
    }

    // If a fever student enter the class on Thursday, assert the output correct.
    @org.junit.jupiter.api.Test
    public void test_b() throws InterruptedException{
        softwareTesting2021.setHospital(mockHospital);

        when(mockDate.getWeekday()).thenReturn(5);
        softwareTesting2021.date = mockDate;

        assertTrue(feverStudent.getTemperature() > 37);
        softwareTesting2021.enterClass(feverStudent);

        assertEquals("Have a class today!\r\nNo! This student should not  come. We will send him/her to hospital. \r\n",
                outputStreamCaptor.toString());
    }

    // Assume 3 students go to hospital.
    // Verify patientLog in hospital will record patient’s studentid with spy method.
    // Don’t stub getLog function.
    @org.junit.jupiter.api.Test
    public void test_c() throws InterruptedException{
        Student student_1 = new Student("309550001",36);
        Student student_2 = new Student("309550002",37);
        Student student_3 = new Student("309550003",38);

        Hospital spyHospital = spy(new Hospital());
        doNothing().when(spyHospital).isolation(isA(Student.class));

        spyHospital.treatment(student_1);
        spyHospital.treatment(student_2);
        spyHospital.treatment(student_3);

//        verify(spyHospital).treatment(student_1);
//        verify(spyHospital).treatment(student_2);
//        verify(spyHospital).treatment(student_3);

        assertEquals("[309550001, 309550002, 309550003]", spyHospital.getLog().toString());
    }

    // Use stub method to test getScore function to avoid connection to outer database.
    @org.junit.jupiter.api.Test
    public void test_d() throws InterruptedException{
        NYCUDatabase stubNYCUDatabase = mock(NYCUDatabase.class);
        when(stubNYCUDatabase.getScore(isA(String.class))).thenReturn(100);
        softwareTesting2021.MyDatabase = stubNYCUDatabase;

        Student student = new Student();
        assertEquals(100, softwareTesting2021.getScore(student.getStudentId()));
    }

    // Implement paypalService interface as a fake object to test donate function.
    @org.junit.jupiter.api.Test
    public void test_e() throws InterruptedException{
        String result;
        fackPaypalService_1 theFackPaypalService_1 = new fackPaypalService_1();
        fackPaypalService_2 theFackPaypalService_2 = new fackPaypalService_2();
        fackPaypalService_3 theFackPaypalService_3 = new fackPaypalService_3();

        result = softwareTesting2021.donate(theFackPaypalService_1);
        assertEquals("Thank you", result);

        result = softwareTesting2021.donate(theFackPaypalService_2);
        assertEquals("Thank you", result);

        result = softwareTesting2021.donate(theFackPaypalService_3);
        assertEquals("Some Bug occurred", result);
    }
}