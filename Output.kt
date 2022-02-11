class Output {
    private var listOfPush: MutableList<Push> = mutableListOf()

    public fun Add(push: Push)
    {
        if (push.Filter()) listOfPush.add(push)
    }

    public fun Print()
    {
        if (listOfPush.isEmpty()) {
            println("-1")
            return
        }
        for (i in 0 until listOfPush.count()){
            listOfPush[i].Show()
        }
    }
}