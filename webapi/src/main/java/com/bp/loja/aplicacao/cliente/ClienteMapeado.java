package com.bp.loja.aplicacao.cliente;

import com.bp.loja.dominio.Cliente;
import com.bp.loja.dominio.Endereco;

public final class ClienteMapeado {

  public static ClienteDto mapearClienteDto(Cliente cliente) {
    ClienteDto clienteDto = new ClienteDto();
    EnderecoDto enderecoDto = mapearEnderecoDto(cliente.getEndereco());

    clienteDto.id = cliente.getId();
    clienteDto.nome = cliente.getNome();
    clienteDto.email = cliente.getEmail();
    clienteDto.endereco = enderecoDto;

    return clienteDto;
  }

  private static EnderecoDto mapearEnderecoDto(Endereco endereco) {
    EnderecoDto enderecoDto = new EnderecoDto();
    if (null != endereco) {
      enderecoDto.cidade = endereco.getCidade();
      enderecoDto.estado = endereco.getEstado();
      enderecoDto.cep = endereco.getCep();
      enderecoDto.rua = endereco.getRua();
      enderecoDto.bairro = endereco.getBairro();
    }
    return enderecoDto;
  }
}