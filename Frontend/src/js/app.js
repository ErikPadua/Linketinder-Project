const regexNomeCandidato = /([A-Z])?[a-z]{2,}/;
const regexEmail = /\S+@\w+\.\w{2,6}(\.\w{2})?/;
const regexCPF = /\d{3}\.\d{3}\.\d{3}-\d{2}/;
const regexCNPJ = /\d{2}\.\d{3}\.\d{3}\/\d{4}\-\d{2}/;
const regexCEP = /\d{5}-\d{3}/;
const regexTelefone = /((\(\d{2}\))|(\d{2}))\s?\d{4,5}-?\d{4}/;
const regexLinkedin = /(https:\/\/)?(www\.)?linkedin\.com\/in\/\w+(\/)?/;
const regexTags = /Java|Python|JavaScript|TypeScript|PHP|Kotlin|Groovy|SQL|Ruby|C/i;
const candidatos = JSON.parse(localStorage.getItem("candidatos") || "[]");
const empresas = JSON.parse(localStorage.getItem("empresas") || "[]");
const candForm = document.getElementById("candForm");
if (candForm) {
    candForm.addEventListener("submit", (e) => {
        e.preventDefault();
        const nome = document.getElementById("candNome")
            .value;
        if (!regexNomeCandidato.test(nome)) {
            alert("Nome inválido");
            return;
        }
        const email = document.getElementById("candEmail")
            .value;
        if (!regexEmail.test(email)) {
            alert("E-mail inválido");
            return;
        }
        const cpf = document.getElementById("candCPF").value;
        if (!regexCPF.test(cpf)) {
            alert("CPF fora do padrão 000.000.000-00");
            return;
        }
        const telefone = document.getElementById("candTelefone").value;
        if (!regexTelefone.test(telefone)) {
            alert("Telefone fora do padrão (00)00000-0000 ou (00)0000-0000");
            return;
        }
        const linkedin = document.getElementById("candLinkedin").value;
        if (!regexLinkedin.test(linkedin)) {
            alert("Linkedin inválido");
            return;
        }
        const skills = document.getElementById("candSkills").value
            .split(",")
            .map((s) => s.trim())
            .filter(Boolean)
            .filter((s) => regexTags.test(s));
        candidatos.push({ nome, email, cpf, telefone, linkedin, skills });
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
        li.textContent = `${c.nome} | [Habilidades]: ${c.skills.join(", ")} | [Linkedin]: ${c.linkedin}`;
        lista.appendChild(li);
    });
}
renderCandidatos();
const empForm = document.getElementById("empForm");
if (empForm) {
    empForm.addEventListener("submit", (e) => {
        e.preventDefault();
        const nome = document.getElementById("empNome").value;
        const email = document.getElementById("empEmail")
            .value;
        if (!regexEmail.test(email)) {
            alert("E-mail inválido");
            return;
        }
        const cnpj = document.getElementById("empCNPJ").value;
        if (!regexCNPJ.test(cnpj)) {
            alert("CNPJ fora do padrão 00.000.000/0000-00");
            return;
        }
        const cep = document.getElementById("empCEP").value;
        if (!regexCEP.test(cep)) {
            alert("CEP fora do padrão 00000-000");
            return;
        }
        const descricao = document.getElementById("empDescricao").value;
        const vagas = document.getElementById("empVagas").value
            .split(",")
            .map((v) => v.trim())
            .filter(Boolean);
        empresas.push({ nome, email, cnpj, cep, descricao, vagas });
        localStorage.setItem("empresas", JSON.stringify(empresas));
        alert("Empresa cadastrada!");
        empForm.reset();
    });
}
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
export {};
//# sourceMappingURL=app.js.map