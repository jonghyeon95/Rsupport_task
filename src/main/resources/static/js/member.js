let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});
		$("#btn-update").on("click", () => {
			this.update();
		});
	},

	save: function() {
		let data = {
			member_id: $("#id").val(),
			member_pw: $("#password").val(),
			member_name: $("#name").val(),
			member_email: $("#email").val()
		};

		$.ajax({
			type: "POST",
			url: "/auth/joinProc",
			data: JSON.stringify(data),	
			contentType: "application/json; charset=utf-8",
			dataType: "json"	
		}).done(function(resp) {
			if(resp.status == 500)
			{
				alert(resp.data);
			}
			else
			{
				alert("회원가입 완료");
				location.href = "/";
			}
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},
	
	update: function() {
		let data = {
			member_id: $("#id").val(),
			member_pw: $("#password").val(),
			member_name: $("#name").val(),
			member_email: $("#email").val()
		};
		$.ajax({
			type: "PUT",
			url: "/member",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			if(resp.status == 500)
			{
				alert(resp.data);
			}
			else
			{
				alert("회원수정 완료");
				location.href = "/";
			}
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	}

}
index.init();


