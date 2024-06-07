fun main( args : Array<String>) {
  val array = intArrayOf(1,2,3,6,2,3,4,7,8)
  print(isNStraightHand(array, 3))
}


fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
   if (hand.size % groupSize != 0) return false

   val sortedArray = hand
   sortedArray.sort()
   sortedArray.forEach { print ("$it, ") }
   for (i in 0 until sortedArray.size - 1){
    if (sortedArray[i] != (sortedArray[i+1] - 1)) return false
   }
   return true
}