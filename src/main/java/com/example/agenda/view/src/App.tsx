import { useState } from 'react';
import './App.css'
import { Cards } from './components/cards/Cards';
import { Modal } from './components/modal/Modal';
import { useContatoData } from './hooks/useContatoData'
import { useContatoDataPesquisar } from './hooks/useContatoDataPesquisar';

function App() {

  const [nome, setNome] = useState("");

  const isPesquisando = !!nome;

  const {data : dataPesquisa} = useContatoDataPesquisar(nome);

  const {data : dataTodos} = useContatoData();

  const data = isPesquisando? dataPesquisa : dataTodos;

  const [isModalOpen, setModalOpen] = useState(false);

  const handleOpenModal = () => {
    setModalOpen(prev => !prev);
  }

  return (
    <>
    <button className='button-criar' onClick={handleOpenModal}>Criar novo Contato</button>
    <input className='input-pesquisar' onChange={e => setNome(e.target.value)} value={nome} type="text" placeholder='pesquisar' />
      <div className="container">
        {data?.map((contatoData) =>
          <Cards
            key={contatoData.id}
            id={contatoData.id}
            nome={contatoData.nome}
            telefone={contatoData.telefone}
            email={contatoData.email}
            dataNascimento={contatoData.dataNascimento}
          />
        )}
      </div>
      {isModalOpen && <Modal closeModal={handleOpenModal}></Modal>}
    </>
  )
}

export default App
