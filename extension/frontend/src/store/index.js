import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    fixItems    : [],
    customItems : [],
    customCnt   : 0,
    extension   : "",
  },
  mutations: {
    getExtensionList: (state, payload) => {

      state.fixItems    = payload.fix;
      state.customItems = payload.cus;
      state.customCnt   = payload.cnt;
    },
    resetExtension: (state) => {
      state.extension   = "";
    },
  },
  actions: {

    getExtensionList: ({ commit }) => {
      const url= "/api/extension/data";
      
      axios
      .get(url)
      .then(function (response) { 
        
        let rData = response.data;
        commit('getExtensionList', rData)
      })
      .catch(function (error) {
        console.log(error);
      })
    },

    updateExtension:({ commit },payload)=>{
      const url= "/api/extension/";

      const jsonData = {
        "no"  : payload.no
      , "name": payload.name
      , "select_chk": payload.value
      }

      axios
      .put(url,JSON.stringify(jsonData),{ headers: { 'Content-Type': 'application/json' } }
      )
      .then(function (response) { 

        let rData = response.data;
        commit('getExtensionList', rData)
      })
      .catch(function (error) {
        console.log(error);
      })
    },

    deleteCustomExtension:({commit},payload)=>{
      const url= "/api/extension/"+payload.no

      axios
      .delete(url,{data:JSON.stringify(payload)})
      .then(function (response) { 

        let rData = response.data;
        commit('getExtensionList', rData)
      })
      .catch(function (error) {
        console.log(error);
      })
    },

    insertCustomExtension:({commit},payload)=>{
      const url= "/api/extension/"+payload
      
      axios
      .post(url)
      .then(function (response) {

        let rData = response.data;
        commit('getExtensionList', rData)
        commit('resetExtension')

        alert("추가하였습니다.")
      })
      .catch(function (error) {
        console.log(error);
      })
    },
  },
  modules: {
  }
})
