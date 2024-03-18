Esse projeto consiste em uma plataforma que utiliza uma API Restful para cadastrar endereços a partir de CEPs. Esses endereços são associados às bibliotecas criadas. Cada biblioteca é responsável por armazenar informações sobre os livros cadastrados. Os livros são identificados pelo seu ISBN e CEP da biblioteca correspondente.

Os principais componentes do projeto:

1. **Cadastro de Endereços**:
    - Através da API Restful ViaCep, é possível inserir um CEP e obter informações detalhadas sobre o endereço correspondente. Esses dados são utilizados para cadastrar a localização da biblioteca.
    - O endereço inclui informações como rua, bairro, cidade, estado e CEP.

2. **Criação de Bibliotecas**:
    - É possívelcriar novas bibliotecas, fornecendo informações como nome, endereço (obtido via API) e lista de livros.
    - Cada biblioteca é associada ao seu respectivo endereço.

3. **Cadastro de Livros**:
    - Os livros são cadastrados na plataforma e associados a uma biblioteca específica.
    - O **ISBN** é utilizado como identificador único para cada livro.

4. **Métodos HTTP**:
    - O projeto utiliza os seguintes métodos HTTP:
        - **GET**: Para consultar informações sobre emdereços, bibliotecas e livros.
        - **POST**: Para criar novas endereços, bibliotecas e livros.
        - **DELETE**: Para remover endereços, bibliotecas ou livros.
