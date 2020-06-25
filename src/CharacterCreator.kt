class CharacterCreator {

    val charSheet = CharacterSheet()

    fun charCreator(): CharacterSheet {
        println("Please name your character.")
        var inputName: String? = readLine()
        println("Are you sure that you want to name your character $inputName?")
        println("Y/N?")
        var inputNameConfirm: String? = readLine()
        if (inputNameConfirm == "Y") {
        } else {
            GameEngine().runGame()
        }
        println("Please choose a race for your character.")
        println("You can choose between 'Human', 'Dwarf' and 'Elf', please type your choice.")
        var inputRace: String? = readLine()
        if (inputRace == "Human") {
            println("Are you sure you want your character to be a Human?")
            println("Y/N?")
            var inputRaceConfirm: String? = readLine()
            if (inputRaceConfirm == "Y") {
                println("You character is a $inputRace")
            } else {
                GameEngine().runGame()
            }
        }
        if (inputRace == "Dwarf") {
            println("Are you sure you want your character to be a Dwarf?")
            println("Y/N?")
            var inputRaceConfirm: String? = readLine()
            if (inputRaceConfirm == "Y") {
                println("You character is a $inputRace")
            } else {
                GameEngine().runGame()
            }
        }
        if (inputRace == "Elf") {
            println("Are you sure you want your character to be an Elf?")
            println("Y/N?")
            var inputRaceConfirm: String? = readLine()
            if (inputRaceConfirm == "Y") {
                println("You character is an $inputRace")
            } else {
                GameEngine().runGame()
            }
        } else {
            println("That is not a valid race.")
            GameEngine().runGame()
        }

        charSheet.name = inputName
        charSheet.race = inputRace
        return charSheet


    }

}
