
let index = {

	init: function() {

		$("#btn--join").bind("click", () => {
			this.join();
		});

		$("#btn--login").bind("click", () => {
			this.login();
		});

	},

	join: function() {

		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val(),
		}

		$.ajax({
			type: "POST",
			url: "/api/user",
			data: JSON.stringify(data),
			contentType: "application/json; charset=UTF-8",
			dataType: "json",
		}).done(function(data, textStatus, xhr){
			
			if(data.status == "OK"){
				alert("회원가입 완료");
				location.href = "/";
			}
				
		}).fail(function(error){
			alert("회원가입 실패" + error.responseJSON.msg);
			console.log(error);
		});
	},


}

index.init();
