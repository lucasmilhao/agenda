import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";
import axios, { type AxiosPromise } from "axios";

const API_URL = "http://localhost:8080";


interface ContatoProps {
    nome : string,
    telefone : string,
    email : string,
    dataNascimento : string
}

const fetchdata = async (data : ContatoProps): Promise<ContatoProps> => {
    const response = await axios.post(`${API_URL}/contatos`, data);

    return response.data;
}


export function useContatoPost() {
    const queryClient = useQueryClient();
    return useMutation({
        mutationFn: fetchdata,
        retry: 0,
        onSuccess: () => {
            queryClient.invalidateQueries({queryKey: ["contatos-data"]})
        }
    })
}