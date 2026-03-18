import { useState } from "react";
import "./modal.css";
import { useContatoPost } from "../../hooks/useContatoPost";

interface ModalProps {
    closeModal() : void;
}

export function Modal( {closeModal} : ModalProps ) {
    const postData = useContatoPost();
    const [nome, setNome] = useState("");
    const [email, setEmail] = useState("");
    const [telefone, setTelefone] = useState("");
    const [dataNascimento, setDataNascimento] = useState("");
    const [errors, setErrors] = useState({});

    const submit = () => {
        
        postData.mutate({
            nome,
            telefone,
            email,
            dataNascimento
        },
        {
            onError: (err : any) => {
                if(err.response && err.response.data) {
                    setErrors(err.response.data);
                    console.log(JSON.stringify(err.response.data));
                    
                }
            }
        },
    );
    }

    return (
        <div className="modal-overlay">
            <button onClick={closeModal}>X</button>
                <p>Insira nome do contato:</p>
                <input aria-label="nome-input" type="text" value={nome} onChange={e => setNome(e.target.value)}/>
                {errors.nome &&  <p className="errors">{errors.nome}</p>}
                <p>Insira telefone:</p>
                <input aria-label="telefone-input" type="text" value={telefone} onChange={e => setTelefone(e.target.value)}/>
                {errors.telefone &&  <p className="errors">{errors.telefone}</p>} 
                <p>Insira email (opcional):</p>
                <input aria-label="email-input" type="text" value={email} onChange={e => setEmail(e.target.value)}/>
                <p>Selecione data de nascimento:</p>
                <input aria-label="date-input" type="date" value={dataNascimento} onChange={e => setDataNascimento(e.target.value)} />
                {errors.dataNascimento &&  <p className="errors">{errors.dataNascimento}</p>} 
                <button className="button-submit" onClick={submit}>Enviar</button>
                {errors.message &&  <p className="errors">{errors.message}</p>} 
        </div>
    )
}