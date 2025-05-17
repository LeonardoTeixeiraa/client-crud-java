/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_3.ctr;

import br.com.projeto_3.dao.ConexaoDAO;
import br.com.projeto_3.dao.VendaDAO;
import br.com.projeto_3.dto.VendaDTO;
import br.com.projeto_3.dto.ClienteDTO;
import javax.swing.JTable;

public class VendaCTR {

    VendaDAO vendaDAO = new VendaDAO();

    // Construtor
    public VendaCTR() {

    }

    /**
     * Método utilizado para controlar o acesso ao método inserirVenda da classe
     * VendaDAO
     *
     * @param vendaDTO,   que vem da classe da página (VIEW)
     * @param clienteDTO, que vem da classe da página (VIEW)
     * @param produtos,   que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String inserirVenda(VendaDTO vendaDTO, ClienteDTO clienteDTO, JTable produtos) {
        try {
            if (vendaDAO.inserirVenda(vendaDTO, clienteDTO, produtos)) {
                return "Venda Cadastrada com Sucesso!!!";
            }
            return "Venda NÃO Cadastrada!!!";

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Venda NÃO Cadastrada";
        }
    }

    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }

}
