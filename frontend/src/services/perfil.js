import { http } from './config'

export default {

    listar:() => {
        return http.get('perfis')
    },

    salvar:(perfil) => {
        return http.post('perfil', perfil)
    },

    atualizar:(perfil) => {
        var parametro = 'perfil/' + perfil.id;
        return http.put(parametro, perfil)
    },

    deletar:(id) => {
        var parametro = 'perfil/' + id;
        return http.delete(parametro)
    }

}