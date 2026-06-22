public class BuilderPatternTest {
    public static void main(String[] args) {
        Computer officeComputer = new Computer.Builder()
                .setCpu("Intel Core i5")
                .setRam("16 GB")
                .setStorage("512 GB SSD")
                .build();

        Computer gamingComputer = new Computer.Builder()
                .setCpu("AMD Ryzen 9")
                .setRam("32 GB")
                .setStorage("2 TB SSD")
                .setGraphicsCard("NVIDIA RTX 4080")
                .setBluetoothEnabled(true)
                .build();

        System.out.println("Office configuration: " + officeComputer);
        System.out.println("Gaming configuration: " + gamingComputer);

        if (!"Integrated Graphics".equals(officeComputer.getGraphicsCard())) {
            throw new AssertionError("The default graphics option was not applied.");
        }

        if (!gamingComputer.isBluetoothEnabled()) {
            throw new AssertionError("The gaming computer should have Bluetooth enabled.");
        }

        System.out.println("Test passed: different Computer configurations were built successfully.");
    }
}
