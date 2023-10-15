package com.cartaofidelidade.cartaofidelidade.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Data
@Entity
@Table(name = "produto", schema = "cartao_fidelidade")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    @ManyToOne
    @JoinColumn(name = "loja_id")
    private Loja loja;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nomeProduto;

    @Column(name = "valor")
    private Float valor;

    @Column(name = "descricao")
    private String descricao;

    public Loja getLoja() {
        return loja;
    }
    public void setNome(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNome() {
        return nomeProduto;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public float getValor() {
        return valor;
    }


}
