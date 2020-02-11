function logaritmo() {
	$("#spinner").fadeIn();
	$.ajax({
		async : true,
		url : '/logaritmo/getParametros/' + $("#producto").val(),
		type : 'get',// POST,PUT,DELETE,GET,PATCH
		dataType : 'json',
		processData : false,
		contentType : "application/json",
		success : function(response) { // true
			console.log(response);
			for (var i = 0; i < response.length; i++) {
				$("#conteLog").append(
						'<li class="list-group-item">'
								+ response[i]['logaritmo'] + '</li>');
			}
			$("#spinner").fadeOut();
		},
		error : function(d) {
			console.log(d);
		}
	});
}