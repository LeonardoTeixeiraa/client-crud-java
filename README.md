# Sistema de Cadastro e Vendas

Este projeto é um sistema desktop completo de **Cadastro de Clientes, Fornecedores, Produtos e Vendas**, com autenticação de usuários e geração de relatórios. Foi desenvolvido em **Java**, com **Swing** para a interface gráfica e **PostgreSQL** como banco de dados. Também inclui a integração com o **JasperReports** para geração de relatórios profissionais em PDF.

## ⚙️ Funcionalidades

- 🔐 **Login com autenticação segura** usando `crypt()` do PostgreSQL
- 👥 Cadastro de **Funcionários**, com tipos de acesso (ex: Administrador)
- 🧾 Cadastro e gerenciamento de:
  - **Clientes**
  - **Fornecedores**
  - **Produtos**
  - **Vendas**
- 📊 **Relatórios PDF** usando JasperReports
- 🔄 Operações completas de **CRUD**
- 🗓 Registro de data de cadastro de fornecedores

---

## 🛠 Tecnologias Utilizadas

| Tecnologia     | Uso                                     |
|----------------|------------------------------------------|
| Java (JDK 21)  | Lógica da aplicação                     |
| Swing          | Interface gráfica (GUI)                 |
| PostgreSQL     | Banco de dados relacional               |
| JDBC           | Conexão entre Java e PostgreSQL         |
| JasperReports  | Geração de relatórios                   |

---

## 🗂 Estrutura do Projeto

```plaintext
src/br/com/projeto_3/
├── view/           # Telas (Swing)
├── dto/            # Objetos de Transferência de Dados
├── dao/            # Acesso ao banco de dados (JDBC)
├── ctr/            # Lógica de negócio (Controller)
└── rel/            # Arquivos de relatórios (.jasper)
```
## 🔒Credenciais de Acesso

Usuário administrador padrão criado no banco:

Login: admin
Senha: ifsp123

## 📊 Relatórios

Os relatórios foram desenvolvidos com o iReport e integrados via JasperReports. Para funcionar:

    As bibliotecas .jar necessárias estão na pasta /jars

    Os arquivos .jasper estão na pasta /rel

    Relatórios são gerados e exibidos com JasperViewer
