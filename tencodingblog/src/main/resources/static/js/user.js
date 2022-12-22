
let index = {

	init: function() {

		$("#btn--join").bind("click", () => {
			this.join();
		});

		$("#btn--update").bind("click", () => {
			this.update();
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
			url: "/auth/joinProc",
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
	
	
	update: function(){
		
		let data = {
			id: $("#id").val(),
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val(),
		}
		
		$.ajax({
			type: "PUT",
			url: "/api/user",
			data: JSON.stringify(data),
			contentType:"application/json; charset=utf-8",
			dataType: "json",
		}).done(function(data, textStatus, xhr){
			if(data.status == "OK"){
				alert("회원정보 수정을 완료 하였습니다.");
				location.href = "/";
			}
		}).fail(function(error){
			alert("회원정보 수정을 실패 하였습니다.");
		});
	}


}

index.init();



















