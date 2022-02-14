class UserData: ISettable {
    var time: Long = 0
        private set
    var age: Int = 0
        private set
    var gender: Char = '\u0000'
        private set
    var osVersion: Int = 0
        private set
    var xCoord: Float = 0f
        private set
    var yCoord: Float = 0f
        private set

    override fun Set(type: String, value: String)
    {
        when (type)
        {
            "time" -> time = value.toLong()
            "gender" -> gender = value[0]
            "age" -> age = value.toInt()
            "os_version" -> osVersion = value.toInt()
            "x_coord" -> xCoord = value.toFloat()
            "y_coord" -> yCoord = value.toFloat()
        }
    }
}