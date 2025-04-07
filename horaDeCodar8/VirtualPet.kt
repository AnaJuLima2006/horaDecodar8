import kotlin.system.exitProcess

class VirtualPet(val nome: String) {

    var idade = 1
    var nivelDeFome = 50
    var nivelDeFelicidade = 50
    var nivelDeCansaco = 0
    var nivelDeSujeira = 0
    var nivelDeObstrucaoIntestinal = 0

    fun alimentar() {
        nivelDeFome -= 10
        nivelDeObstrucaoIntestinal += 10

        println("$nome foi alimentado (a). O nível de fome diminuiu.")

    }

    fun brincar() {
        nivelDeFelicidade += 10
        nivelDeCansaco += 10
        nivelDeSujeira += 5


        println("$nome está brincando e se sentindo mais feliz.")


    }

    fun banheirinho(){
        nivelDeObstrucaoIntestinal -= nivelDeObstrucaoIntestinal

        println("$nome está aliviado (a).")

    }

    fun banhar(){
        nivelDeSujeira -= nivelDeSujeira

        println(" $nome está cheirosinho (a) e pronta para mimir.")
    }

    fun mimir(){
        nivelDeCansaco -= nivelDeCansaco

        println("$nome está mimindo e se sentindo mais descansado (a).")
    }

    fun verificarStatus() {
        println("Status atual de $nome:")
        println("Idade: $idade")
        println("Nível de fome: $nivelDeFome")
        println("Nível de felicidade: $nivelDeFelicidade")
        println("Nível de sujeira: $nivelDeSujeira")
        println("Nível de obstrução intestinal: $nivelDeObstrucaoIntestinal")
        println("Nível de cansaço: $nivelDeCansaco")
    }

    fun passarTempo() {
        idade += 1
        nivelDeFome += 5
        nivelDeFelicidade -= 3
        nivelDeCansaco += 5

        println("$nome está ficando mais faminto (a), cansado (a), infeliz e" +
                " velho (a) com o passar do tempo. O tempo é valioso...")


        if (nivelDeFome >= 80){
            println("$nome precisa comer, está quase no seu limite.")
        }

        if (nivelDeFelicidade <= 20){
            println("$nome precisa brincar, está quase no seu limite.")
        }

        if (nivelDeCansaco >= 70){
            println("$nome precisa descansar, está quase no seu limite.")
        }

        if (nivelDeObstrucaoIntestinal >= 50){
            println("$nome precisa ir no banheiro, está quase no seu limite.")
        }

        if (nivelDeSujeira >= 50){
            println("$nome precisa tomar banho! O cheiro está péssimo...")
        }

        if (nivelDeFome >= 100 || nivelDeCansaco >= 100 || nivelDeSujeira >=80 || nivelDeObstrucaoIntestinal >=80  || nivelDeFelicidade <= 0){
            println("Ixiii, seu pet não foi bem cuidado, você perdeu :/")

            exitProcess(0)
        }

        if (idade == 50){
            println("Você ganhou o jogo!")

            exitProcess(0)
        }
    }
}

fun main() {
    println("Bem-vindo ao Simulador de Animal de Estimação Virtual!")
    println("Digite o nome do seu animal de estimação:")
    val nomePet = readLine() ?: "Jujuba Sensação da Silva"
    val pet = VirtualPet(nomePet)

    while (true) {
        println("\nEscolha uma ação:")
        println("1. Alimentar $nomePet")
        println("2. Brincar com $nomePet")
        println("3. $nomePet foi no banherinho.")
        println("4. Banhar $nomePet.")
        println("5. $nomePet está mimindo.")
        println("6. Verificar o status de $nomePet.")
        println("7. Sair")

        val escolha = readLine()?.toIntOrNull() ?: continue

        when (escolha) {
            1 -> pet.alimentar()
            2 -> pet.brincar()
            3 -> pet.banheirinho()
            4 -> pet.banhar()
            5 -> pet.mimir()
            6 -> pet.verificarStatus()
            7 -> {
                println("Saindo do Simulador de Animal de Estimação Virtual. Adeus!")
                return
            }
            else -> println("Escolha inválida. Tente novamente.")
        }

        pet.passarTempo()
    }
}