import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import type { ContatoProps } from "../interface/ContatoProps";

const API_URL = "http://localhost:8080";

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