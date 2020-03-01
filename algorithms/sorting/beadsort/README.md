# Bead sort - gravity sort
Bead sort is a natural sorting algorithm developed in 2002. Digital and analog hardware implementations can achieve of O(n) time complexity, however software implementation is significantly slower and can only be used to sort lists of positive integers. Also software implementation uses memory a lot.
Some limitations can be overcome by such modifications of algorithm as:
* to sort negative numbers one can add "baseline value" for every element so that numbers will be positive;
* inefficiency of single thread implementation can be overcome by using parallel implementation since this algorithms parallels naturally.
 
 
Complexity:
* Memory complexity O(n^2)
* Hardware specific average performance O(n)
