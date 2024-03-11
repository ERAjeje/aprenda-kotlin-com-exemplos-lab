enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(var nome: String, var email: String, var senha: String)

data class Aula(var nome: String, var duracao: Int, var concluido: Boolean)

data class ConteudoEducacional(var nome: String, var aulas: List<Aula>, var aprovado: Boolean)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    val aula1 = Aula("Kotlin inicial", 12, false)
    val aula2 = Aula("Funções em Kotlin", 15, false)
    val aula3 = Aula("Kotlin Avançado", 12, false)
    val desafio = Aula("Desafio de Código", 20, false)
    
    val aulas = mutableListOf(aula1, aula2, aula3, desafio)
    val listaAulas: List<Aula> = aulas
    
    val conteudoEducacional = ConteudoEducacional("Começando com kotlin", listaAulas, false)
    
    val conteudos = mutableListOf(conteudoEducacional)
    val listaConteudos: List<ConteudoEducacional> = conteudos
    
    val formacao = Formacao("Programação em Kotlin", listaConteudos)
    
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    val usuario1 = Usuario("Goku", "goku@coorporacaocapsula.com", "super_sayajin")
    val usuario2 = Usuario("Sakura", "sakura@clamp.com", "aiaiai_Yukito")
    
    println("Número de Conteúdos Educacionais da formação: ${formacao.conteudos.size}")
    println("Número de Aulas no Conteúdo Educacional: ${formacao.conteudos[0].aulas.size}\n")
    
    println("Número de inscritos inicial: ${formacao.inscritos.size}\n")
    
    formacao.matricular(usuario1)
    println(formacao.inscritos[0].nome)
    
    formacao.matricular(usuario2)
    println(formacao.inscritos[1].nome)
    
    println("\nNúmero de inscritos final: ${formacao.inscritos.size}")
}