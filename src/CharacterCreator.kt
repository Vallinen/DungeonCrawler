class CharacterCreator {

    val charSheet = CharacterSheet()

    fun charCreator(): CharacterSheet {
        println("Please name your character.")
        val inputName: String? = readLine()
        println("Are you sure that you want to name your character $inputName?")
        println("Y/N?")
        val inputNameConfirm: String? = readLine()
        if (inputNameConfirm == "Y") {
            val charName: String? = inputName
        } else {
            charCreator()
        }
        println("Please choose a race for your character.")
        println("You can choose between 'Human', 'Dwarf' and 'Elf', please type your choice.")
        val inputRace: String? = readLine()
        if (inputRace == "Human") {
            println("Are you sure you want your character to be a Human?")
            println("Y/N?")
            val inputRaceConfirm: String? = readLine()
            if (inputNameConfirm == "Y") {
                println("You character is a $inputRace")
            } else {
                charCreator()
            }
        }
        if (inputRace == "Dwarf") {
            println("Are you sure you want your character to be a Dwarf?")
            println("Y/N?")
            val inputRaceConfirm: String? = readLine()
            if (inputNameConfirm == "Y") {
                println("You character is a $inputRace")
            } else {
                charCreator()
            }
        }
        if (inputRace == "Elf") {
            println("Are you sure you want your character to be an Elf?")
            println("Y/N?")
            val inputRaceConfirm: String? = readLine()
            if (inputNameConfirm == "Y") {
                println("You character is an $inputRace")
            } else {
                charCreator()
            }
        }

        charSheet.name = inputName
        charSheet.race = inputRace
        return charSheet


    }

}
