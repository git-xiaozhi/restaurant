<template>
  <div style="padding:16px">
    <h2>菜品列表</h2>
    <div v-for="d in dishes" :key="d.id" style="border-bottom:1px solid #eee;padding:8px 0;">
      <div style="display:flex;justify-content:space-between;">
        <div>
          <div style="font-weight:600">{{d.name}} <small style="color:#888">¥{{d.price}}</small></div>
          <div style="color:#666">{{d.description}}</div>
        </div>
        <div>
          <button @click="add(d)">加入</button>
        </div>
      </div>
    </div>
    <div style="margin-top:16px">
      <router-link to="/cart">去结算 ({{cartCount}})</router-link>
      <span style="float:right"><router-link to="/admin">管理后台</router-link></span>
    </div>
  </div>
</template>

<script>
import api from '../api'
export default {
  data(){ return { dishes: [], cart: [] } },
  computed: {
    cartCount(){ return this.cart.reduce((s,i)=>s+i.qty,0) }
  },
  mounted(){ 
    this.load()
    const saved = localStorage.getItem('cart')
    if (saved) this.cart = JSON.parse(saved)
  },
  methods:{
    async load(){ const res = await api.get('/dishes'); this.dishes = res.data },
    add(d){
      const found = this.cart.find(i=>i.id===d.id)
      if(found) found.qty++
      else this.cart.push({ id:d.id, name:d.name, price:d.price, qty:1 })
      localStorage.setItem('cart', JSON.stringify(this.cart))
      alert('已加入购物车')
    }
  }
}
</script>