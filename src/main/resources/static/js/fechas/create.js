Vue.component('datetime',window.VueDatetime.Datetime)
Vue.component('multiselect', window.VueMultiselect.default);
window.LuxonDateTime = window.luxon.DateTime;
var app = new Vue({
	el:"#app",
	data:{
		fechaSeleccionada:'',
		autoDateTime:true,
		menuList:[],
		menuSeleccionado:[],
		fechaSeleccionadaData:'',
		platosMenu:[],
		platoSeleccionado:[],
	},
	mounted(){
		axios.get("/api/menu").then((response)=>{
			this.menuList = response.data
		})
	},
	
	watch:{
		fechaSeleccionada:function(fechaNueva){
			this.fechaSeleccionadaData = LuxonDateTime.fromISO(fechaNueva).toISODate();
		},
		menuSeleccionado:function(){
			this.getPlatosFromMenu();
		}
	},
	methods:{
		getPlatosFromMenu:function(){
			this.platosMenu = []
			axios.get(`/api/menu/${this.menuSeleccionado.id}`).then((response)=>{
				response.data.menuPlatos.map((MenuPlato)=>{
					this.platosMenu.push(MenuPlato.plato)
				})
			})
		}
	}
})