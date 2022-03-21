import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    Vehicle v = new Vehicle();
    int this_numVehicle = v.totalVehicle();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void testFinalize() {
        int test_numVehicle = this_numVehicle;
        int val_numVehicle;

        v.finalize();
        val_numVehicle = v.totalVehicle();
        this_numVehicle = val_numVehicle;

        assertEquals(val_numVehicle, test_numVehicle - 1);
    }

    @org.junit.jupiter.api.Test
    void setSpeed() {
        int test_speed = 10;
        int val_speed;

        v.setSpeed(test_speed);
        val_speed = v.getSpeed();

        assertEquals(test_speed, val_speed);
    }

    @org.junit.jupiter.api.Test
    void setDir() {
        String test_direction = "test";
        String val_direction;

        v.setDir(test_direction);
        val_direction = v.getDir();

        assertEquals(test_direction, val_direction);
    }

    @org.junit.jupiter.api.Test
    void getSpeed() {
        int test_speed = 10;
        int val_speed;

        v.setSpeed(test_speed);
        val_speed = v.getSpeed();

        assertEquals(test_speed, val_speed);
    }

    @org.junit.jupiter.api.Test
    void getDir() {
        String test_direction = "test";
        String val_direction;

        v.setDir(test_direction);
        val_direction = v.getDir();

        assertEquals(test_direction, val_direction);
    }

    @org.junit.jupiter.api.Test
    void totalVehicle() {
        int test_numVehicle = this_numVehicle;
        int val_numVehicle;

        val_numVehicle = v.totalVehicle();

        assertEquals(test_numVehicle, val_numVehicle);
    }
}