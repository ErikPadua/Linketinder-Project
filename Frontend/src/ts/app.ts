interface Candidato {
  nome: string;
  email: string;
  formacao: string;
  skills: string[];
}

interface Empresa {
  nome: string;
  descricao: string;
  vagas: string[];
}

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
    const email = (document.getElementById("candEmail") as HTMLInputElement)
      .value;
    const formacao = (
      document.getElementById("candFormacao") as HTMLInputElement
    ).value;
    const skills = (
      document.getElementById("candSkills") as HTMLInputElement
    ).value
      .split(",")
      .map((s) => s.trim())
      .filter(Boolean);

    candidatos.push({ nome, email, formacao, skills });
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
    li.textContent = `${c.nome} - ${c.formacao} - Skills: ${c.skills.join(
      ", "
    )}`;
    lista.appendChild(li);
  });
}
renderCandidatos();

const empForm = document.getElementById("empForm") as HTMLFormElement | null;
if (empForm) {
  empForm.addEventListener("submit", (e) => {
    e.preventDefault();
    const nome = (document.getElementById("empNome") as HTMLInputElement).value;
    const descricao = (
      document.getElementById("empDescricao") as HTMLInputElement
    ).value;
    const vagas = (
      document.getElementById("empVagas") as HTMLInputElement
    ).value
      .split(",")
      .map((v) => v.trim())
      .filter(Boolean);

    empresas.push({ nome, descricao, vagas });
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

function renderCandidatosAnonimos() {
  const lista = document.getElementById(
    "listaCandidatosAnon"
  ) as HTMLUListElement | null;
  if (!lista) return;
  lista.innerHTML = "";
  candidatos.forEach((c) => {
    const li = document.createElement("li");
    li.textContent = `Formação: ${c.formacao} - Skills: ${c.skills.join(", ")}`;
    lista.appendChild(li);
  });
}
renderCandidatosAnonimos();
