

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
		var empList = JSON.parse(xhr.responseText);
		
		
		for (var i = 0; i < empList.length; i++) {
			  var empID = empList[i].empID;
			
			  var empTitle = empList[i].empTitle;
		
			  var empFirst = empList[i].empFirstName;
			
			  var empLast = empList[i].empLastName;
			  
			  var empEmail = empList[i].empEmail;

			  var row = document.createElement("TR");
			  row.setAttribute("scope","col");
			  document.getElementById("tableBody").appendChild(row);
			  
			  
			  var col =document.createElement("TD");
			  row.appendChild(col).innerHTML = empID;
			  row.appendChild(document.createElement("TD")).innerHTML = empTitle;
			  row.appendChild(document.createElement("TD")).innerHTML = empFirst;
			  row.appendChild(document.createElement("TD")).innerHTML = empLast;
			  row.appendChild(document.createElement("TD")).innerHTML = empEmail;

			}
		
		
	} else {
		console.log("Location")
//		window.location = "profile";
	}
};

	sendAjaxGet("view", populateUser);

