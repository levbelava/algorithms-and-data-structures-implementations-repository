# Bitonic sort - parallel algorithm for sorting
Bitonic sort operates on bitonic sequences. A sequence is called bitonic if it is first increasing and then decreasing. 
1. A sequence, sorted in increasing order is considered bitonic with a decreasing part being empty.
2. A rotation of a bitonic sequence is also bitonic.

Algorithm works in 2 parts:
1. Form a bitonic sequence from a random input.
2. Sort bitonic sequence formed at step 1.