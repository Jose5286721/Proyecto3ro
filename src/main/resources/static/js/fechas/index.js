Vue.component('datetime',window.VueDatetime.Datetime)
window.LuxonDateTime = window.luxon.DateTime;
var app = new Vue({
	el:"#app",
	data:{
		fechaDesde:'',
		fechaHasta:'',
		autoDateTime:true,
		fechaDesdeFormat:'',
		fechaHastaFormat:'',
		fechasData:[]
	},
	watch:{
		fechaDesde:function(fechaNuevaDesde){
			this.fechaDesdeFormat = LuxonDateTime.fromISO(fechaNuevaDesde).toISODate();
		},
		fechaHasta:function(fechaNuevaHasta){
			this.fechaHastaFormat = LuxonDateTime.fromISO(fechaNuevaHasta).toISODate();
			this.getFechasByFilter();
		},
	},
	methods:{
		getFechasByFilter:function(){
			let formData = new FormData();
			formData.append('desde',this.fechaDesdeFormat);
			formData.append('hasta',this.fechaHastaFormat);
			axios.post('/api/fechas',formData).then((response)=>{
				this.fechasData = response.data
				console.log(response.data);
			})
		}
	}
})