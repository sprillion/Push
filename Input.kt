class Input {

    private val countUserParam: Int = 6

    fun getUserDataMap(): Map<String, String> {
        val map = mutableMapOf<String, String>()
        for (element in 0 until countUserParam) {
            val line = readLine()!!.split(' ')
            map[line.first()] = line.last()
        }
        return map
    }

    fun getCountPush(): Int {
        return readLine()!!.toInt()
    }

    fun getPushMap() :Map<String, String> {
        val countArgument = readLine()!!.toInt()

        val map = mutableMapOf<String, String>()

        for (i in 0 until countArgument)
        {
            val line = readLine()!!.split(' ')
            map[line.first()] = line.last()
        }
        return map
    }
}