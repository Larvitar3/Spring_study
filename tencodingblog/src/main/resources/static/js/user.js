
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
			email: $("#email").val
		}

		$.ajax({}).done().fail()
	}


}

index.init();
