function valida() {
  //pegando o valor
  var telefone = document.getElementById("telefone");
  var email = document.getElementById("email");

  var msgErro = document.getElementById("erro");

  if (telefone.value !== "" || email.value !== "") {
    msgErro.style.display = "none"; //esconde msg de erro
  } else {
    msgErro.style.display = "block"; //mostra mensagem de erro
    telefone.focus(); //volta o foco para o campo 
  }
}
