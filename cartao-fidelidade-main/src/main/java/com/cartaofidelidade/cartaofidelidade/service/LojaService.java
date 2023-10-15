package com.cartaofidelidade.cartaofidelidade.service;

import com.cartaofidelidade.cartaofidelidade.model.Carteira;
import com.cartaofidelidade.cartaofidelidade.model.Cliente;
import com.cartaofidelidade.cartaofidelidade.model.Loja;

public interface LojaService {
    Loja cadastrarLoja(Loja loja);

    void validarCnpj(String cnpj);

    Loja autenticar(String cnpj, String senha);

    Loja obterLojaPorId(Long id);

    Carteira criarCarteira(Cliente cliente, Loja loja, Carteira carteira);
}
