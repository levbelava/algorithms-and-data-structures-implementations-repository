# Bitonic sort - parallel algorithm for sorting
Bitonic sort operates on bitonic sequences. A sequence is called bitonic if it is first increasing and then decreasing. 
1. A sequence, sorted in increasing order is considered bitonic with a decreasing part being empty.
2. A rotation of a bitonic sequence is also bitonic.

Algorithm works in 2 parts:
1. Form a bitonic sequence from a random input.
2. Sort bitonic sequence formed at step 1.

Complexity:
 Algorithm is capable of sorting N  keys  in  time  complexity of  O(log^2N)  with  O(Nlog^2N) comparators.
 
 Scientific review of current state of the Bitonic Sort algorithm and its improvements: https://pdfs.semanticscholar.org/e888/2ba90c9a3008158d431530cd16ba4fa4449a.pdf
 International Journal of Computer Applications (0975 –8887)Volume 113 –No. 13, March 2015