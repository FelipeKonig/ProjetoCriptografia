# ProjetoCriptografia

O Projeto realiza cadastro e login de conta, utiliza duas interfaces desenvolvidas com a biblioteca javaFX. Na interface de cadastro é armazenado o nome de usuário e senha em um HashMap, no qual exemplifica um banco de dados. 

Ao usuário cadastrar sua conta, a senha é criptografada utilizando as funções de criptografia PBKDF2 juntamente com SHA-2, no qual o sal da criptografia é o próprio nome do usuário. Quando é feito a tentativa de login, realiza o cálculo da senha utilizando o sal(nome de usuário) e senha enviada pelo usuário, verifica se o resultado é igual a alguma senha armazenada e criptografada no banco de dados, e posteriormente retorna ao usuário se a conta é cadastrada ou não através da interface.

A biblioteca utilizada para realizar a criptografia é a Apache Commons Codec

