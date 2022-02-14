class Input {

    private val countUserParam: Int = 6

    public fun GetUserData(): UserData {
        val userData: UserData = UserData()
        for (element in 0 until countUserParam) {
            val line = readLine()!!.split(' ')
            userData.Set(line!!.first(), line.last())
        }
        return userData
    }

    public fun GetCountPush(): Int
    {
        return readLine()!!.toInt()
    }

    public fun GetPush(push: Push)
    {
        val countArgument = readLine()!!.toInt()
        for (i in 0 until countArgument)
        {
            val line = readLine()!!.split(' ')
            push.Set(line!!.first(), line.last())
        }

    }
}