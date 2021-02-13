let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});
		$("#btn-delete").on("click", () => {
			this.delete();
		});
		$("#btn-update").on("click", () => {
			this.update();
		});
		$("#btn-reply-save").on("click", () => {
			this.replySave();
		});
	},

	save: function() {
		let data = {
			notice_title: $("#title").val(),
			notice_content: $("#content").val(),
		};
		
		console.log(data);
		
		$.ajax({
			type:"POST",
			url:"/api/notice",
			data: JSON.stringify(data),
			contentType:"application/json; charset=utf-8", 
			dataType:"json"
		}).done(function(resp) {
			if(resp.status == 500)
			{
				alert(resp.data);
			}
			else
			{
				alert("글 등록 완료");
				location.href = "/";
			}
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},
	
	delete: function() {
		let id = $("#id").text();

		$.ajax({
			type:"DELETE",
			url:"/api/notice/"+id,
			dataType:"json"
		}).done(function(resp) {
			if(resp.status == 500)
			{
				alert(resp.data);
			}
			else
			{
				alert("글 삭제 완료");
				location.href = "/";
			}
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},
	
	update: function() {
		
		let id = $("#id").val();
		
		let data = {
			notice_title: $("#title").val(),
			notice_content: $("#content").val(),
		};
		console.log(id)
		$.ajax({
			type:"PUT",
			url:"/api/notice/"+id,
			data: JSON.stringify(data),
			contentType:"application/json; charset=utf-8", 
			dataType:"json"
		}).done(function(resp) {
			if(resp.status == 500)
			{
				alert(resp.data);
			}
			else
			{
				alert("글 수정 완료");
				location.href = "/";
			}
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},
	
}
index.init();



var fnum = 1;
function changeFile(e) {
   var input = document.createElement("input");
   input.setAttribute("name", "setFile");
   input.setAttribute("type", "file");
   input.setAttribute("class", "file");
   input.setAttribute("onchange", "changeFile(this);");

   var delBtn = document.createElement("input");
   delBtn.setAttribute("name", "fileDel");
   delBtn.setAttribute("type", "button");
   delBtn.setAttribute("class", "delFile");
   delBtn.setAttribute("value", "삭제");
   delBtn.setAttribute("style", "margin-left: 7px;");
   delBtn.setAttribute("onclick", "delFile('setFile" + fnum + "');");

   var setFile = document.createElement("div");
   setFile.setAttribute("id", "setFile" + fnum++);
   setFile.setAttribute("style", "display: block;");
   setFile.append(input);
   setFile.append(delBtn);

   document.getElementById("fileArea").append(setFile);

   e.setAttribute("onchange", null);

};

function delFile(id) {
   if(id != 'setFile0') {
      var setFile = document.getElementById(id);
      $(setFile).remove();
   
      var fileArea = document.getElementById("fileArea");
      if (fileArea.lastChild.firstChild == null) {
         $('.file').attr("onchange", "changeFile(this);");
      } else {
         fileArea.lastChild.firstChild.setAttribute("onchange", "changeFile(this);");
      }
   } else {
      $('.file:eq(0)').val("");
   }
};


function nameSet() {
   var i = 0;
   $(".file").each(function() {
      if($(this).val() == "") {
         $(this).remove();
      } else {
         $(this).attr("name", "setFile");
      }
   });
}




