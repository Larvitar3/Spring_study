

let index = {
	
	init: function(){
		
		$("#btn--save").bind("click", () =>{
			this.save();
		});
		
		$("#btn--delete").bind("click", () => {
			this.deleteById();
		});
		
		$("#btn--update").bind("click", () =>{
			this.update();
		});
		
		$("#btn-reply-save").bind("click", () => {
			this.replySave();
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
		
	},
	
	deleteById: function(){
		
		let id = $("#board-id").text();
		
		$.ajax({
			type: "DELETE",
			url: "/api/board/" + id
		}).done(function(data, textStatus, xhr){
			console.log(data);
			if(data.status == "OK"){
				alert("글 삭제가 완료되었습니다.");
				location.href = "/";
			}
		}).fail(function(error){
			alert("글 삭제에 실패했습니다.");
			console.log(error);
		});
	},
	

	update: function(){
		
		let boardId = $("#board-id").attr("data-id");
		
		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		};
		
		$.ajax({
			type: "PUT",
			url: "/api/board/" + boardId,
			data: JSON.stringify(data),
			contentType: "application/json; charset=UTF-8",
			dataType: "json"
		}).done(function(data, textStatus, xhr){
			if(data.status){
				alert("글 수정이 완료되었습니다.");
				location.href = "/";
			}
		}).fail(function(error){
			alert("글 수정에 실패하였습니다.");
			console.log(error);
		})
		
	},
	
	replySave : function() {
		
		let replyData = {
			boardId: $("#board-id").text(),  // fk (board pk ) 
			content: $("#content").val() 
		};
		// ajax 통신 요청 
		$.ajax({
			type:"POST", 
			url: `/api/board/${replyData.boardId}/reply`,  
			data: JSON.stringify(replyData),
			contentType : "application/json; charset=utf-8", 
			dataType: "json"
		}).done(function(data, textSatus, xhr) {
			if(data.status == "OK") {
				alert("댓글 작성이 완료 되었습니다");
				location.href = `/board/${replyData.boardId}`;
			}
		}).fail((error) => {
			console.log(error);
			alert("댓글 작성에 실패 하였습니다");
		} );
	}
	
}

index.init();











