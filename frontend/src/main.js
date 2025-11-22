import { createApp } from 'vue'
import { createRouter, createWebHistory } from 'vue-router'
import App from './App.vue'
import Menu from './views/Menu.vue'
import Cart from './views/Cart.vue'
import Admin from './views/Admin.vue'

const routes = [
  { path: '/', component: Menu },
  { path: '/cart', component: Cart },
  { path: '/admin', component: Admin }
]
const router = createRouter({ history: createWebHistory(), routes })
createApp(App).use(router).mount('#app')