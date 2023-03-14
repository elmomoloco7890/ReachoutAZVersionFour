package prime.projects.reachoutazversionfour.call

class HotlineRepo {

    lateinit var hotlineLabels: Array<String>
    lateinit var hotlineNumbers: Array<String>

    fun getHotlineData(): ArrayList<Hotlines>{
        val hotlinesArray: ArrayList<Hotlines> = ArrayList()

        hotlineLabels = arrayOf(
            "Call 911 now",
            "Contact the teen hotline",
            "Contact the Crisis hotline",
        )

        hotlineNumbers = arrayOf(
            "511",
            "4808441212",
            "6022733300"
        )

        for (dialed in hotlineLabels.indices){
            hotlinesArray.add(Hotlines(hotlineLabels[dialed], hotlineNumbers[dialed]))
        }

        return hotlinesArray
    }

}