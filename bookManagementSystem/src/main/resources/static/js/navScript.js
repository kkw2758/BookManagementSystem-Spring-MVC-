/* Toggle between adding and removing the "responsive" class to topnav when the user clicks on the icon */
const toggleIcon = document.querySelector(".icon");
console.log(toggleIcon);
toggleIcon.addEventListener("click", function () {
  myFunction();
  console.log("A");
});

function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}
