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
├── dto/            # Objetos de Transferênci
