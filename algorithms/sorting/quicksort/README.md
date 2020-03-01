# Quicksort - an efficient algorithm for sorting

Quicksort is a divide-and-conquer algorithm. It works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot. The sub-arrays are then sorted recursively. This can be done in-place, requiring small additional amounts of memory to perform the sorting. 

Efficient implementations of Quicksort are not a stable sort, meaning that the relative order of equal sort items is not preserved.

General scheme:
1. Pick an element, called a pivot, from the array.
2. Partitioning: reorder the array so that all elements with values less than the pivot come before the pivot, while all elements with values greater than the pivot come after it (equal values can go either way).
3. Recursively apply the above steps to the sub-array of elements with smaller values and separately to the sub-array of elements with greater values.

Complexity:
* Best O(n)
* Average O(n log n) comparisons to sort n items. 
* Worst case O(n^2) comparisons


Notes:
There are two main partitioning schemes for quicksort. Original Hoare scheme which is efficient and Lomuto scheme which is easy to understand
 and was popularized by Cormen Bentley. However, Lomuto scheme is a lot slower and should not be used for library implementation.