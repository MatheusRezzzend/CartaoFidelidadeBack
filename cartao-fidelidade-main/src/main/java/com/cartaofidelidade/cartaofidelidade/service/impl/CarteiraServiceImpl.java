package com.cartaofidelidade.cartaofidelidade.service.impl;

import com.cartaofidelidade.cartaofidelidade.model.Carteira;
import com.cartaofidelidade.cartaofidelidade.model.Cliente;
import com.cartaofidelidade.cartaofidelidade.model.Loja;
import com.cartaofidelidade.cartaofidelidade.model.Produto;
import com.cartaofidelidade.cartaofidelidade.repository.CarteiraRepository;
import com.cartaofidelidade.cartaofidelidade.repository.ClienteRepository;
import com.cartaofidelidade.cartaofidelidade.service.CarteiraService;
import org.springframework.stereotype.Service;

@Service
public class CarteiraServiceImpl implements CarteiraService {
    private CarteiraRepository carteiraRepository;

    public CarteiraServiceImpl(CarteiraRepository carteiraRepository){this.carteiraRepository = carteiraRepository;}

    @Override
    public Carteira cadastrarCarteira(Carteira carteira){
        return carteiraRepository.save(carteira);
    }
}
