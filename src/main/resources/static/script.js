
let tarefas = [];
let proximoId = 1;


const formTarefas = document.getElementById('form-tarefas');
const listaTarefas = document.getElementById('lista-tarefas');
const inputBuscarId = document.getElementById('buscar-id');
const btnBuscar = document.getElementById('btn-buscar');
const btnLimparBusca = document.getElementById('btn-limpar-busca');
const mensagemBusca = document.getElementById('mensagem-busca');


formTarefas.addEventListener('submit', function(event) {
    event.preventDefault();

    const inputTitulo = document.getElementById('titulo');
    const inputDescricao = document.getElementById('descricao');

    const novaTarefa = {
        id: proximoId++,
        titulo: inputTitulo.value.trim(),
        descricao: inputDescricao.value.trim(),
        concluida: false
    };

    tarefas.push(novaTarefa);
    renderizarTarefas(tarefas);

    formTarefas.reset();
    inputTitulo.focus();
});


function renderizarTarefas(lista) {
    listaTarefas.innerHTML = '';

    if (lista.length === 0) {
        listaTarefas.innerHTML = '<p id="sem-tarefas">Nenhuma tarefa encontrada.</p>';
        return;
    }

    lista.forEach(tarefa => {
        const card = document.createElement('div');
        card.className = `card-tarefa ${tarefa.concluida ? 'concluida' : ''}`;
        card.id = `tarefa-${tarefa.id}`;

        card.innerHTML = `
            <span class="tag-id">ID: #${tarefa.id}</span>
            
            
            <div class="conteudo-visualizacao">
                <h3>${tarefa.titulo}</h3>
                <p>${tarefa.descricao}</p>
                <div class="acoes-tarefa">
                    <button type="button" class="btn-concluir">${tarefa.concluida ? 'Desmarcar' : 'Concluir'}</button>
                    <button type="button" class="btn-editar">Editar</button>
                    <button type="button" class="btn-excluir">Excluir</button>
                </div>
            </div>

        
            <div class="conteudo-edicao" style="display: none;">
                <input type="text" class="edit-titulo" value="${tarefa.titulo}">
                <textarea class="edit-descricao" rows="3">${tarefa.descricao}</textarea>
                <div class="acoes-tarefa">
                    <button type="button" class="btn-salvar">Salvar</button>
                    <button type="button" class="btn-cancelar">Cancelar</button>
                </div>
            </div>
        `;

        configurarAcoesCard(card, tarefa.id);
        listaTarefas.appendChild(card);
    });
}

function configurarAcoesCard(card, id) {
    const visualizacao = card.querySelector('.conteudo-visualizacao');
    const edicao = card.querySelector('.conteudo-edicao');

    card.querySelector('.btn-concluir').addEventListener('click', () => {
        const item = tarefas.find(t => t.id === id);
        if (item) {
            item.concluida = !item.concluida;
            renderizarTarefas(tarefas);
        }
    });

    card.querySelector('.btn-excluir').addEventListener('click', () => {
        tarefas = tarefas.filter(t => t.id !== id);
        renderizarTarefas(tarefas);
    });

    card.querySelector('.btn-editar').addEventListener('click', () => {
        visualizacao.style.display = 'none';
        edicao.style.display = 'flex';
    });

    card.querySelector('.btn-cancelar').addEventListener('click', () => {
        edicao.style.display = 'none';
        visualizacao.style.display = 'block';
    });

    card.querySelector('.btn-salvar').addEventListener('click', () => {
        const novoTitulo = card.querySelector('.edit-titulo').value.trim();
        const novaDescricao = card.querySelector('.edit-descricao').value.trim();

        if (!novoTitulo || !novaDescricao) {
            alert('Título e descrição não podem estar vazios.');
            return;
        }

        const item = tarefas.find(t => t.id === id);
        if (item) {
            item.titulo = novoTitulo;
            item.descricao = novaDescricao;
            renderizarTarefas(tarefas);
        }
    });
}

btnBuscar.addEventListener('click', () => {
    const idBuscado = parseInt(inputBuscarId.value);

    if (isNaN(idBuscado)) {
        mensagemBusca.textContent = 'Informe um ID válido.';
        mensagemBusca.style.color = '#c0392b';
        return;
    }

    const tarefaEncontrada = tarefas.find(t => t.id === idBuscado);

    if (tarefaEncontrada) {
        mensagemBusca.textContent = `Tarefa #${idBuscado} encontrada!`;
        mensagemBusca.style.color = '#27ae60';
        renderizarTarefas([tarefaEncontrada]); // Exibe apenas a tarefa encontrada
    } else {
        mensagemBusca.textContent = `Nenhuma tarefa com o ID #${idBuscado}.`;
        mensagemBusca.style.color = '#c0392b';
        renderizarTarefas([]);
    }
});

btnLimparBusca.addEventListener('click', () => {
    inputBuscarId.value = '';
    mensagemBusca.textContent = '';
    renderizarTarefas(tarefas);
});