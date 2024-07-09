# [DIO](www.dio.me) - Trilha Java Básico

## Autor
- [Marco Bezerra](https://github.com/marcobz-bzz)

## POO - Desafio

### Modelagem e Diagramação de um Componente iPhone

## Diagrama de Classes

```mermaid
---
title: Modelagem do iPhone
---
classDiagram

class ReprodutorMusical {
<<interface>>
+tocar()
+pausar()
+selecionarMusica(musica:String)
}

class AparelhoTelefonico {
<<interface>>
+ligar(numero:String)
+atender()
+iniciarCorreioVoz()
}

class NavegadorInternet {
<<interface>>
+exibirPagina(url:String)
+adicionarNovaAba()
+atualizarPagina()
}

class IPhone 

IPhone ..> ReprodutorMusical
IPhone ..> AparelhoTelefonico
IPhone ..> NavegadorInternet
```
