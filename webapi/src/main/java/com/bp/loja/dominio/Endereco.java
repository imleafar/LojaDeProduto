package com.bp.loja.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String rua;
  private String cidade;
  private String bairro;
  private String cep;
  private String estado;

  private Endereco() {
  }

  public Endereco(String rua, String cidade, String bairro, String cep, String estado) {
    validar(rua, cidade, bairro, cep, estado);
    this.rua = rua;
    this.cidade = cidade;
    this.bairro = bairro;
    this.cep = cep;
    this.estado = estado;
  }

  private void validar(String rua, String cidade, String bairro, String cep, String estado) {
    new ExcecaoDeDominio()
      .quandoEhNuloOuVazio(rua, "A rua é obrigatória")
      .quandoEhNuloOuVazio(cidade, "A cidade é obrigatória")
      .quandoEhNuloOuVazio(bairro, "O bairro é obrigatório")
      .quandoEhNuloOuVazio(cep, "O CEP é obrigatório")
      .quandoEhNuloOuVazio(estado, "O estado é obrigatório")
      .entaoDispara();
  }

  public String getRua() {
    return rua;
  }

  public String getCidade() {
    return cidade;
  }

  public String getBairro() {
    return bairro;
  }

  public String getCep() {
    return cep;
  }

  public String getEstado() {
    return estado;
  }
}