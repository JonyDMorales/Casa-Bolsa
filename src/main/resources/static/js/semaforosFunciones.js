function getListaSemaforos() {
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
		url : '/semaforosalertas/lista',
		type : 'get',// POST,PUT,DELETE,GET,PATCH
		dataType: 'json',
		processData:false,
		contentType:"application/json",
		success : function(da) { // true
			console.log(da);
			for (var i = 0; i < da.length; i++) {
				

				$("#tableSemaforo").append('<tr>'+
						'<td>'+da[i]['contraparte']+'</td>'+
						'<td>'+da[i]['globalLimit']+'</td>'+
						'<td></td>'+
						'<td></td>'+
					'</tr>');				
			}
		},
		error : function(d) {
			console.log(d);
		}
	});
}