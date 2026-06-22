# E-commerce Platform Search Function

This exercise implements linear search on an unsorted product array and binary
search on an array sorted by `productId`.

## Big O notation

Big O notation describes how an algorithm's time or space requirements grow as
the input size `n` increases. It makes algorithms easier to compare independently
of hardware speed and small implementation differences.

## Search complexity

| Algorithm | Best case | Average case | Worst case | Requirement |
| --- | --- | --- | --- | --- |
| Linear search | O(1) | O(n) | O(n) | No sorting required |
| Binary search | O(1) | O(log n) | O(log n) | Data must be sorted |

- The best case occurs when the desired product is checked immediately.
- The average case represents a typical successful or unsuccessful search.
- The worst case occurs when every relevant position must be considered before
  finding the product or determining that it is absent.

## Analysis

Linear search is simple and works directly on unsorted or frequently changing
data, but its running time grows linearly with the number of products. Binary
search eliminates half of the remaining search range with every comparison, so
it scales much better for a large catalogue.

Binary search is the better option when the platform performs many lookups on a
product list that can be kept sorted by ID. Maintaining a sorted array has its own
insertion cost, so a real e-commerce platform with frequent updates would usually
use an indexed data structure or database index rather than repeatedly sorting an
array. For this array-based exercise, binary search provides the faster lookup.
