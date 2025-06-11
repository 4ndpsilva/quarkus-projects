# finder

Microserviço que se integra à API do ViaCep e retorna dados de endereços de acordo com um CEP informado.

# Execução da aplicação

Para rodar a aplicação é necessário ter o **Java 21** devidamente instalado, e então executar o comando **./mvnw quarkus:dev** (Linux) ou **.\mvnw quarkus:dev** (Windows). 
Após a subida da aplicação, basta acessar o navegador no endereço http://localhost:9999/api/addresses?zipcode=9999999 
onde **zipcode=9999999** deve ser informado o CEP do endereço a ser procurado. Exemplo:

http://localhost:9999/api/addresses?zipcode=13075901

Os dados retornados pelo microservice são os seguintes:\
CEP\
DDD\
Rua\
Complemento\
Bairro\
Cidade\
Estado