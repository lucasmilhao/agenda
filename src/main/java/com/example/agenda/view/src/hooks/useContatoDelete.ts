import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";
import axios, { type AxiosPromise } from "axios";

const API_URL = "http://localhost:8080";

const fetchdata = async (id : number): Promise<string> => {
    const response = await axios.delete(`${API_URL}/contatos/${id}`);

    return `Contato ${id} foi deletado`;
}


export function useContatoDelete() {
    const queryClient = useQueryClient();
    return useMutation({
        mutationFn: fetchdata,
        retry: 2,
        onSuccess: () => {
            queryClient.invalidateQueries({queryKey: ["contatos-data"]})
        }
    })
}