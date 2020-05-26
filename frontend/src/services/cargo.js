import { http } from './config'

export default {

    listar:() => {
        return http.get('cargos')
    },

    salvar:(cargo) => {
        return http.post('cargo', cargo)
    },

    atualizar:(cargo) => {
        var parametro = 'cargo/'+cargo.id;
        return http.put(parametro, cargo)
    },

    deletar:(id) => {
        var parametro = 'cargo/' + id;
        return http.delete(parametro)
    }

}