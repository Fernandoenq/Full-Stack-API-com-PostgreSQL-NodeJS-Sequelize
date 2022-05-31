async function consultar(){
    let dados = await fetch('http://localhost:8080/jogo')
    .then(response => {
        return response.json()
    })
    .catch(error => {
        console.log(error)
    });
    let result = ""
    dados.map( dado => {
        result += `<tr> <td> ${dado.nome} </td> <td> ${dado.categoria} </td> <td> ${dado.preco} </td> <td> ${dado.nota} </td> <td> ${dado.requisitos} </td> <td> ${dado.so} </td> <td>  <i onClick="remove(${dado.id})" class="bi bi-trash"></i> </td> <td> <i onClick="atualiza(${dado.id}, '${dado.nome}', '${dado.catgoria}', ${dado.preco}, ${dado.nota}, '${dado.requisitos}', '${dado.so}')" class="bi bi-pencil"></i> </td> </tr>`
    })
    document.getElementById("conteudoTabela").innerHTML = result
}

function atualiza(id, nome, categoria, preco, nota, requisitos, so){
    document.getElementById("id").value = id;
    document.getElementById("nome").value = nome
    document.getElementById("categoria").value = categoria
    document.getElementById("preco").value = preco
    document.getElementById("nota").value = nota
    document.getElementById("requisitos").value = requisitos
    document.getElementById("so").value = so

} 
async function cadastrar(){
    let id = document.getElementById("id").value
    let nome = document.getElementById("nome").value
    let categoria = document.getElementById("categoria").value
    let preco = Number(document.getElementById("preco").value)
    let nota = Number(document.getElementById("nota").value)
    let requisitos = document.getElementById("requisitos").value
    let so = document.getElementById("so").value

    let dados
    let metodo
    if (id) { // atualiza
        dados = {
            id, nome, categoria, preco, nota, requisitos, so
        }
        metodo = 'PUT'
        alert(`PUT`)
    }
    else {
        dados = {
            id, nome, categoria, preco, nota, requisitos, so
        }
        metodo = 'POST'
        alert(`POST`)
    }
    
    await fetch('http://localhost:8080/jogo', {
        method: metodo,
        body: JSON.stringify(dados),
        headers: {"Content-Type": "application/json; charset=UTF-8"}
    })
    .then(response => {
       alert(`Pokemon cadastrado / atualizado com sucesso`)
    })
    .catch(error => {
        console.log(error)
    });
    consultar() // atualiza os pokemons
}

async function remove(id){
    let resposta = confirm(`Confirma a exclusão`)
    if (resposta) {
        await fetch(`http://localhost:8080/jogo/${id}`, {
            method: 'DELETE'
        })
        .then(response => {
            alert(`Pokemon removido com sucesso`)
         })
         .catch(error => {
             console.log(error)
         });
         consultar() // atualiza os pokemons
    }
}