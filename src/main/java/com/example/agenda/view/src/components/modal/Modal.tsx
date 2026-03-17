import { useState } from "react";
import "./modal.css";
import { useContatoPost } from "../../hooks/useContatoPost";
import Swal from "sweetalert2";

interface ModalProps {
    closeModal() : void;
}

export function Modal( {closeModal} : ModalProps ) {
    const postData = useContatoPost();
    const [nome, setNome] = useState("");
    const [email, setEmail] = useState("");
    const [telefone, setTelefone] = useState("");
    const [dataNascimento, setDataNascimento] = useState("");

    const submit = () => {
        
        postData.mutate({
            nome,
            telefone,
            email,
            dataNascimento
        },
        {
            onError: (err : any) => {
                if(err.response) {
                    Swal.fire({
                        title: "Informações inválidas",
                        text:JSON.stringify(err.response.data),
                        icon: "warning"
                    })
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
                <p>Insira telefone:</p>
                <input aria-label="telefone-input" type="text" value={telefone} onChange={e => setTelefone(e.target.value)}/>
                <p>Insira email (opcional):</p>
                <input aria-label="email-input" type="text" value={email} onChange={e => setEmail(e.target.value)}/>
                <p>Selecione data de nascimento:</p>
                <input aria-label="date-input" type="date" value={dataNascimento} onChange={e => setDataNascimento(e.target.value)} />
                <button className="button-submit" onClick={submit}>Enviar</button>
        </div>
    )
}