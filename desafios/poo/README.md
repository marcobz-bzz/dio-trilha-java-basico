# [DIO](www.dio.me) - Trilha Java Básico

---
## Autor
- [Marco Bezerra](https://github.com/marcobz-bzz)

---
## POO - Desafio

---
### Modelagem e Diagramação de um Componente iPhone
[Projeto iPhone](https://github.com/marcobz-bzz/dio-trilha-java-basico/tree/main/desafios/poo)

---
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

style IPhone fill:#FECF6A,stroke:#DF1C44,stroke-width:4px,color:black
```

---
## Implmentação em Java
Usando VScode, em:

https://github.com/marcobz-bzz/dio-trilha-java-basico/tree/main/desafios/poo/IPhone/src/br/edu/dio/iphone/model

---
+ + +
