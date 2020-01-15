
var myTable2;

$(document)
		.ready(
				function() {

					
				});

function myCallbackFunction2(updatedCell, updatedRow, oldValue) {
	
	/*
	 * console.log(updatedRow.id)
	 * 
	 * updatedRow.data().forEach(function(element, i) {
	 * 
	 * 
	 * console.log(element) })
	 */
	
	var datos = [];

	console.log(updatedRow.data())
	
    datos.push(updatedRow.data());
	console.log(datos);


	var id = datos[0]['DT_RowId'];
	$.ajax({
		async : true,
		url : '/limiteslineas/'+ id,
		type : 'put',// POST,PUT,DELETE,GET,PATCH
		dataType: 'json',
		data : JSON.stringify({
			contraparte : datos[0][0],
			globalLimit : datos[0][1],
			directOperationLimit : datos[0][2],
			reportoOperationLimit : datos[0][3],
			operationLimitMoneyMarket : datos[0][4],
			exchangeMarketLimit : datos[0][5],
			limitOperationExchangeMarket : datos[0][6],
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
	myTable2.row.add( [
'<input type="text" id="contraparte" class="form-control"/>',
'<input type="number" id="globalLimit" class="form-control"/>',
'<input type="number" id="directOperationLimit" class="form-control"/>',
'<input type="number" id="reportoOperationLimit" class="form-control"/>',
'<input type="number" id="operationLimitMoneyMarket" class="form-control"/>',
'<input type="number" id="exchangeMarketLimit" class="form-control"/>',
'<input type="number" id="limitOperationExchangeMarket" class="form-control"/>',
'<a class="btn btn-danger btn-xs" style="color: white" onclick="cancel(this)">X</a><a class="btn btn-success btn-xs" style="color: white" onclick="guardar(this)">&#10003;</a>'] ).draw( false );
}

function cancel(row){
	$("#btnAgregar").slideDown( "slow" )
	myTable2.row( $(row).parents('tr') ).remove();
	myTable2.draw();
}

function guardar(row) {
	var validacionLimiteGlobal=(parseInt($("#directOperationLimit").val()))+(parseInt($("#reportoOperationLimit").val()))+(parseInt($("#exchangeMarketLimit").val()));
	//console.log(validacionLimiteGlobal)
	var validacionOperacionMercadoMoney=(parseInt($("#directOperationLimit").val()))+(parseInt($("#reportoOperationLimit").val()));
	//console.log(validacionOperacionMercadoMoney)
	var validacionOperacionMercadoCambios=(parseInt($("#exchangeMarketLimit").val()));
	//console.log(validacionOperacionMercadoCambios)
	
	
	if($("#contraparte").val()==""){
		alertify.set('notifier', 'position', 'bottom-left');
		alertify.error('Campo contraparte es necesario');
	}else if($("#globalLimit").val()==""){
		alertify.set('notifier', 'position', 'bottom-left');
		alertify.error('Campo limite global es necesario');
		
	}else if($("#directOperationLimit").val()==""){
		alertify.set('notifier', 'position', 'bottom-left');
		alertify.error('Campo limite operaciones directo es necesario');

	}else if($("#reportoOperationLimit").val()==""){
		alertify.set('notifier', 'position', 'bottom-left');
		alertify.error('Campo limite operaciones reporto es necesario');

	}else if($("#operationLimitMoneyMarket").val()==""){
		alertify.set('notifier', 'position', 'bottom-left');
		alertify.error('Campo limite por operacion es necesario');

	}else if($("#exchangeMarketLimit").val()==""){
		alertify.set('notifier', 'position', 'bottom-left');
		alertify.error('Campo limite mercado es necesario');

	}else if($("#limitOperationExchangeMarket").val()==""){
		alertify.set('notifier', 'position', 'bottom-left');
		alertify.error('Campo limite por operacion mercado es necesario');

	}else if($("#globalLimit").val()<validacionLimiteGlobal){
		
		$("#globalLimit").focus();
		alertify.set('notifier', 'position', 'bottom-left');
		alertify.error('El campo limite global debe ser mayor');
	}else if($("#operationLimitMoneyMarket").val()>validacionOperacionMercadoMoney){
		
		$("#operationLimitMoneyMarket").focus();
		alertify.set('notifier', 'position', 'bottom-left');
		alertify.error('El campo limite por operación debe ser menor');
	}else if($("#limitOperationExchangeMarket").val()>validacionOperacionMercadoCambios){
		
		$("#limitOperationExchangeMarket").focus();
		alertify.set('notifier', 'position', 'bottom-left');
		alertify.error('El campo limite por operación mercado de cambios debe ser menor');
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
				
				
				
			
				
				
				myTable2.row.add([
					 response.contraparte,
					 response.globalLimit,
					 response.directOperationLimit,
					 response.reportoOperationLimit,
					 response.operationLimitMoneyMarket,
					 response.exchangeMarketLimit,
					 response.limitOperationExchangeMarket,
					 "<a class=\"btn btn-danger btn-xs\" style=\"color: white\" onclick=\"deleteq('"+response.id+"')\">Eliminar</a>"
			        ]).node().id = response.id;
				myTable2.row( $(row).parents('tr') ).remove();
				myTable2.draw();
				Swal.fire('La contraparte se registro correctamente','','success')	
				
				
			},
			error : function(d) {
				console.log(d.statusText);

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


function deleteq(id,data) {
	
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
						
						myTable2.row( $(data).parents('tr') ).remove().draw();
						Swal.fire('La contraparte se elimino correctamente','','success')
					}
				});
		  }
		})

}




function getLista(tipo) {

	
	$.ajax({
		async : true,
		url : '/limiteslineas/lista',
		type : 'get',// POST,PUT,DELETE,GET,PATCH
		dataType: 'json',
		processData:false,
		contentType:"application/json",
		success : function(da) { // true
			console.log(da);
			
			$("#conteTable").empty()
			
			if(tipo == "contraparte"){
				
				$("#conteTable").append('<table class="table table-striped" id="limites" >'+
						'<thead>'+ 
							'<tr>'+
								'<th>contraparte</th>'+
								'<th>Limite Global</th>'+
								'<th>Límite Operaciones Directo</th>'+
								'<th>Límite Operaciones en Reporto</th>'+
								'<th>Límite por Operción</th>'+
								'<th>Límite Mercado de Cambios</th>'+
								'<th>Límite por Operción Mercado de Cambios</th>'+
								'<th></th>'+
							'</tr>'+
						'</thead>'+
						'<tbody id="tableLimites">'+
							
						'</tbody>'+
					'</table>');
				for (var i = 0; i < da.length; i++) {
					$("#tableLimites").append('<tr  id="'+da[i]['contraparte']+'">'+
						'<td>'+da[i]['contraparte']+'</td>'+
						'<td>'+da[i]['globalLimit']+'</td>'+
						'<td>'+da[i]['directOperationLimit']+'</td>'+
						'<td>'+da[i]['reportoOperationLimit']+'</td>'+
						'<td>'+da[i]['operationLimitMoneyMarket']+'</td>'+
						'<td>'+da[i]['exchangeMarketLimit']+'</td>'+
						'<td>'+da[i]['limitOperationExchangeMarket']+'</td>'+
						'<td> <a class="btn btn-danger btn-xs" style="color: white">Eliminar</a></td>'+
					'</tr>');
					
					
					
				}
				
				
				
				
			}else{
				
				$("#conteTable").append('<table class="table table-striped" id="limites" >'+
						'<thead>'+ 
							'<tr>'+
								'<th>Operador</th>'+
								'<th>Limite Global</th>'+
								'<th>Límite Operaciones Directo</th>'+
								'<th>Límite Operaciones en Reporto</th>'+
								'<th>Límite por Operción</th>'+
								'<th>Límite Mercado de Cambios</th>'+
								'<th>Límite por Operción Mercado de Cambios</th>'+
								'<th></th>'+
							'</tr>'+
						'</thead>'+
						'<tbody id="tableLimites">'+
							
						'</tbody>'+
					'</table>');
				for (var i = 0; i < da.length; i++) {
					$("#tableLimites").append('<tr  id="'+da[i]['contraparte']+'">'+
						'<td>'+da[i]['usuario']+'</td>'+
						'<td>'+da[i]['globalLimit']+'</td>'+
						'<td>'+da[i]['directOperationLimit']+'</td>'+
						'<td>'+da[i]['reportoOperationLimit']+'</td>'+
						'<td>'+da[i]['operationLimitMoneyMarket']+'</td>'+
						'<td>'+da[i]['exchangeMarketLimit']+'</td>'+
						'<td>'+da[i]['limitOperationExchangeMarket']+'</td>'+
						'<td> <a class="btn btn-danger btn-xs" style="color: white">Eliminar</a></td>'+
					'</tr>');
					
					
					
				}
				
				
				
			}
			
			
			
			myTable2 = $('#limites')
			.DataTable(
					{
						responsive : true,
						"ordering" : true,
						"info" : false,
						"displayLength" : 50,
						"lengthMenu" : [ 50, 100, 150, 200,
								250, 300 ],
						"order" : [ [ 7, "desc" ] ],

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
		"columns" : [0,1,2,3,4,5,6],
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

			
		},
		error : function(d) {
			console.log(d);
			
				}
	});
}




function cambio() {
	
	var tipo = $("#selectTipo").val()
	
	getLista(tipo)
	
	console.log($)
	
	
}


function cambioDivisas(){
	var tipoDivisas = $("#selectDivisas").val()
	
	
	$.ajax({
		async : true,
		url : '/divisas/listadv/'+tipoDivisas,
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
			
}


