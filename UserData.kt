import kotlin.math.pow
import kotlin.math.sqrt

class UserData(val time: Long, val age: Int, val gender: Char, val osVersion: Int, val xCoord: Float, val yCoord: Float){

    companion object{
        fun create(map: Map<String, String>): UserData{
            val time = map.getValue("time").toLong()
            val age = map.getValue("age").toInt()
            val gender = map.getValue("gender")[0]
            val osVersion = map.getValue("os_version").toInt()
            val xCoord = map.getValue("x_coord").toFloat()
            val yCoord = map.getValue("y_coord").toFloat()

            return UserData(time, age, gender, osVersion, xCoord, yCoord)
        }
    }

    fun filter(push: Push): Boolean{
        return when(push){
            is Push.LocationPush -> checkPosition(push.xCoord, push.yCoord, push.radius) && checkTime(push.expiryDate)
            is Push.AgeSpecificPush -> checkAge(push.age) && checkTime(push.expiryDate)
            is Push.TechPush -> checkOS(push.osVersion)
            is Push.LocationAgePush -> checkPosition(push.xCoord, push.yCoord, push.radius) && checkAge(push.age)
            is Push.GenderAgePush -> checkGender(push.gender) && checkAge(push.age)
            is Push.GenderPush -> checkGender(push.gender)
        }
    }

    private fun checkPosition(xCoord: Float, yCoord: Float, radius: Int) :Boolean {
        val distance = sqrt ((xCoord - this.xCoord ).pow(2) + (yCoord - this.yCoord).pow(2))
        return distance <= radius
    }

    private fun checkAge(age: Int) :Boolean {
        return this.age >= age
    }

    private fun checkOS(osVersion: Int) :Boolean {
        return this.osVersion <= osVersion
    }

    private fun checkTime(expiryDate: Long):Boolean {
        return this.time <= expiryDate
    }

    private fun checkGender(gender: Char):Boolean {
        return this.gender == gender
    }
}