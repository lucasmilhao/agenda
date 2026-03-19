import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import type { ContatoProps } from "../interface/ContatoProps";

const API_URL = "http://localhost:8080";


const fetchdata = async (nomeContato : string): Promise<ContatoProps[]> => {
    const response = await axios.get(`${API_URL}/contatos/nome/${nomeContato}`);

    return response.data;
}


export function useContatoDataPesquisar(nomeContato : string) {
    return useQuery({
        queryFn: () => fetchdata(nomeContato),
        queryKey: ["contatos-data", nomeContato],
        retry: 2
    });
}