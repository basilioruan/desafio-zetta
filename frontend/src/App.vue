<template>
  <div id="app">

    <nav>
      <div class="nav-wrapper blue darken-1">
        <a href="#" class="brand-logo center">GERENCIADOR DE USUÁRIOS</a>
      </div>
    </nav>

    <div class="container">
      <!-- INÍCIO DO CÓDIGO DE CARGOS -->
      <h3><b>Cargos</b></h3>

      <ul>
        <li v-for="(erro, index) of erros" :key="index"> 
          campo <b> {{erro.field}} </b> - {{erro.defaultMessage}}
        </li>
      </ul>

      <form @submit.prevent="salvarCargo">

          <label>Cargo</label>
          <input type="text" placeholder="Nome" v-model="cargo.nome">
          <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button>

      </form>

      <table>

        <thead>

          <tr>
            <th>NOME</th>
            <th>OPÇÕES</th>
          </tr>

        </thead>

        <tbody>

          <tr v-for="cargo of cargos" :key="cargo.id">
            
            <td>{{cargo.nome}}</td>
            <td>
              <button @click="editarCargo(cargo)" class="waves-effect btn-small blue darken-1"><i class="material-icons">create</i></button>
              <button @click="removerCargo(cargo.id)" class="waves-effect btn-small red darken-1"><i class="material-icons">delete_sweep</i></button>
            </td>

          </tr>

        </tbody>
      
      </table>
      <!-- FIM DO CÓDIGO DE CARGO -->

      <!-- INICIO DO CÓDIGO DE PERFIL -->
      <h3><b>Perfil</b></h3>
      <ul>
        <li v-for="(erro, index) of erros" :key="index"> 
          campo <b> {{erro.field}} </b> - {{erro.defaultMessage}}
        </li>
      </ul>

      <form @submit.prevent="salvarPerfil">

          <label>Perfil</label>
          <input type="text" placeholder="Nome" v-model="perfil.nome">
          <button class="waves-effect waves-light btn-small">salvar<i class="material-icons left">save</i></button>

      </form>

      <table>

        <thead>

          <tr>
            <th>NOME</th>
            <th>OPÇÕES</th>
          </tr>

        </thead>

        <tbody>
          
          <tr v-for="perfil of perfis" :key="perfil.id">
          
            <td>{{perfil.nome}}</td>
            <td>
              <button @click="editarPerfil(perfil)" class="waves-effect btn-small blue darken-1"><i class="material-icons">create</i></button>
              <button @click="removerPerfil(perfil.id)" class="waves-effect btn-small red darken-1"><i class="material-icons">delete_sweep</i></button>
            </td>

          </tr>
          

        </tbody>
      
      </table>

      <!-- FIM DO CÓDIGO DO PERFIL -->

      <!-- INÍCIO DO CÓDIGO DO USUÁRIO -->
      <h3><b>Usuário</b></h3>
      <ul>
        <li v-for="(erro, index) of erros" :key="index"> 
          campo <b> {{erro.field}} </b> - {{erro.defaultMessage}}
        </li>
      </ul>

      <form @submit.prevent="salvarUsuario">
        <label>Usuário</label>
        <input type="text" placeholder="Nome" v-model="usuario.nome">
        <input type="text" placeholder="CPF" v-model="usuario.cpf">
        <input type="text" placeholder="DD/MM/YYYY" v-model="usuario.dataNascimento">
        <label id="genero" for="M">Masculino</label> 
        <input id="opacidade" name="sexo" type="radio" value="M" v-model="usuario.sexo">
        <label id="generoF" for="F">Feminino</label> 
        <input id="opacidade" name="sexo" type="radio" value="F" v-model="usuario.sexo">
        <select id="lista" v-model="usuario.cargo">
          <option v-for="cargo in cargos" :value="cargo" :key="cargo.id">{{cargo.nome}}</option>
        </select>
        <div v-for="perfil in perfis" :key="perfil.id">
          <input id="opacidade" type="checkbox" :value="perfil" v-model="usuario.perfis">
          <label id="genero" :for="perfil.id"> {{ perfil.nome }}</label>
        </div>
        <button class="waves-effect waves-light btn-small">salvar<i class="material-icons left">save</i></button>

      </form>

      <table>

        <thead>

          <tr>
            <th>NOME</th>
            <th>CPF</th>
            <th>DATA DE NASCIMENTO</th>
            <th>SEXO</th>
            <th>CARGO</th>
            <th>PERFIL</th>
            <th>OPÇÕES</th>
          </tr>

        </thead>

        <tbody>
          
          <tr v-for="usuario of usuarios" :key="usuario.id">
          
            <td>{{usuario.nome}}</td>
            <td>{{usuario.cpf}}</td>
            <td>{{converterData(usuario.dataNascimento)}}</td>
            <td>{{usuario.sexo}}</td>
            <td>{{usuario.cargo.nome}}</td>
            <td>{{usuario.perfis}}</td>
            <td>
              <button @click="editarUsuario(usuario)" class="waves-effect btn-small blue darken-1"><i class="material-icons">create</i></button>
              <button @click="removerUsuario(usuario.id)" class="waves-effect btn-small red darken-1"><i class="material-icons">delete_sweep</i></button>
            </td>

          </tr>
          

        </tbody>
      
      </table>
      <!-- FIM DO CÓDIGO DO USUÁRIO -->
    </div>

    

  </div>

  
</template>

<script>
  import Cargo from './services/cargo'
  import Perfil from './services/perfil'
  import Usuario from './services/usuario'
  import moment from 'moment'

  export default {
    data(){
      return {
        cargo: {
          id: '',
          nome: ''
        },
        cargos: [],
        erros: [],

        perfil: {
          id: '',
          nome: ''
        },
        perfis: [],

        usuario: {
          id: '',
          nome: '',
          cpf: '',
          dataNascimento: '',
          sexo: '',
          cargo: '',
          perfis: [],
        },
        usuarios: [],
      }
    },

    mounted(){
      this.listarCargo()
      this.listarPerfil()
      this.listarUsuario()
    }, 

    methods: {
      //------------------- Métodos Cargo -------------------
      listarCargo(){
        Cargo.listar().then(resposta => {
          this.cargos = resposta.data
        })
      },

      salvarCargo(){
        if(this.cargo.nome){
          if(this.cargo.id){
            Cargo.atualizar(this.cargo).then(resposta => {
              this.cargo = {}
              alert("Cargo editado com sucesso!")
              this.listarCargo()
              this.errors = []
            }).catch( e => {
              this.erros = e.response.data.errors
            })
          } 
          else {
            Cargo.salvar(this.cargo).then(resposta => {
              this.cargo = {}
              this.listarCargo()
              this.errors = []
            }).catch( e => {
              this.erros = e.response.data.errors
            })
          }
        }
        else {
          alert("O nome do cargo não pode ser vazio")
        }
      },

      editarCargo(cargo){
        this.cargo = cargo
      },

      removerCargo(id) {
        if(confirm('Deseja realmente apagar o cargo?')){
          Cargo.deletar(id).then(resposta => {
            this.listarCargo()
            this.errors = []
          }).catch( e => {
            this.erros = e.response.data.errors
          })
        }
      },

      //------------------- Métodos Perfil -------------------
      listarPerfil(){
        Perfil.listar().then(resposta => {
          this.perfis = resposta.data
        })
      },

      salvarPerfil(){
        if(this.perfil.id){
          Perfil.atualizar(this.perfil).then(resposta => {
            this.perfil = {}
            alert("Perfil editado com sucesso!")
            this.listarPerfil()
            this.errors = []
          }).catch( e => {
            this.erros = e.response.data.errors
          })
        } 
        else {
          if(this.perfil.nome){
            Perfil.salvar(this.perfil).then(resposta => {
              this.perfil = {}
              this.listarPerfil()
              this.errors = []
            }).catch( e => {
              this.erros = e.response.data.errors
            })
          }
          else {
            alert("O nome do perfil não pode ser vazio")
          }
        }
      },

      editarPerfil(perfil){
        this.perfil = perfil
      },

      removerPerfil(id) {
        if(confirm('Deseja realmente apagar esse perfil?')){
          Perfil.deletar(id).then(resposta => {
            this.listarPerfil()
            this.errors = []
          }).catch( e => {
            this.erros = e.response.data.errors
          })
        }
      },

      //------------------- Métodos Usuário -------------------
      listarUsuario(){
        Usuario.listar().then(resposta => {
          this.usuarios = resposta.data
        })
      },

      salvarUsuario(){
        this.usuario.dataNascimento=moment(this.usuario.dataNascimento).format('YYYY-MM-DD hh:mm:ss')
        if(this.usuario.id){
          Usuario.atualizar(this.usuario).then(resposta => {
            this.usuario = {}
            alert("Usuário editado com sucesso!")
            this.listarUsuario()
            this.errors = []
          }).catch( e => {
            this.erros = e.response.data.errors
          })
        } 
        else {
          if(this.usuario.nome){
            Usuario.salvar(this.usuario).then(resposta => {
              this.usuario = {}
              this.listarUsuario()
              this.errors = []
            }).catch( e => {
              this.erros = e.response.data.errors
            })
          }
          else {
            alert("O nome do usuário não pode ser vazio")
          }
        }
      },

      editarUsuário(usuario){
        this.usuario = usuario
      },

      removerUsuario(id) {
        if(confirm('Deseja realmente apagar esse usuário?')){
          Usuario.deletar(id).then(resposta => {
            this.listarUsuario()
            this.errors = []
          }).catch( e => {
            this.erros = e.response.data.errors
          })
        }
      },

      converterData(data){
        return moment(data).format('DD/MM/YYYY')
      },

      converterDataBD(data) {
        alert("AAAAAAA")
        return moment(data).format('YYYY-MM-DD hh:mm:ss')
      }
    }
  }

  

</script>

<style>
  #opacidade {
    opacity: 100;
    pointer-events: painted;
    position: relative;
  }

  #genero {
    padding-right: 2px;
    font-size: 18px;
  }

  #generoF {
    padding-left: 30px;
    padding-right: 2px;
    font-size: 18px;
  }

  #lista {
    display: block;
    width: 200px;
  }
</style>
