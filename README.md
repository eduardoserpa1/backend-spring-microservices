# Spring Microservices - Aplicação exemplo

- Para executar a aplicação basta somente configurar o banco de dados postgresql
e ajustar a referência dos dados no projeto

- O sistema de login foi desenvolvido da maneira mais simples possivel, armazenando apenas um valor booleano em sessão para validar se possui algum usuario conectado ou não, sem utilizar nenhum framework específico para isso.

- Caso o __login__ não seja feito nenhuma das operações **(exceto os endpoints de /user/*)** pode ser efetuada.

No diretório _postman-config_ encontram-se os _endpoints_ configurados em um __arquivo modelo (.json)__ do postman para facilitar
o uso dos mesmos.
