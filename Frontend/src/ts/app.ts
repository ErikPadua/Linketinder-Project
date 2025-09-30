interface Candidato {
  nome: string;
  email: string;
  cpf: string;
  telefone: string;
  linkedin: string;
  skills: string[];
}

interface Empresa {
  nome: string;
  email: string;
  cnpj: string;
  cep: string;
  descricao: string;
  vagas: string[];
}

const regexNomeCandidato = /([A-Z])?[a-z]{2,}/;
const regexEmail = /\S+@\w+\.\w{2,6}(\.\w{2})?/;
const regexCPF = /\d{3}\.\d{3}\.\d{3}-\d{2}/;
const regexCNPJ = /\d{2}\.\d{3}\.\d{3}\/\d{4}\-\d{2}/;
const regexCEP = /\d{5}-\d{3}/;
const regexTelefone = /((\(\d{2}\))|(\d{2}))\s?\d{4,5}-?\d{4}/;
const regexLinkedin = /(https:\/\/)?(www\.)?linkedin\.com\/in\/\w+(\/)?/;

const candidatos: Candidato[] = JSON.parse(
  localStorage.getItem("candidatos") || "[]"
);
const empresas: Empresa[] = JSON.parse(
  localStorage.getItem("empresas") || "[]"
);

const candForm = document.getElementById("candForm") as HTMLFormElement | null;
if (candForm) {
  candForm.addEventListener("submit", (e) => {
    e.preventDefault();
    const nome = (document.getElementById("candNome") as HTMLInputElement)
      .value;
    if (!regexNomeCandidato.test(nome)) {
      alert("Nome inválido");
      return;
    }

    const email = (document.getElementById("candEmail") as HTMLInputElement)
      .value;
    if (!regexEmail.test(email)) {
      alert("E-mail inválido");
      return;
    }

    const cpf = (document.getElementById("candCPF") as HTMLInputElement).value;
    if (!regexCPF.test(cpf)) {
      alert("CPF fora do padrão 000.000.000-00");
      return;
    }

    const telefone = (
      document.getElementById("candTelefone") as HTMLInputElement
    ).value;
    if (!regexTelefone.test(telefone)) {
      alert("Telefone fora do padrão (00)00000-0000 ou (00)0000-0000");
      return;
    }

    const linkedin = (
      document.getElementById("candLinkedin") as HTMLInputElement
    ).value;
    if (!regexLinkedin.test(linkedin)) {
      alert("Linkedin inválido");
      return;
    }

    const skills = (
      document.getElementById("candSkills") as HTMLInputElement
    ).value
      .split(",")
      .map((s) => s.trim())
      .filter(Boolean);

    candidatos.push({ nome, email, cpf, telefone, linkedin, skills });
    localStorage.setItem("candidatos", JSON.stringify(candidatos));
    alert("Candidato cadastrado!");
    candForm.reset();
    renderCandidatos();
  });
}

function renderCandidatos() {
  const lista = document.getElementById(
    "listaCandidatos"
  ) as HTMLUListElement | null;
  if (!lista) return;
  lista.innerHTML = "";
  candidatos.forEach((c) => {
    const li = document.createElement("li");
    li.textContent = `${c.nome} - Habilidades: ${c.skills.join(
      ", "
    )} - Linkedin: ${c.linkedin}`;
    lista.appendChild(li);
  });
}
renderCandidatos();

const empForm = document.getElementById("empForm") as HTMLFormElement | null;
if (empForm) {
  empForm.addEventListener("submit", (e) => {
    e.preventDefault();
    const nome = (document.getElementById("empNome") as HTMLInputElement).value;

    const email = (document.getElementById("empEmail") as HTMLInputElement)
      .value;
    if (!regexEmail.test(email)) {
      alert("E-mail inválido");
      return;
    }

    const cnpj = (document.getElementById("empCNPJ") as HTMLInputElement).value;
    if (!regexCNPJ.test(cnpj)) {
      alert("CNPJ fora do padrão 00.000.000/0000-00");
      return;
    }

    const cep = (document.getElementById("empCEP") as HTMLInputElement).value;
    if (!regexCEP.test(cep)) {
      alert("CEP fora do padrão 00000-000");
      return;
    }

    const descricao = (
      document.getElementById("empDescricao") as HTMLInputElement
    ).value;
    const vagas = (
      document.getElementById("empVagas") as HTMLInputElement
    ).value
      .split(",")
      .map((v) => v.trim())
      .filter(Boolean);

    empresas.push({ nome, email, cnpj, cep, descricao, vagas });
    localStorage.setItem("empresas", JSON.stringify(empresas));
    alert("Empresa cadastrada!");
    empForm.reset();
    renderEmpresas();
  });
}

function renderEmpresas() {
  const lista = document.getElementById(
    "listaEmpresas"
  ) as HTMLUListElement | null;
  if (!lista) return;
  lista.innerHTML = "";
  empresas.forEach((e) => {
    const li = document.createElement("li");
    li.textContent = `${e.nome} - Vagas: ${e.vagas.join(", ")}`;
    lista.appendChild(li);
  });
}
renderEmpresas();

function renderVagas() {
  const lista = document.getElementById(
    "listaVagas"
  ) as HTMLUListElement | null;
  if (!lista) return;
  lista.innerHTML = "";
  empresas.forEach((e) => {
    e.vagas.forEach((v) => {
      const li = document.createElement("li");
      li.textContent = `${v} - Empresa: ${e.nome}`;
      lista.appendChild(li);
    });
  });
}
renderVagas();
