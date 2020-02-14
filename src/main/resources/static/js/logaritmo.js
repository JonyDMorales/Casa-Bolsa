function logaritmo() {
	$("#spinner").fadeIn();
	var tasa= $("#tasaMercado").val();
	if (tasa == ""){
		tasa = 0;
	}
	$.ajax({
				async : true,
				url : '/logaritmo/getParametros/' + $("#producto").val(),
				type : 'get',// POST,PUT,DELETE,GET,PATCH
				dataType : 'json',
				processData : false,
				contentType : "application/json",
				success : function(response) { // true
					
					$("#conteLog").empty();
					if (response.length > 0) {
						for (var i = 0; i < response.length; i++) {
							var suma = parseFloat((tasa)) + parseFloat((response[i]['logaritmo']));
							$("#conteLog").append('<div>'+
									'<div class="col-sm-6" style="display: inline-table;">'+ response[i]['logaritmo']+ '</div>'+
									'<div class="col-sm-6" style="display: inline-table;">'+suma+'</div></div>');
							
							
							
						}
					} else {
						$("#conteLog").append(
								'<center><h2>Sin Resultados</h2></center>');
					}
					$("#spinner").fadeOut();
				},
				error : function(d) {
					console.log(d);
				}
			});
}