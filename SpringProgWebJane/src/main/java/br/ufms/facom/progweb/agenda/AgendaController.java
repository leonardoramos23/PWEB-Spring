package br.ufms.facom.progweb.agenda;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufms.facom.progweb.agenda.model.ContatoGerenciadora;

@Controller
@RequestMapping
public class AgendaController {

  @GetMapping("/agenda")
  public String index() {
    return "inicio";
  }

  @GetMapping("/agenda/novo")
  public String novo() {
    return "novoContato";
  }

  @PostMapping("agenda/salvar")
  public String salvaNovo(
      @RequestParam(name = "nome") String nome,
      @RequestParam(name = "telefone") String telefone,
      @RequestParam(name = "email") String email) {

    ContatoGerenciadora.salva(nome, email, telefone);

    return "inicio";
  }

  @GetMapping("/agenda/lista")
  public String listaTodos(Model model) {

    model.addAttribute("listaDeContatos", ContatoGerenciadora.buscaTodos());

    return "listaContatos";
  }

  @GetMapping("/agenda/editar/{id}")
  public String edita(
      @PathVariable("id") Integer id, Model model) {

    model.addAttribute("contato", ContatoGerenciadora.buscaPorId(id));

    return "editaContato";
  }

  @PostMapping("agenda/salvarEditar")
  public String salvaEdita(
      @RequestParam(name = "id") Integer id,
      @RequestParam(name = "nome") String nome,
      @RequestParam(name = "telefone") String telefone,
      @RequestParam(name = "email") String email) {

    ContatoGerenciadora.edita(id, nome, email, telefone);

    return "inicio";
  }

  @GetMapping("/agenda/remover/{id}")
  public String remover(
      @PathVariable("id") Integer id) {

    ContatoGerenciadora.remove(id);

    return "inicio";
  }

}
