<h3 align="center">Projeto Criptografia</h3>

<br />

---
<br />

# :clipboard: Indice

- [Demonstração](#Demonstracao) 
- [Sobre](#Sobre)
- [Funcionalidades](#Funcionalidades)
- [Tecnologias Utilizadas](#Tecnologias-utilizadas)
- [Autor](#Autor)

## :camera: <a name="Demonstracao">Demonstração</a>

Realizando o cadastro
<br />
![cadastro](https://user-images.githubusercontent.com/49540283/117515314-48583080-af6c-11eb-8ba7-ab1aa7aca33d.png)

<br />

Realizando login
<br />
![login](https://user-images.githubusercontent.com/49540283/117515328-55751f80-af6c-11eb-9843-01d22760c63b.png)

<br />

Logado
<br />
![logado](https://user-images.githubusercontent.com/49540283/117515344-5f971e00-af6c-11eb-8a4f-99a584e39e86.png)

<br />

Realizando login com senha incorreta
<br />
![erro](https://user-images.githubusercontent.com/49540283/117515375-76d60b80-af6c-11eb-9af8-191da5d1e0ed.png)

<br />

## :pushpin: <a name="Sobre">Sobre</a>  

O Projeto realiza cadastro e login de conta, utiliza duas interfaces desenvolvidas com a biblioteca javaFX. Na interface de cadastro é armazenado o nome de usuário e senha em um HashMap, no qual exemplifica um banco de dados. 

Ao usuário cadastrar sua conta, a senha é criptografada utilizando as funções de criptografia PBKDF2 juntamente com SHA-2, no qual o sal da criptografia é o próprio nome do usuário. Quando é feito a tentativa de login, realiza o cálculo da senha utilizando o sal(nome de usuário) e senha enviada pelo usuário, verifica se o resultado é igual a alguma senha armazenada e criptografada no banco de dados, e posteriormente retorna ao usuário se a conta é cadastrada ou não através da interface.

A biblioteca utilizada para realizar a criptografia é a Apache Commons Codec.

## :heavy_check_mark: <a name="Funcionalidades">Funcionalidades</a> 

- Realizar login
- Realizar cadastro

## :rocket: <a name="Tecnologias-utilizadas">Tecnologias utilizadas</a>  

- [Java](https://www.java.com/pt-BR/) > 10
- [Maven](https://maven.apache.org/) > 4
- [JavaFX](https://openjfx.io/) > 11
- [Apache Commons Codec](https://commons.apache.org/proper/commons-codec/)

## :smile: <a name="Autor">Autor</a>  

![eu](https://user-images.githubusercontent.com/49540283/117379724-7840fe80-aeae-11eb-87fb-54a79b44233d.jpg)
   
Feito com 💙 por Felipe Konig :wave: Entre em contato!

[![Facebook Badge](https://img.shields.io/badge/Facebook-Felipe%20Konig-blue)](https://www.facebook.com/felipe.konig.3/)
[![Twitter Badge](https://img.shields.io/badge/Twitter-Felipe%20Konig-blue)](https://twitter.com/FelipeKonig4) 
[![Linkedin Badge](https://img.shields.io/badge/LinkedIn-Felipe%20Konig-blue)](https://www.linkedin.com/in/felipe-konig-10bb8a190/) 
[![Gmail Badge](https://img.shields.io/badge/Gmail-lipekonig%40gmail.com-orange)](mailto:lipekonig@gmail.com)



