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
		fechasData:[],
		showExportPdf:false
	},
	watch:{
		fechaDesde:function(fechaNuevaDesde){
			this.fechaDesdeFormat = LuxonDateTime.fromISO(fechaNuevaDesde).toISODate();
			if(this.fechaDesdeFormat != ''){
				this.getFechasByFilter();
			}
		},
		fechaHasta:function(fechaNuevaHasta){
			this.fechaHastaFormat = LuxonDateTime.fromISO(fechaNuevaHasta).toISODate();
			if(this.fechaDesdeFormat != ''){
				this.getFechasByFilter();
			}
		},
	},
	methods:{
		getFechasByFilter:function(){
			let formData = new FormData();
			formData.append('desde',this.fechaDesdeFormat);
			formData.append('hasta',this.fechaHastaFormat);
			axios.post('/api/fechas',formData).then((response)=>{
				this.fechasData = response.data
				this.showExportPdf = true;
			})
		}
	}
})