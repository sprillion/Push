sealed class Push(val text: String) {

    class LocationPush(text: String, val xCoord: Float, val yCoord: Float, val radius: Int, val expiryDate: Long): Push(text)
    class AgeSpecificPush(text: String, val age: Int, val expiryDate: Long): Push(text)
    class TechPush(text: String, val osVersion: Int): Push(text)
    class LocationAgePush(text: String, val age: Int, val xCoord: Float, val yCoord: Float, val radius: Int): Push(text)
    class GenderAgePush(text: String, val age: Int, val gender: Char): Push(text)
    class GenderPush(text: String, val gender: Char): Push(text)

    companion object {
        fun create(map: Map<String, String>): Push
        {
            val type = TypePush.valueOf(map.getValue("type"))
            val text = map.getValue("text")

            return when(type){
                TypePush.LocationPush -> LocationPush(text, map.getValue("x_coord").toFloat(), map.getValue("y_coord").toFloat(), map.getValue("radius").toInt(), map.getValue("expiry_date").toLong())
                TypePush.AgeSpecificPush -> AgeSpecificPush(text, map.getValue("age").toInt(), map.getValue("expiry_date").toLong())
                TypePush.TechPush -> TechPush(text, map.getValue("os_version").toInt())
                TypePush.LocationAgePush -> LocationAgePush(text, map.getValue("age").toInt(), map.getValue("x_coord").toFloat(), map.getValue("y_coord").toFloat(), map.getValue("radius").toInt())
                TypePush.GenderAgePush-> GenderAgePush(text, map.getValue("age").toInt(), map.getValue("gender")[0])
                TypePush.GenderPush -> GenderPush(text, map.getValue("gender")[0])
            }
        }
    }

}