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
		console.log(xhr.responseText);
		var res = JSON.parse(xhr.responseText);
		console.log(res);
		
		if (res.firstName) {
			document.getElementById("firstName").innerText = 
					 res.firstName;
		}if (res.lastName) {
			document.getElementById("lastName").innerText = 
				 res.lastName;
		}if (res.title) {
			if (res.title == "Manager") {
				var newlink1 = document.createElement('a');
				 newlink1.setAttribute('class', 'btn btn-primary');
				 newlink1.setAttribute('href', 'Act');
				 newlink1.innerText = 'View All Reimb';
				 
				
				 var newlink = document.createElement('a');
				 newlink.setAttribute('class', 'btn btn-primary');
				 newlink.setAttribute('href', 'add');
				 newlink.innerText = 'Add Employee';
				 
				 var newlink2 = document.createElement('a');
				 newlink2.setAttribute('class', 'btn btn-primary');
				 newlink2.setAttribute('href', 'vemp');
				 newlink2.innerText = 'View Managees';
				 
				 var newlink3 = document.createElement('a');
				 newlink3.setAttribute('class', 'btn btn-primary');
				 newlink3.setAttribute('href', 'appro');
				 newlink3.innerText = 'Approve/Deny';
			document.getElementById("managerOption").appendChild(newlink2).style.fontSize = "13pt"; 
			document.getElementById("managerOption").appendChild(newlink).style.fontSize = "13pt";			
			document.getElementById("managerOption").appendChild(newlink1).style.fontSize = "13pt";			
			document.getElementById("managerOption").appendChild(newlink3).style.fontSize = "13pt"; 
			}
		document.getElementById("managerS").innerText = 
			 res.title;
		}if (res.email) {
		document.getElementById("email").innerText = 
			 res.email;
		}
	} else {
		window.location = "http://localhost:8084/ERSystemV2/login";
	}
};

window.onload = function() {
	sendAjaxGet("session", populateUser);
}