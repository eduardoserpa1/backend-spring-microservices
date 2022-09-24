# t1-microservices

Para executar a aplicação basta somente configurar o banco de dados postgresql
e ajustar a referência dos dados no projeto

O sistema de login foi desenvolvido da maneira mais simples possivel como dito na especificação,
armazenando apenas um valor booleano em sessão para validar se possui algum usuario conectado ou não

Caso o __login__ não seja feito nenhuma das operações **(exceto os endpoints de /user/*)** pode ser efetuada.