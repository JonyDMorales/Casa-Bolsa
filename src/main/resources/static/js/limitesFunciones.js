
var myTable2;

$(document)
		.ready(
				function() {

					myTable2 = $('#limites')
							.DataTable(
									{
										responsive : true,
										"ordering" : true,
										"info" : false,
										"displayLength" : 50,
										"lengthMenu" : [ 50, 100, 150, 200,
												250, 300 ],
										"order" : [ [ 7, "asc" ] ],

										"language" : {
											"sProcessing" : "Procesando...",
											"sLengthMenu" : "Mostrar MENU registros",
											"sZeroRecords" : "No se encontraron resultados",
											"sEmptyTable" : "Ningún dato disponible en esta tabla",
											"sInfo" : "Mostrando registros del START al END de un total de TOTAL registros",
											"sInfoEmpty" : "Mostrando registros del 0 al 0 de un total de 0 registros",
											"sInfoFiltered" : "(filtrado de un total de MAX registros)",
											"sInfoPostFix" : "",
											"sSearch" : "Buscar:",
											"sUrl" : "",
											"sInfoThousands" : ",",
											"sLoadingRecords" : "Cargando...",
											"oPaginate" : {
												"sFirst" : "Primero",
												"sLast" : "Último",
												"sNext" : "Siguiente",
												"sPrevious" : "Anterior"

											},
											"oAria" : {
												"sSortAscending" : ": Activar para ordenar la columna de manera ascendente",
												"sSortDescending" : ": Activar para ordenar la columna de manera descendente"
											}
										}
									});

					myTable2.MakeCellsEditable({
						"onUpdate" : myCallbackFunction2,
						"inputCss" : 'form-control',
						"columns" : [1,2,3,4,5,6,7],
						"allowNulls" : {
							"columns" : [ 3 ],
							"errorClass" : 'error'
						},
						"confirmationButton" : { // could also be true
							"confirmCss" : 'my-confirm-class',
							"cancelCss" : 'my-cancel-class'
						},
						"inputTypes" : [ {
							"column" : 4,
							"type" : "number",
							"options" : null
						},

						// Nothing specified for column 3 so it will default to
						// text

						]
					});

				});

function myCallbackFunction2(updatedCell, updatedRow, oldValue) {
	
	/*console.log(updatedRow.id)
	
	updatedRow.data().forEach(function(element, i) {
	
	
		console.log(element)
	
	})*/
	
	var datos = [];

	console.log(updatedRow.data())
	
    datos.push(updatedRow.data());
	console.log(datos);

	console.log(datos[0][1]);

	
	$.ajax({
		async : true,
		url : '/limiteslineas/'+ datos[0][0],
		type : 'put',// POST,PUT,DELETE,GET,PATCH
		dataType: 'json',
		data : JSON.stringify({
			contraparte : datos[0][1],
			globalLimit : datos[0][2],
			directOperationLimit : datos[0][3],
			reportoOperationLimit : datos[0][4],
			operationLimitMoneyMarket : datos[0][5],
			exchangeMarketLimit : datos[0][6],
			limitOperationExchangeMarket : datos[0][7],
			mercado : "mexicano",
			usuario : "Roberto"
		}),
		processData:false,
		contentType:"application/json",
		success : function(da) { // true
			console.log(da);

		},
		error : function(d) {
			console.log(d);

		}
	});
	
	
	
	
}


function addRow() {
	$("#btnAgregar").slideUp( "slow" )
	$("#tableLimites").prepend('<tr id="rowNewInfo">'+
	'<td><input type="text" id="contraparte" class="form-control"/></td>'+
	'<td><input type="number" id="globalLimit" class="form-control"/></td>'+
	'<td><input type="number" id="directOperationLimit" class="form-control"/></td>'+
	'<td><input type="number" id="reportoOperationLimit" class="form-control"/></td>'+
	'<td><input type="number" id="operationLimitMoneyMarket" class="form-control"/></td>'+
	'<td><input type="number" id="exchangeMarketLimit" class="form-control"/></td>'+
	'<td><input type="number" id="limitOperationExchangeMarket" class="form-control"/></td>'+
	'<td> <a class="btn btn-success btn-xs" style="color: white" onclick="guardar()">Guardar</a></td>'+
'</tr>');
}

function guardar() {
	if($("#contraparte").val()==""){
		alertify.error('Campo contraparte es necesario');
		
	}else if($("#globalLimit").val()==""){
		alertify.error('Campo limite global es necesario');
		
	}else if($("#directOperationLimit").val()==""){
		alertify.error('Campo limite operaciones directo es necesario');

	}else if($("#reportoOperationLimit").val()==""){
		alertify.error('Campo limite operaciones reporto es necesario');

	}else if($("#operationLimitMoneyMarket").val()==""){
		alertify.error('Campo limite por operacion es necesario');

	}else if($("#exchangeMarketLimit").val()==""){
		alertify.error('Campo limite mercado es necesario');

	}else if($("#limitOperationExchangeMarket").val()==""){
		alertify.error('Campo limite por operacion mercado es necesario');

	}else{
		
		
		$.ajax({
			async : true,
			url : '/limiteslineas',
			type : 'post',// POST,PUT,DELETE,GET,PATCH
			dataType: 'json',
			data : JSON.stringify({
				contraparte : $("#contraparte").val(),
				globalLimit : $("#globalLimit").val(),
				directOperationLimit : $("#directOperationLimit").val(),
				reportoOperationLimit : $("#reportoOperationLimit").val(),
				operationLimitMoneyMarket : $("#operationLimitMoneyMarket").val(),
				exchangeMarketLimit : $("#exchangeMarketLimit").val(),
				limitOperationExchangeMarket : $("#limitOperationExchangeMarket").val(),
				mercado : "mexicano",
				usuario : "Roberto"
			}),
			processData:false,
			contentType:"application/json",
			success : function(response) { // true
				console.log(response);
				$("#rowNewInfo").remove();
				$("#tableLimites").prepend('<tr id="row'+response.id+'">'+
						'<td>'+response.contraparte+'</td>'+
						'<td>'+response.globalLimit+'</td>'+
						'<td>'+response.directOperationLimit+'</td>'+
						'<td>'+response.reportoOperationLimit+'</td>'+
						'<td>'+response.operationLimitMoneyMarket+'</td>'+
						'<td>'+response.exchangeMarketLimit+'</td>'+
						'<td>'+response.limitOperationExchangeMarket+'</td>'+
						"<td> <a class=\"btn btn-danger btn-xs\" style=\"color: white\" onclick=\"deleteq('"+response.id+"')\">Eliminar</a></td>"+
					'</tr>');
				Swal.fire('La contraparte se registro correctamente','','success')	
				
				myTable2.draw();
			},
			error : function(d) {
				console.log(d);

			}
		});
		
	}
	

}


function update() {
	$.ajax({
		async : true,
		url : '/limiteslineas/2',
		type : 'put',// POST,PUT,DELETE,GET,PATCH
		dataType: 'json',
		data : JSON.stringify({
			contraparte : "Bancomer2",
			globalLimit : 20001,
			directOperationLimit : 2000,
			reportoOperationLimit : 38208,
			operationLimitMoneyMarket : 90880,
			exchangeMarketLimit : 84783,
			limitOperationExchangeMarket : 8748,
			mercado : "mexicano",
			usuario : "Roberto"
		}),
		processData:false,
		contentType:"application/json",
		success : function(da) { // true
			console.log(da);

		},
		error : function(d) {
			console.log(d);

		}
	});
}


function deleteq(id) {
	Swal.fire({
		  title: '¿Esta seguro de querer eliminar la contraparte?',
		  text: "",
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: 'Aceptar'
		}).then((result) => {
		  if (result.value) {
				$.ajax({
					async : true,
					url : '/limiteslineas/'+id,
					type : 'delete',// POST,PUT,DELETE,GET,PATCH
					dataType: 'json',
					processData:false,
					contentType:"application/json",
					success : function(da) { // true
						console.log(da);
						
					},
					error : function(d) {
						console.log(d);
						$("#row"+id).remove();
						Swal.fire('La contraparte se elimino correctamente','','success')
					}
				});
		  }
		})

}