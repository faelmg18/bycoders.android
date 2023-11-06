# ByCoders Exchange!

Esse projeto tem como objetivo montar um aplicativo para listar os Exchanges da API **[coinapi.io](https://www.coinapi.io/)**. 


# Arquitetura

 - [MVVM](https://coodesh.com/blog/dicionario/o-que-e-arquitetura-mvvm/)
 - [Clean
   Architecture](https://medium.com/luizalabs/descomplicando-a-clean-architecture-cf4dfc4a1ac6)
 - [koin](https://insert-koin.io/)
 - [Compose](https://developer.android.com/jetpack/compose?hl=pt-br)
 - [Retrofit](https://square.github.io/retrofit/)
 - [Koin KSP](https://insert-koin.io/docs/setup/annotations/)
 - [kotlin](https://kotlinlang.org/)
 - [Mockk](https://mockk.io/)
 - [Junit](https://junit.org/junit4/)

## Configurando Projeto

No arquivo build.gradle.kts do projeto **app**, no bloco **buildTypes**
Coloque a chave da API gerada no site do **[coinapi.io](https://www.coinapi.io/)**. 

    buildConfigField("String", "API_KEY", "\"sua chave aqui\"")


> obs: A versão atual do Gradle 8 exige o JDK 17 como consta na [documentação](https://developer.android.com/build/releases/gradle-plugin?hl=pt-br)


## Versão do Android Studio Usada

> Android Studio Giraffe | 2022.3.1 Patch 2


## Objetivo do projeto

O projeto foi desenvolvido para a empresa [bycoders](https://www.bycoders.com.br/) com objetivo de avaliação técnica 
