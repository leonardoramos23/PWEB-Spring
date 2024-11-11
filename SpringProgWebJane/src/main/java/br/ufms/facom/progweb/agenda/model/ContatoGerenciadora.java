package br.ufms.facom.progweb.agenda.model;

import java.util.List;
import java.util.ArrayList;

public class ContatoGerenciadora {

  private static List<Contato> repositorioDeContatos;

  /**
   * Inicia o repositório. Futuramente irá conectar ao banco.
   **/
  public static void inicializa() {
    repositorioDeContatos = new ArrayList<>();
  }

  /**
   * Adiciona um contato ao repositório.
   **/
  public static boolean salva(String nome, String telefone, String email) {
    Integer id = proximoId();

    Contato contato = new Contato(id, nome, telefone, email);
    repositorioDeContatos.add(contato);
    return true;
  }

  /**
   * Calcula o próximo id
   **/
  private static Integer proximoId() {
    Integer prox = 0;

    if (repositorioDeContatos == null) {
      inicializa();
    } else {
      for (Contato contato : repositorioDeContatos) {
        if (contato.getId().intValue() > prox.intValue()) {
          prox = contato.getId();
        }
      }
    }

    return prox + 1;
  }

  /**
   * Retorna um contato dado o id.
   **/
  public static Contato buscaPorId(Integer id) {
    for (Contato contato : repositorioDeContatos) {
      if (contato.getId().equals(id)) {
        return contato;
      }
    }
    return null;
  }

  /**
   * Retorna todos os contatos.
   **/
  public static List<Contato> buscaTodos() {
    return repositorioDeContatos;
  }

  /**
   * Edita um contato do repositório.
   **/
  public static boolean edita(Integer id, String nome, String telefone, String email) {

    Contato contato = buscaPorId(id);

    if (contato != null) {
      contato.setNome(nome);
      contato.setTelefone(telefone);
      contato.setEmail(email);
      return true;
    } else
      return false;

  }

  /**
   * Exclui um contato do repositório.
   **/
  public static boolean remove(Integer id) {

    Contato contato = buscaPorId(id);

    if (contato != null) {
      repositorioDeContatos.remove(contato);
      return true;
    } else
      return false;

  }

}