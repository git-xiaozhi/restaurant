<template>
  <div style="padding:16px">
    <h2>后台管理（桌面使用）</h2>
    <div style="margin-bottom:12px">
      <input v-model="form.name" placeholder="名称" />
      <input v-model="form.price" placeholder="价格" />
      <input v-model="form.description" placeholder="描述" />
      <button @click="create">新增</button>
    </div>
    <div v-for="d in dishes" :key="d.id" style="padding:8px;border-bottom:1px solid #ddd;">
      <div style="display:flex;justify-content:space-between">
        <div>
          <b>{{d.name}}</b> ¥{{d.price}} <div style="color:#666">{{d.description}}</div>
        </div>
        <div>
          <button @click="remove(d.id)">删除</button>
        </div>
      </div>
    </div>
    <div style="margin-top:16px"><router-link to="/">手机端</router-link></div>
  </div>
</template>

<script>
import api from '../api'
export default {
  data(){ return { dishes: [], form: { name:'', price:0, description:'' } } },
  mounted(){ this.load() },
  methods:{
    async load(){ const res = await api.get('/dishes'); this.dishes = res.data },
    async create(){
      await api.post('/dishes', { name:this.form.name, price: parseFloat(this.form.price), description:this.form.description, available:1 })
      this.form = { name:'', price:0, description:'' }
      this.load()
    },
    async remove(id){ await api.delete(`/dishes/${id}`); this.load() }
  }
}
</script>