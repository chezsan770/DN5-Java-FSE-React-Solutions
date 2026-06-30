public class FinancialForecastingTest {
    public static void main(String[] args) {
        double presentValue = 10000.00;
        double[] pastGrowthRates = {0.05, 0.08, 0.04, 0.06};
        int yearsToForecast = 3;

        double averageGrowthRate = FinancialForecaster.calculateAverageGrowthRate(pastGrowthRates);
        double forecastedValue = FinancialForecaster.forecastFutureValue(
                presentValue,
                pastGrowthRates,
                yearsToForecast
        );

        System.out.printf("Present value: %.2f%n", presentValue);
        System.out.printf("Average growth rate: %.2f%%%n", averageGrowthRate * 100);
        System.out.printf("Forecasted value after %d years: %.2f%n", yearsToForecast, forecastedValue);

        double expectedValue = presentValue * Math.pow(1 + averageGrowthRate, yearsToForecast);
        if (Math.abs(forecastedValue - expectedValue) > 0.001) {
            throw new AssertionError("Forecasted value does not match expected value.");
        }

        System.out.println("Test passed: recursive financial forecasting works correctly.");
    }
}
