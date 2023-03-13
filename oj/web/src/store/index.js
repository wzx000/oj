import { createStore } from 'vuex'
import ModuleUser from './user'
import ModuleProblem from './problem'

export default createStore({
  state: {
  },
  mutations: {
  },
  actions: {
  },
  modules: {
    user:ModuleUser,
    problem:ModuleProblem,
  }
})
