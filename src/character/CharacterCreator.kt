package character

class CharacterCreator {


    val allowedRaces = listOf("Human", "Dwarf", "Elf")

    fun charCreator(): CharacterSheet {
        val inputName = enterParameter("character name")
        val inputRace = enterParameter("character race", allowedRaces)

        return CharacterSheet(inputName, inputRace)
    }

    private fun enterParameter(parameter: String, options: List<String> = listOf()): String {

        while (true) {
            println("Please enter your $parameter.")
            if (options.isNotEmpty()){
                println("Your options are $options.")
            }
            var inputName: String? = readLine()
            if (!options.isNotEmpty() || options.contains(inputName)) {
                println("Are you sure that you want $parameter to be $inputName?")
                println("Yes/No?")
                var inputNameConfirm1 = readLine().toString()
                if (inputNameConfirm1[0] == 'Y') {
                    return inputName.toString()
                }
            }

        }
    }
}
