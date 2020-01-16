function getListaSemaforos() {
	$("#spinner").fadeIn();
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
		url : '/semaforosalertas/lista',
		type : 'get',// POST,PUT,DELETE,GET,PATCH
		dataType: 'json',
		processData:false,
		contentType:"application/json",
		success : function(da) { // true
			console.log(da);
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
				
				$("#tableSemaforoUsuario").append('<tr>'+
						'<td>'+da[i]['usuario']+'</td>'+
						'<td>'+da[i]['globalLimit']+'</td>'+
						'<td>'+da[i]['suma']+'</td>'+
						'<td class="'+clase+'">'+resta+'</td>'+
					'</tr>');	
			}
			
			$("#spinner").fadeOut();
		},
		error : function(d) {
			console.log(d);
		}
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