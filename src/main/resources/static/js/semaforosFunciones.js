function getListaSemaforos() {
	$("#spinner").fadeIn();
	tipoEnvio=0;
	$("#conteTableSemaforo").append('<table class="table table-striped" id="semaforo" >'+
			'<thead>'+
				'<tr>'+
					'<th>Contraparte</th>'+
					'<th>Limite Global</th>'+
					'<th>Límite Utilizado</th>'+
					'<th>Límite Restante</th>'+
				'</tr>'+
			'</thead>'+
			'<tbody id="tableSemaforo">'+
			'</tbody>'+
		'</table>');
	

	$.ajax({
		async : true,
		url : '/semaforosalertas/lista/'+tipoEnvio,
		type : 'get',// POST,PUT,DELETE,GET,PATCH
		dataType: 'json',
		processData:false,
		contentType:"application/json",
		success : function(da) { // true
			console.log(da);
			var arrayContraparte = [], arrayLimiteGlobal = [], arrayLimiteUtilizado = [], arrayLimiteRestante = [];//Pariente
			for (var i = 0; i < da.length; i++) {
				console.log("....");
				var resta = (parseFloat(da[i]['globalLimit']) - parseFloat(da[i]['suma']));
				var porcentaje = ((resta*100) / parseFloat(da[i]['globalLimit']));
				var clase = "";
				if(porcentaje > 50 ){
					clase = "alert alert-success";
				}else if(porcentaje > 25 && porcentaje < 50){
					clase = "alert alert-warning";
				}else{
					clase = "alert alert-danger";
				}				
				$("#tableSemaforo").append('<tr>'+
						'<td>'+da[i]['contraparte']+'</td>'+
						'<td>'+da[i]['globalLimit']+'</td>'+
						'<td>'+da[i]['suma']+'</td>'+
						'<td class="'+clase+'">'+resta+'</td>'+
					'</tr>');
				arrayContraparte.push(da[i]['contraparte']);//Pariente
				arrayLimiteGlobal.push(da[i]['globalLimit']);//Pariente
				arrayLimiteUtilizado.push(da[i]['suma']);//Pariente
				arrayLimiteRestante.push(resta);//Pariente
			}
			showGraficas(arrayContraparte, 'graficaSemaforo', arrayLimiteGlobal, arrayLimiteUtilizado, arrayLimiteRestante);//Pariente
			//$("#spinner").fadeOut();
			getListaSemaforosOperador();
		},
		error : function(d) {
			console.log(d);
		}
	});
	
}

function getListaSemaforosOperador(){
	tipoEnvio=1;
	$("#conteTableSemaforoUsuario").append('<table class="table table-striped" id="semaforoUsuario" >'+
			'<thead>'+
				'<tr>'+
					'<th>Operador</th>'+
					'<th>Limite Global</th>'+
					'<th>Límite Utilizado</th>'+
					'<th>Límite Restante</th>'+
				'</tr>'+
			'</thead>'+
			'<tbody id="tableSemaforoUsuario">'+
			'</tbody>'+
		'</table>');
	
	$.ajax({
		async : true,
		url : '/semaforosalertas/lista/'+tipoEnvio,
		type : 'get',// POST,PUT,DELETE,GET,PATCH
		dataType: 'json',
		processData:false,
		contentType:"application/json",
		success : function(da) { // true
			console.log(da);
			var arrayContraparte = [], arrayLimiteGlobal = [], arrayLimiteUtilizado = [], arrayLimiteRestante = [];//Pariente
			for (var i = 0; i < da.length; i++) {
				console.log("....");
				var resta = (parseFloat(da[i]['globalLimit']) - parseFloat(da[i]['suma']));
				var porcentaje = ((resta*100) / parseFloat(da[i]['globalLimit']));
				var clase = "";
				if(porcentaje > 50 ){
					clase = "alert alert-success";
				}else if(porcentaje > 25 && porcentaje < 50){
					clase = "alert alert-warning";
				}else{
					clase = "alert alert-danger";
				}
				
				$("#tableSemaforoUsuario").append('<tr>'+
						'<td>'+da[i]['contraparte']+'</td>'+
						'<td>'+da[i]['globalLimit']+'</td>'+
						'<td>'+da[i]['suma']+'</td>'+
						'<td class="'+clase+'">'+resta+'</td>'+
					'</tr>');	
				arrayContraparte.push(da[i]['contraparte']);//Pariente
				arrayLimiteGlobal.push(da[i]['globalLimit']);//Pariente
				arrayLimiteUtilizado.push(da[i]['suma']);//Pariente
				arrayLimiteRestante.push(resta);//Pariente
			}
			
			$("#spinner").fadeOut();
			showGraficas(arrayContraparte, 'graficaSemaforoUsuario', arrayLimiteGlobal, arrayLimiteUtilizado, arrayLimiteRestante);//Pariente
		},
		error : function(d) {
			console.log(d);
		}
	});
	
}

function showGraficas(arrayContraparte, idGrafica, arrayLimiteGlobal, arrayLimiteUtilizado, arrayLimiteRestante) {
	console.log("idGrafica "+arrayLimiteGlobal);
	console.log("idGrafica "+arrayLimiteUtilizado);
	console.log("idGrafica "+arrayLimiteRestante);
	var densityCanvas = document.getElementById(idGrafica);
	Chart.defaults.global.defaultFontFamily = "Lato";
	Chart.defaults.global.defaultFontSize = 18;
	
	var dataLimiteGlobal = {
			  label: 'Limite Global',
			  data: arrayLimiteGlobal,
			  backgroundColor: 'rgba(0, 99, 132, 0.6)',
			  borderWidth: 0,
			  yAxisID: "y-axis-gobal"
			};

			var dataLimiteUtilizado = {
			  label: 'Límite Utilizado',
			  data: arrayLimiteUtilizado,
			  backgroundColor: 'rgba(99, 132, 0, 0.6)',
			  borderWidth: 0,
			  yAxisID: "y-axis-gobal"
			};
			
			var dataLimiteRestante = {
					  label: 'Límite Restante',
					  data: arrayLimiteRestante,
					  backgroundColor: 'rgba(99, 0, 0, 0.6)',
					  borderWidth: 0,
					  yAxisID: "y-axis-gobal"
					};
			
			var dataGrafica = {
					  labels: arrayContraparte,
					  datasets: [dataLimiteGlobal, dataLimiteUtilizado, dataLimiteRestante]
					};

					var chartOptions = {
					  scales: {
					    xAxes: [{
					      barPercentage: 1,
					      categoryPercentage: 0.6
					    }],
					    yAxes: [{
					      id: "y-axis-gobal"
					    }]
					  }
					};

					var barChart = new Chart(densityCanvas, {
					  type: 'bar',
					  data: dataGrafica,
					  options: chartOptions
					});
	
}

/*
function limiteUtilizado(contraparte){
	$.ajax({
		async : true,
		url : '/semaforosalertas//'+contraparte,
		type : 'get',// POST,PUT,DELETE,GET,PATCH
		dataType: 'json',
		processData:false,
		contentType:"application/json",
		success : function(da) { // true
			console.log(da);

		},
		error : function(d) {
			console.log(d);
		}
	});
}*/