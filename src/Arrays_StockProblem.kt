class Arrays_StockProblem {

    class Solution() {
        fun maxProfit(array: IntArray): Int {
            var profit: Int = 0;
            var dif: Int = 0

            for (i in 0 until array.size - 1) {
                dif = array[i + 1] - array[i]
                if (dif > 0) profit += dif
            }
            return profit
        }
    }
}
    fun main() {
        val sol: Arrays_StockProblem.Solution = Arrays_StockProblem.Solution();
        val profit = sol.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4))
        println(profit)
    }