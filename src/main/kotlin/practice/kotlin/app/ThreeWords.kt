package practice.kotlin.app

class ThreeWords {

    fun DoesHaveThreeWords(input: String) : Boolean {
        val splittedInput = input.split(' ')
        val totalConsecutive = splittedInput.fold(0, {
            acc: Int, current: String -> acc + (if(current.all { it.isLetter() } || acc >= 3) 1 else -acc )
        })

        return totalConsecutive >= 3 ;
    }
}
