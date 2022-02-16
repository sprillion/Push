class Output {
    private val listOfPush: MutableList<String> = mutableListOf()

    fun add(text: String) {
        listOfPush.add(text)
    }

    fun print() {
        if (listOfPush.isEmpty()) {
            println("-1")
            return
        }
        for (i in 0 until listOfPush.count()){
            println(listOfPush[i])
        }
    }
}

