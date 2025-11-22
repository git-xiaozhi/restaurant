<template>
  <div style="padding:16px">
    <h2>购物车</h2>
    <div v-if="!cart.length">购物车为空。<router-link to="/">去点菜</router-link></div>
    <div v-for="item in cart" :key="item.id" style="display:flex;justify-content:space-between;padding:8px 0;border-bottom:1px solid #eee;">
      <div>{{item.name}} x {{item.qty}}</div>
      <div>¥{{(item.price*item.qty).toFixed(2)}}</div>
    </div>
    <div style="margin-top:12px">
      <div>合计: ¥{{total.toFixed(2)}}</div>
      <div style="margin-top:8px">
        <button @click="checkout">提交订单</button>
        <button @click="clearCart" style="margin-left:8px">清空</button>
      </div>
      <div style="margin-top:8px">
        <router-link to="/">回到菜品页</router-link>
      </div>
    </div>
  </div>
</template>

<script>
import api from '../api'
export default {
  data(){ return { cart: [] } },
  computed: { total(){ return this.cart.reduce((s,i)=>s+i.price*i.qty,0) } },
  mounted(){ const saved = localStorage.getItem('cart'); if(saved) this.cart = JSON.parse(saved) },
  methods:{
    async checkout(){
      const payload = { customerName: '手机用户', total: this.total, items: this.cart }
      await api.post('/orders', payload)
      alert('下单成功')
      this.clearCart()
    },
    clearCart(){ this.cart = []; localStorage.removeItem('cart') }
  }
}
</script>