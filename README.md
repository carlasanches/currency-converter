# currency-converter
Uma API para conversão da moeda Real Brasileiro (BRL) em outras moedas.

## Pré requisitos
- JDK 17;
- Kotlin 1.9.0.

## Configuração
1. Clone o repositório do GitHub no seu diretório de workspace:
```
git clone https://github.com/carlasanches/currency-converter.git
```
2. Acesse o diretório do aplicativo:
```
cd currency-converter/currency-converter-app
```
3. Execute o projeto:
```
./gradlew bootRun
```

## Início Rápido
Você pode testar os métodos executando a aplicação e acessando através do navegador o seguinte endereço:
```
http://localhost:8080/swagger-ui/index.html
```

Na atual versão da API é possível:
- Inicializar a base de dados com quatro moedas diferentes.
- Converter a moeda Real brasieiro (BRL) em outra moeda.
- Adicionar novas moedas.
- Buscar por moedas no banco de dados.
- Deletar moedas do banco de dados.
- Editar moedas no banco de dados.
