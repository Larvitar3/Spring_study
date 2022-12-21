

let index = {
	
	init: function(){
		$("#btn--save").bind("click", () =>{
			this.save();
		});
	},
	
	save: function(){
		
		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		};
		
		$.ajax({
			type: "POST",
			url: "/api/board",
			data: JSON.stringify(data),
			contentType: "application/json; charset=UTF-8",
			dataType: "json"
		}).done(function(data, textStatus, xhr){
			console.log(data);
			if(data.status == "OK"){
				alert("글 저장이 완료되었습니다.");
				location.href = "/";
			}
		}).fail(function(error){
			alert("저장에 실패했습니다.");
			console.log(error);
		})
		
	}	
	
	
}

index.init();