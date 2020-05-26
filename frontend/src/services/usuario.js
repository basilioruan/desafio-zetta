import { http } from './config'

export default {

    listar:() => {
        return http.get('usuarios')
    },

    salvar:(usuario) => {
        return http.post('usuario', usuario)
    },

    atualizar:(usuario) => {
        var parametro = 'usuario/' + usuario.id;
        return http.put(parametro, usuario)
    },

    deletar:(id) => {
        var parametro = 'usuario/' + id;
        return http.delete(parametro)
    }

}