
Vue.component('multiselect', window.VueMultiselect.default);
var app = new Vue({
	el:"#app",
	data:{
		platos:[],
		platosSeleccionado:[]
	},
	mounted:function(){
		axios.get("/api/platos").then((response)=>{
			this.platos = response.data
		})
	},
	watch:{
	
	},
})