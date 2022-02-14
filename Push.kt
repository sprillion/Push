import kotlin.math.pow
import kotlin.math.sqrt

class Push(private val userData: UserData): ISettable {

    private lateinit var currentTypePush: TypePush
    private lateinit var text: String
    private var age: Int = 0
    private var gender: Char = '\u0000'
    private var osVersion: Int = 0
    private var xCoord: Float = 0f
    private var yCoord: Float = 0f
    private var radius: Int = 0
    private var expiryDate: Long = 0

    override fun Set(type: String, value: String)
    {
        when (type)
        {
            "type" -> currentTypePush = TypePush.valueOf(value)
            "text" -> text = value
            "age" -> age = value.toInt()
            "gender" -> gender = value[0]
            "os_version" -> osVersion = value.toInt()
            "x_coord" -> xCoord = value.toFloat()
            "y_coord" -> yCoord = value.toFloat()
            "radius" -> radius = value.toInt()
            "expiry_date" -> expiryDate = value.toLong()
        }
    }

    public fun Filter(): Boolean
    {
        return when (currentTypePush) {
            TypePush.LocationPush -> CheckPosition() && CheckTime()
            TypePush.AgeSpecificPush -> CheckAge() && CheckTime()
            TypePush.TechPush -> CheckOS()
            TypePush.LocationAgePush -> CheckPosition() && CheckAge()
            TypePush.GenderAgePush-> CheckGender() && CheckAge()
            TypePush.GenderPush -> CheckGender()
        }
    }

    public fun Show()
    {
        println(text)
    }

    private fun CheckPosition() :Boolean
    {
        val distance = sqrt ((xCoord - userData.xCoord).pow(2) + (yCoord - userData.yCoord).pow(2))
        return distance <= radius
    }
    private fun CheckAge() :Boolean
    {
        return userData.age >= age
    }
    private fun CheckOS() :Boolean
    {
        return userData.osVersion <= osVersion
    }

    private fun CheckTime():Boolean
    {
        return userData.time <= expiryDate
    }

    private fun CheckGender():Boolean
    {
        return userData.gender == gender
    }

}
