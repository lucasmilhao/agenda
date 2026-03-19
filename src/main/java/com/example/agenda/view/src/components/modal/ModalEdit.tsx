import { useState } from "react";
import "./modal.css";
import { useContatoPost } from "../../hooks/useContatoPost";
import Swal from "sweetalert2";
import { useContatoEdit } from "../../hooks/useContatoEdit";
import type { ContatoProps } from "../../interface/ContatoProps";

interface ModalProps {
    user : ContatoProps,
    closeModal() : void;
}

export function ModalEdit( {user, closeModal} : ModalProps ) {
    const postData = useContatoEdit();
    const [nome, setNome] = useState(user.nome);
    const [email, setEmail] = useState(user.email);
    const [telefone, setTelefone] = useState(user.telefone);
    const [dataNascimento, setDataNascimento] = useState(user.dataNascimento);
    const [errors, setErrors] = useState({});

    const id = user.id;

    const submit = () => {
        console.log(id, nome, telefone, email, dataNascimento);
            
        postData.mutate({
            id,
            nome,
            telefone,
            email,
            dataNascimento
        },
        {
            onError: (err : any) => {
                if(err.response.data) {
                    setErrors(err.response.data);
                }
            }
        },
    );
    }

    return (
        <div className="modal-overlay">
            <button onClick={closeModal}>X</button>
                <h1>Edite seu Contato:</h1>
                <p>Edite nome do contato:</p>
                <input aria-label="nome-input" type="text" value={nome} onChange={e => setNome(e.target.value)}/>
                {errors.nome &&  <p className="errors">{errors.nome}</p>}
                <p>Edite telefone:</p>
                <input aria-label="telefone-input" type="text" value={telefone} onChange={e => setTelefone(e.target.value)}/>
                {errors.telefone &&  <p className="errors">{errors.telefone}</p>} 
                <p>Edite email (opcional):</p>
                <input aria-label="email-input" type="text" value={email} onChange={e => setEmail(e.target.value)}/>
                {errors.email && <p className="errors">{errors.email}</p>}
                <p>Selecione data de nascimento:</p>
                <input aria-label="date-input" type="date" value={dataNascimento} onChange={e => setDataNascimento(e.target.value)} />
                {errors.dataNascimento &&  <p className="errors">{errors.dataNascimento}</p>} 
                <button className="button-submit" onClick={submit}>Enviar</button>
                {errors.message &&  <p className="errors">{errors.message}</p>} 
        </div>
    )
}