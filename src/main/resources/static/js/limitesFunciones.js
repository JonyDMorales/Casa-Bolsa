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

function guardar() {
	$.ajax({
		async : true,
		url : '/limiteslineas',
		type : 'post',//POST,PUT,DELETE,GET,PATCH
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


function deleteq() {
	$.ajax({
		async : true,
		url : '/limiteslineas/2',
		type : 'delete',//POST,PUT,DELETE,GET,PATCH
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
}