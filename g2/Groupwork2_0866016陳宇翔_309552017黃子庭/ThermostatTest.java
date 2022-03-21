import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ThermostatTest {
    @Test
    void test_PC_True()
    {
        ProgrammedSettings programmedSettings = new ProgrammedSettings();
        programmedSettings.setSetting(Period.DAY, DayType.WEEKDAY, 30);

        Thermostat thermostat = new Thermostat();

        thermostat.setPeriod(Period.DAY);
        thermostat.setDay(DayType.WEEKDAY);
        thermostat.setCurrentTemp(20);
        thermostat.setThresholdDiff(5);
        thermostat.setOverride(true);
        thermostat.setOverTemp(30);
        thermostat.setTimeSinceLastRun(20);
        thermostat.setMinLag(10);

        boolean result = thermostat.turnHeaterOn(programmedSettings);

        assertEquals(true, result);
    }

    @Test
    void test_PC_False()
    {
        ProgrammedSettings programmedSettings = new ProgrammedSettings();
        programmedSettings.setSetting(Period.DAY, DayType.WEEKDAY, 35);

        Thermostat thermostat = new Thermostat();

        thermostat.setPeriod(Period.DAY);
        thermostat.setDay(DayType.WEEKDAY);
        thermostat.setCurrentTemp(40);
        thermostat.setThresholdDiff(5);
        thermostat.setOverride(true);
        thermostat.setOverTemp(40);
        thermostat.setTimeSinceLastRun(5);
        thermostat.setMinLag(10);

        boolean result = thermostat.turnHeaterOn(programmedSettings);

        assertEquals(false, result);
    }

    @Test
    void test_CC_Case1()
    {
        ProgrammedSettings programmedSettings = new ProgrammedSettings();
        programmedSettings.setSetting(Period.DAY, DayType.WEEKDAY, 30);

        Thermostat thermostat = new Thermostat();

        thermostat.setPeriod(Period.DAY);
        thermostat.setDay(DayType.WEEKDAY);
        thermostat.setCurrentTemp(20);
        thermostat.setThresholdDiff(5);
        thermostat.setOverride(false);
        thermostat.setOverTemp(30);
        thermostat.setTimeSinceLastRun(5);
        thermostat.setMinLag(10);

        boolean result = thermostat.turnHeaterOn(programmedSettings);

        assertEquals(false, result);
    }

    @Test
    void test_CC_Case2()
    {
        ProgrammedSettings programmedSettings = new ProgrammedSettings();
        programmedSettings.setSetting(Period.DAY, DayType.WEEKDAY, 30);

        Thermostat thermostat = new Thermostat();

        thermostat.setPeriod(Period.DAY);
        thermostat.setDay(DayType.WEEKDAY);
        thermostat.setCurrentTemp(40);
        thermostat.setThresholdDiff(5);
        thermostat.setOverride(true);
        thermostat.setOverTemp(40);
        thermostat.setTimeSinceLastRun(20);
        thermostat.setMinLag(10);

        boolean result = thermostat.turnHeaterOn(programmedSettings);

        assertEquals(false, result);
    }

    @Test
    void test_CACC_TTFT()
    {
        ProgrammedSettings programmedSettings = new ProgrammedSettings();
        programmedSettings.setSetting(Period.DAY, DayType.WEEKDAY, 30);

        Thermostat thermostat = new Thermostat();

        thermostat.setPeriod(Period.DAY);
        thermostat.setDay(DayType.WEEKDAY);
        thermostat.setCurrentTemp(20);
        thermostat.setThresholdDiff(5);
        thermostat.setOverride(true);
        thermostat.setOverTemp(40);
        thermostat.setTimeSinceLastRun(20);
        thermostat.setMinLag(10);

        boolean result = thermostat.turnHeaterOn(programmedSettings);

        assertEquals(true, result);
    }

    @Test
    void test_CACC_FTFT()
    {
        ProgrammedSettings programmedSettings = new ProgrammedSettings();
        programmedSettings.setSetting(Period.DAY, DayType.WEEKDAY, 30);

        Thermostat thermostat = new Thermostat();

        thermostat.setPeriod(Period.DAY);
        thermostat.setDay(DayType.WEEKDAY);
        thermostat.setCurrentTemp(40);
        thermostat.setThresholdDiff(5);
        thermostat.setOverride(true);
        thermostat.setOverTemp(40);
        thermostat.setTimeSinceLastRun(20);
        thermostat.setMinLag(10);

        boolean result = thermostat.turnHeaterOn(programmedSettings);

        assertEquals(false, result);
    }

    @Test
    void test_CACC_FTTT()
    {
        ProgrammedSettings programmedSettings = new ProgrammedSettings();
        programmedSettings.setSetting(Period.DAY, DayType.WEEKDAY, 30);

        Thermostat thermostat = new Thermostat();

        thermostat.setPeriod(Period.DAY);
        thermostat.setDay(DayType.WEEKDAY);
        thermostat.setCurrentTemp(40);
        thermostat.setThresholdDiff(5);
        thermostat.setOverride(false);
        thermostat.setOverTemp(20);
        thermostat.setTimeSinceLastRun(20);
        thermostat.setMinLag(10);

        boolean result = thermostat.turnHeaterOn(programmedSettings);

        assertEquals(false, result);
    }

    @Test
    void test_CACC_FFTT()
    {
        ProgrammedSettings programmedSettings = new ProgrammedSettings();
        programmedSettings.setSetting(Period.DAY, DayType.WEEKDAY, 30);

        Thermostat thermostat = new Thermostat();

        thermostat.setPeriod(Period.DAY);
        thermostat.setDay(DayType.WEEKDAY);
        thermostat.setCurrentTemp(40);
        thermostat.setThresholdDiff(5);
        thermostat.setOverride(false);
        thermostat.setOverTemp(20);
        thermostat.setTimeSinceLastRun(20);
        thermostat.setMinLag(10);

        boolean result = thermostat.turnHeaterOn(programmedSettings);

        assertEquals(false, result);
    }

    @Test
    void test_CACC_TTTT()
    {
        ProgrammedSettings programmedSettings = new ProgrammedSettings();
        programmedSettings.setSetting(Period.DAY, DayType.WEEKDAY, 30);

        Thermostat thermostat = new Thermostat();

        thermostat.setPeriod(Period.DAY);
        thermostat.setDay(DayType.WEEKDAY);
        thermostat.setCurrentTemp(20);
        thermostat.setThresholdDiff(5);
        thermostat.setOverride(true);
        thermostat.setOverTemp(20);
        thermostat.setTimeSinceLastRun(20);
        thermostat.setMinLag(10);

        boolean result = thermostat.turnHeaterOn(programmedSettings);

        assertEquals(true, result);
    }

    @Test
    void test_CACC_TTTF()
    {
        ProgrammedSettings programmedSettings = new ProgrammedSettings();
        programmedSettings.setSetting(Period.DAY, DayType.WEEKDAY, 30);

        Thermostat thermostat = new Thermostat();

        thermostat.setPeriod(Period.DAY);
        thermostat.setDay(DayType.WEEKDAY);
        thermostat.setCurrentTemp(20);
        thermostat.setThresholdDiff(5);
        thermostat.setOverride(true);
        thermostat.setOverTemp(20);
        thermostat.setTimeSinceLastRun(5);
        thermostat.setMinLag(10);

        boolean result = thermostat.turnHeaterOn(programmedSettings);

        assertEquals(false, result);
    }
}