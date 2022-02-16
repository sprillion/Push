fun main(){
    val input = Input()
    val output= Output()

    val userData = UserData.create(input.getUserDataMap())
    val countPush = input.getCountPush()

    for (i in 0 until countPush){
        val push = Push.create(input.getPushMap())

        if (userData.filter(push))
            output.add(push.text)
    }
    output.print()
}