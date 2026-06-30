public final class FinancialForecaster {
    private FinancialForecaster() {
    }

    public static double forecastFutureValue(double presentValue, double[] pastGrowthRates, int years) {
        validateInputs(presentValue, pastGrowthRates, years);

        double averageGrowthRate = calculateAverageGrowthRate(pastGrowthRates);
        return calculateFutureValueRecursive(presentValue, averageGrowthRate, years);
    }

    public static double calculateAverageGrowthRate(double[] pastGrowthRates) {
        if (pastGrowthRates == null || pastGrowthRates.length == 0) {
            throw new IllegalArgumentException("Past growth rates cannot be empty.");
        }

        double totalGrowthRate = sumGrowthRatesRecursive(pastGrowthRates, 0);
        return totalGrowthRate / pastGrowthRates.length;
    }

    private static double calculateFutureValueRecursive(double currentValue, double growthRate, int remainingYears) {
        if (remainingYears == 0) {
            return currentValue;
        }

        double nextYearValue = currentValue * (1 + growthRate);
        return calculateFutureValueRecursive(nextYearValue, growthRate, remainingYears - 1);
    }

    private static double sumGrowthRatesRecursive(double[] growthRates, int index) {
        if (index == growthRates.length) {
            return 0;
        }

        return growthRates[index] + sumGrowthRatesRecursive(growthRates, index + 1);
    }

    private static void validateInputs(double presentValue, double[] pastGrowthRates, int years) {
        if (presentValue < 0) {
            throw new IllegalArgumentException("Present value cannot be negative.");
        }

        if (pastGrowthRates == null || pastGrowthRates.length == 0) {
            throw new IllegalArgumentException("Past growth rates cannot be empty.");
        }

        if (years < 0) {
            throw new IllegalArgumentException("Years cannot be negative.");
        }
    }
}
