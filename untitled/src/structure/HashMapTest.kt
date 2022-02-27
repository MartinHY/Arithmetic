package structure

object HashMapTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val map = HashMap<String,Int>()
        for (i in 0..10000000){
            map[System.currentTimeMillis().toString()] = i
        }
    }
}