# Resolução do Projeto 1
# Cronômetro e Contador Regressivo 

|Disciplina| Curso | Professor | Aluno |
|-------|---------|----|---------|
|Programação Orientada a Objetos| Engenharia de Telecomunicações|Emerson Ribeiro de Mello|Theodor Konrad Wojcikiewicz|

## Introdução:
> Este repositório possui a implementação de um Cronômetro (contador) e um Contador Regressivo (timer) e um display de seis Digitos, com sete segmentos cada. 

> Este projeto faz parte da disciplina de Programação Orientada a Objetos(POO29004)

## Observação: 
> :warning:Este projeto, apesar de totalmente funcional, peca em alguns fatores, descritos abaixo:
 
- :warning:**Faltou implementar a troca de cores do cronômetro e do contador regressivo.**
 
>Isso se deve ao fato da lógica do projeto, juntamente com as especificações previamente definidas.
>
>Para que essa lógica funcionasse, seria necessário pelo menos mais duas semanas, considerando a quantidade de código a ser mexida.
>
>O projeto foi configurado como padrão a cor verde para ligado e cinza claro para desligado.
 
- :warning:**Faltou implementar o fator (tamanho) dos desenhos.**
 
>Por diversas vezes, durante o código, tentei refatorar o tamanho dos digitos, sem sucesso.
>
>Cada vez que o fator é trocado, todos os segmentos ficam bagunçados e desenhados por toda a tela, perdendo a lógica dos segmentos.
>
>O projeto foi instanciado no único tamanho que é funcional, 200.

- :warning:**Faltou implementar as posições x e y iniciais.**

>Para que esta funcionalidade funcionasse no meu código, seria necessário que o segmento recebesse um contador e um cronometro regressivo. 
>
>Como foi declarado no projeto que o Cronômetro e o Contador deveriam receber os digitos e não o contrário e como o meu código está diferente, optei por mantê-lo funcional apenas.
>
>O projeto foi instaciado com as exatas posições na tela para cada digito, previamente calculadas, de acordo com o fator de 200.

## Arquivos Adicionais:

[Modelagem UML](modelagem.png) - Diagrama UML do projeto, com todas as suas dependências, atributos e métodos. 

[Modelagem UML Testes](modelagemtestes.png) - Diagrama UML dos testes do projeto, com todos os atributos e métodos.

[Captura de Tela](capturatelaprojeto.png) - Captura do projeto, mostrando um cronômetro e um contador rodando de forma paralela, em duas telas.
