# Financial Forecasting

This exercise implements a recursive financial forecasting tool that predicts a
future value using historical growth rates.

## Recursion

Recursion is a technique where a method solves a problem by calling itself with a
smaller version of the same problem. A recursive solution needs:

- A base case that stops the recursion.
- A recursive case that moves the problem closer to the base case.

For forecasting, the repeated task is applying the growth rate one year at a
time until the required number of future years has been calculated.

## Implementation

The program:

1. Stores past annual growth rates in an array.
2. Calculates the average growth rate recursively.
3. Applies that average growth rate recursively to predict the future value.

Example formula used each year:

```text
nextValue = currentValue * (1 + averageGrowthRate)
```

## Time complexity

Let `n` be the number of past growth rates and `y` be the number of future years.

| Operation | Time complexity | Reason |
| --- | --- | --- |
| Recursive average growth calculation | O(n) | Each growth rate is visited once |
| Recursive future value calculation | O(y) | One recursive call is made for each year |
| Total | O(n + y) | Both recursive processes run once |

The space complexity is O(n + y) because each recursive call uses stack space.

## Optimization

This recursive solution does not repeat the same subproblem many times, so its
time complexity is already efficient for this simple forecast. However, recursion
can still become expensive when there are many calls because each call uses stack
memory.

Possible optimizations:

- Use an iterative loop to avoid deep recursion and reduce stack usage.
- Store repeated recursive results with memoization if the forecasting model is
  changed to calculate overlapping subproblems.
- Cache the average growth rate if multiple forecasts use the same historical
  data.
