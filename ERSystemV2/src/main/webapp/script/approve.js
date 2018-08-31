

function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	xhr.open("GET", url, true);
	xhr.send();
};


function sendAjaxPost(url, func) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	xhr.open("POST", url, true);
	xhr.send();
};

function populateUser(xhr) {
	if (xhr.responseText) {
		var reimbList = JSON.parse(xhr.responseText);
		
		console.log(reimbList);
		
		
		for (var i = 0; i < reimbList.length; i++) {
			  var reimbID = reimbList[i].reimbID;
			  var empID = reimbList[i].empID;
			  var dateProcessed = reimbList[i].reimbProcessedString;

			  var reimbDes = reimbList[i].reimbReason;
			  
			  var reimbEv = reimbList[i].reimbEvidence;
			  var reimbStat = reimbList[i].reimbStatus;
			  var dateClosed = reimbList[i].reimbClosedString;
			  var manID = reimbList[i].resolvedBy;

			  var row = document.createElement("TR");
			  var button =  document.createElement("a");
			  button.setAttribute ('class', 'btn btn-primary');
			  
			  button.setAttribute('href', '/ERSystemV2/img?ticketId=' + reimbID);
			  button.setAttribute ('target',"_blank");
			  button.innerText = 'View Receipt';
			  row.setAttribute("scope","col");
			  document.getElementById("tableBody").appendChild(row);
			  
			  
			  var col =document.createElement("TD");
			  row.appendChild(col).innerHTML = empID;
			  row.appendChild(document.createElement("TD")).innerHTML = reimbID;
			  row.appendChild(document.createElement("TD")).innerHTML = reimbDes;
			  row.appendChild(document.createElement("TD")).appendChild(button).style.fontSize = "14pt";
			  row.appendChild(document.createElement("TD")).innerHTML = dateProcessed;
			  row.appendChild(document.createElement("TD")).innerHTML = reimbStat;
			  row.appendChild(document.createElement("TD")).innerHTML = dateClosed;
			  row.setAttribute("info", JSON.stringify(reimbList[i].reimbID));
			  row.onclick = toggle;
			}
		
		
	} else {
			window.location = "profile";
	}
};
	function toggle (){
		if (this.getAttribute("selected") === "true"){
			this.setAttribute("selected", "null");  
			this.bgColor = "white";
		}else{
			this.setAttribute("selected", "true");
			this.bgColor = "green";
		}		
	}
	
	function getSelectedApprove(tableID){
		var table = document.getElementById (tableID);
		console.log(table)
		var list = [];
		var r = table.rows;
		for( var i = 0; i < r.length; i++ ){
			if (r[i].getAttribute("selected")=== "true") {
				list.push(r[i].getAttribute("info"));
				sendAjaxPost("decide?status=Approved&reimbID="+ r[i].getAttribute("info") , function(){
					table.innerHTML = "";
					sendAjaxGet("decide", populateUser);
				});
				
			}
		}
		console.log(list);
	}
	
	function getSelectedDeny(tableID){
		var table = document.getElementById (tableID);
		console.log(table)
		var list = [];
		var r = table.rows;
		for( var i = 0; i < r.length; i++ ){
			if (r[i].getAttribute("selected")=== "true") {
				list.push(r[i].getAttribute("info"));
				sendAjaxPost("decide?status=Denied&reimbID="+ r[i].getAttribute("info") , function(){
					table.innerHTML = "";
					sendAjaxGet("decide", populateUser);
				});
				
			}
		}
		console.log(list);
	}

	sendAjaxGet("decide", populateUser);

