

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
			
			}
		
		
	} else {
			window.location = "profile";
	}
};

	sendAjaxGet("decide", populateUser);

