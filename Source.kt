fun main(){
    val input: Input = Input()
    val output: Output = Output()

    val userData = input.GetUserData()
    val countPush = input.GetCountPush()

    for (i in 0 until countPush)
    {
        val push = Push(userData)
        input.GetPush(push)
        output.Add(push)
    }
    output.Print()
}