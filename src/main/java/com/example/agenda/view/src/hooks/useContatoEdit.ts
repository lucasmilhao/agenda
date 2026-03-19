import { useMutation, useQueryClient } from "@tanstack/react-query";
import axios from "axios";

const API_URL = "http://localhost:8080";


interface ContatoProps {
    id : number,
    nome : string,
    telefone : string,
    email : string,
    dataNascimento : string
}

const fetchdata = async (data : ContatoProps): Promise<ContatoProps> => {
    const response = await axios.put(`${API_URL}/contatos/${data.id}`, data);

    return response.data;
}


export function useContatoEdit() {
    const queryClient = useQueryClient();
    return useMutation({
        mutationFn: fetchdata,
        retry: 0,
        onSuccess: () => {
            queryClient.invalidateQueries({queryKey: ["contatos-data"]})
        }
    })
}