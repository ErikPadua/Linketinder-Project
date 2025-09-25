const candidatos = JSON.parse(localStorage.getItem("candidatos") || "[]");
const empresas = JSON.parse(localStorage.getItem("empresas") || "[]");
// ----- Cadastro de Candidato -----
const candForm = document.getElementById("candForm");
if (candForm) {
    candForm.addEventListener("submit", (e) => {
        e.preventDefault();
        const nome = document.getElementById("candNome")
            .value;
        const email = document.getElementById("candEmail")
            .value;
        const formacao = document.getElementById("candFormacao").value;
        const skills = document.getElementById("candSkills").value
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
    const lista = document.getElementById("listaCandidatos");
    if (!lista)
        return;
    lista.innerHTML = "";
    candidatos.forEach((c) => {
        const li = document.createElement("li");
        li.textContent = `${c.nome} - ${c.formacao} - Skills: ${c.skills.join(", ")}`;
        lista.appendChild(li);
    });
}
renderCandidatos();
// ----- Cadastro de Empresa -----
const empForm = document.getElementById("empForm");
if (empForm) {
    empForm.addEventListener("submit", (e) => {
        e.preventDefault();
        const nome = document.getElementById("empNome").value;
        const descricao = document.getElementById("empDescricao").value;
        const vagas = document.getElementById("empVagas").value
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
    const lista = document.getElementById("listaEmpresas");
    if (!lista)
        return;
    lista.innerHTML = "";
    empresas.forEach((e) => {
        const li = document.createElement("li");
        li.textContent = `${e.nome} - Vagas: ${e.vagas.join(", ")}`;
        lista.appendChild(li);
    });
}
renderEmpresas();
// ----- Perfil do Candidato -----
function renderVagas() {
    const lista = document.getElementById("listaVagas");
    if (!lista)
        return;
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
// ----- Perfil da Empresa -----
function renderCandidatosAnonimos() {
    const lista = document.getElementById("listaCandidatosAnon");
    if (!lista)
        return;
    lista.innerHTML = "";
    candidatos.forEach((c) => {
        const li = document.createElement("li");
        li.textContent = `Formação: ${c.formacao} - Skills: ${c.skills.join(", ")}`;
        lista.appendChild(li);
    });
}
renderCandidatosAnonimos();
export {};
//# sourceMappingURL=app.js.map