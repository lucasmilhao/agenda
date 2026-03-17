import { useState } from 'react';
import './App.css'
import { Cards } from './components/cards/Cards';
import { Modal } from './components/modal/Modal';
import { useContatoData } from './hooks/useContatoData'

function App() {

  const { data } = useContatoData();

  const [isModalOpen, setModalOpen] = useState(false);

  const handleOpenModal = () => {
    setModalOpen(prev => !prev);
  }

  return (
    <>
    <button className='button-criar' onClick={handleOpenModal}>Criar novo Contato</button>
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
