/**
 * 
 */

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
						"columns" : [ 4 ],
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

}


function addRow() {
	$("#btnAgregar").slideUp( "slow" )
	$("#tableLimites").prepend('<tr id="rowNewInfo">'+
	'<td><input type="text" id="contraparte" class="form-control"/></td>'+
	'<td><input type="text" id="globalLimit" class="form-control"/></td>'+
	'<td><input type="text" id="directOperationLimit" class="form-control"/></td>'+
	'<td><input type="text" id="reportoOperationLimit" class="form-control"/></td>'+
	'<td><input type="text" id="operationLimitMoneyMarket" class="form-control"/></td>'+
	'<td><input type="text" id="exchangeMarketLimit" class="form-control"/></td>'+
	'<td><input type="text" id="limitOperationExchangeMarket" class="form-control"/></td>'+
	'<td> <a class="btn btn-success btn-xs" style="color: white" onclick="guardar()">Guardar</a></td>'+
'</tr>');
}

function guardar() {
	$.ajax({
		async : true,
		url : '/limiteslineas',
		type : 'post',//POST,PUT,DELETE,GET,PATCH
		dataType: 'json',
		data : JSON.stringify({
			contraparte : $("#contraparte").value(),
			globalLimit : $("#globalLimit").value(),
			directOperationLimit : $("#directOperationLimit").value(),
			reportoOperationLimit : $("#reportoOperationLimit").value(),
			operationLimitMoneyMarket : $("#operationLimitMoneyMarket").value(),
			exchangeMarketLimit : $("#exchangeMarketLimit").value(),
			limitOperationExchangeMarket : $("#limitOperationExchangeMarket").value(),
			mercado : "mexicano",
			usuario : "Roberto"
		}),
		processData:false,
		contentType:"application/json",
		success : function(response) { // true
			console.log(response);
			$("#rowNewInfo").remove();
			$("#tableLimites").prepend('<tr>'+
					'<td>'+response.contraparte+'</td>'+
					'<td>'+response.globalLimit+'</td>'+
					'<td>'+response.directOperationLimit+'</td>'+
					'<td>'+response.reportoOperationLimit+'</td>'+
					'<td>'+response.operationLimitMoneyMarket+'</td>'+
					'<td>'+response.exchangeMarketLimit+'</td>'+
					'<td>'+response.limitOperationExchangeMarket+'</td>'+
					'<td> <a class="btn btn-danger btn-xs" style="color: white" onclick="guardar('+response.id+')">Eliminar</a></td>'+
				'</tr>');
		},
		error : function(d) {
			console.log(d);

		}
	});
}


function update() {
	$.ajax({
		async : true,
		url : '/limiteslineas/2',
		type : 'put',//POST,PUT,DELETE,GET,PATCH
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
	$.ajax({
		async : true,
		url : '/limiteslineas/'+id,
		type : 'delete',//POST,PUT,DELETE,GET,PATCH
		dataType: 'json',
		processData:false,
		contentType:"application/json",
		success : function(da) { // true
			console.log(da);
			$("#row"+id).remove();
		},
		error : function(d) {
			console.log(d);

		}
	});
}