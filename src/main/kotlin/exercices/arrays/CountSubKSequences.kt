package exercices.arrays

/**
 * Calculates the number of K-Subsequences that there
 * may be in [a] array
 * Complexity O(n)
 *
 * @param a IntArray
 * @param k K-Subsequences
 * @return Returns the number of K-Subsequences that the [a] array has
 */
fun countSubKSequences(a: IntArray, k: Int): Int {
	//Primer exit condition
	if (k > a.size) return 0

	//Variable initialization
	var windowSize = k
	var counter = 0
	var sum = 0
	var idx = 0

	//based on kadane's algorithm
	while (idx < a.size) {

		while (windowSize > 0) {
			sum += a[idx]
			windowSize--
			idx++
		}

		if (sum % k == 0) counter++

		//moving window form the left to the right
		if (windowSize == 0) {
			sum -= a[idx - k]
			windowSize++
		}
	}
	return counter
}
