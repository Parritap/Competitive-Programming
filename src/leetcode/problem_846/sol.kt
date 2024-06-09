fun main( args : Array<String>) {
  //val array = intArrayOf(1,2,3,6,2,3,4,7,8)
  //print(isNStraightHand(array, 3))

    val mymap : Map<Int, Int> = mapOf(1 to 1, 2 to 3, 3 to 4);
    print(mymap[3])
}


//fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
//   if (hand.size % groupSize != 0) return false
//
//    val map : MutableMap<Int, Int> = mutableMapOf();
//    hand.forEach {
//        if (!map.containsKey(it)) map[it] = 1 else map[it] = (map[it] + 1)
//    }
//}