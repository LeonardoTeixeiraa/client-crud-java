package br.com.projeto_3.dao;

import java.sql.*;
import java.text.SimpleDateFormat;

import br.com.projeto_3.dto.FuncionarioDTO;

public class FuncionarioDAO {
    private ResultSet rs = null;
    private Statement stmt = null;

    public boolean inserirFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();

            String comando = "insert into funcionario (nome_fun, cpf_fun, "
                    + "login_fun, senha_fun, tipo_fun) values ( "
                    + "'" + funcionarioDTO.getNome_fun() + "', "
                    + "'" + funcionarioDTO.getCpf_fun() + "', "
                    + "'" + funcionarioDTO.getLogin_fun() + "', "
                    + "crypt('" + funcionarioDTO.getSenha_fun() + "', gen_salt('bf', 8)), "
                    + "'" + funcionarioDTO.getTipo_fun() + "') ";

            stmt.execute(comando);

            ConexaoDAO.con.commit();

            stmt.close();

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    public boolean alterarFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "Update funcionario set "
                    + "nome_fun = '" + funcionarioDTO.getNome_fun() + "', "
                    + "cpf_fun = '" + funcionarioDTO.getCpf_fun() + "', "
                    + "login_fun = '" + funcionarioDTO.getLogin_fun() + "', "
                    + "senha_fun = crypt('" + funcionarioDTO.getSenha_fun() + "', gen_salt('bf', 8)), "
                    + "tipo_fun = '" + funcionarioDTO.getTipo_fun() + "' "
                    + "where id_fun = " + funcionarioDTO.getId_fun();

            if (funcionarioDTO.getSenha_fun().equals("")) {
                comando = "Update funcionario set "
                        + "nome_fun = '" + funcionarioDTO.getNome_fun() + "', "
                        + "cpf_fun = '" + funcionarioDTO.getCpf_fun() + "', "
                        + "login_fun = '" + funcionarioDTO.getLogin_fun() + "', "
                        + "tipo_fun = '" + funcionarioDTO.getTipo_fun() + "' "
                        + "where id_fun = " + funcionarioDTO.getId_fun();
            }

            stmt.execute(comando);

            ConexaoDAO.con.commit();

            stmt.close();

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    public boolean excluirFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "delete from funcionario "
                    + "where id_fun = " + funcionarioDTO.getId_fun();

            stmt.execute(comando);

            ConexaoDAO.con.commit();

            stmt.close();

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    public ResultSet consultarFuncionario(FuncionarioDTO funcionarioDTO, int opcao) {
        try {
            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "";

            switch (opcao) {
                case 1:
                    comando = " select f.id_fun, f.nome_fun "
                            + " from funcionario f "
                            + " where f.nome_fun like '" + funcionarioDTO.getNome_fun() + "%' "
                            + " order by f.nome_fun";
                    break;
                case 2:
                    comando = " select * from funcionario"
                            + " where id_fun = " + funcionarioDTO.getId_fun();
                    break;
            }
            rs = stmt.executeQuery(comando);
            return rs;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }

    public String loginFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "select f.id_fun, f.nome_fun, f.tipo_fun "
                    + "from funcionario f "
                    + "where f.login_fun = '" + funcionarioDTO.getLogin_fun() + "' "
                    + "and f.senha_fun = crypt('" + funcionarioDTO.getSenha_fun() + "', f.senha_fun) ";

            rs = stmt.executeQuery(comando);

            if (rs.next()) {
                return rs.getString("tipo_fun");
            }

            return null;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }
}
