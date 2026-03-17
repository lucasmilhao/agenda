import { useQuery } from "@tanstack/react-query";
import axios, { type AxiosPromise } from "axios";

const API_URL = "http://localhost:8080";

interface ContatoProps {
    id : number,
    nome : string,
    telefone : string,
    email : string,
    dataNascimento : string
}

const fetchdata = async (): Promise<ContatoProps[]> => {
    const response = await axios.get(`${API_URL}/contatos`);

    return response.data;
}


export function useContatoData() {
    return useQuery({
        queryFn: fetchdata,
        queryKey: ["contatos-data"],
        retry: 2
    });
}