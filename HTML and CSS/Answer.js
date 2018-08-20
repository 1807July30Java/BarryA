//First QUESTION: //
console.log("------------------------Question 1 ------------------------------");
window.onload = function(){
function getUSA(){
  var x = document.getElementsByTagName("span");
  console.log(x[1].innerText);
  return x[1].innerText;
}
getUSA();
console.log("------------------------Question 2 ------------------------------");
//Question2
function getPeopleInSales() {
  var a = document.getElementsByTagName("tr");
  for (var i = 0; i < a.length; i++) {
    if (a[i].childNodes[3].innerText == "Sales") {
      console.log(a[i].childNodes[1].innerText);
    }
  }
}
getPeopleInSales();
console.log("------------------------Question 3 ------------------------------");
//queston3
function getAnchorChildren(){
  var y = document.getElementsByTagName("a");
  for (var i = 0; i < y.length; i++) {
    if (y[i].childNodes[1]) {
      console.log( y[i].childNodes[1].innerText);
    }
  }
}
getAnchorChildren();
console.log("------------------------Question 4 ------------------------------");
//Question4
function getSkills(){
  var x = document.getElementsByName("skills");
  for (var i = 0; i < x.length; i++) {
    for (var j = 0; j < x[i].childNodes.length; j++) {
      if (x[i].childNodes[j].value) {
    console.log(x[i].childNodes[j].value +" ----> "+ x[i].childNodes[j].innerText);
      }
    }
  }
}
getSkills();
console.log("------------------------Question 5 ------------------------------");
//Question 5;
function getCustomAttribute(){
  var all = document.getElementsByTagName("*");
  for (var i = 0; i < all.length; i++) {
    if (all[i].getAttribute("data-customAttr")) {
      console.log(all[i].tagName +" ---> "+all[i].getAttribute("data-customAttr"));
    }
  }
}
getCustomAttribute();
console.log("------------------------Question 6 ------------------------------");

console.log("------------------------Question 7 ------------------------------");

var a = document.getElementsByName("skills");
console.log(a);
var b = a[0];
for (var i = 0; i < b.length; i++) {
  console.log(b[i]);

  b.onchange = function(){
      console.log(b.innerText);
}
    }


console.log("------------------------Question 8 ------------------------------");
}
