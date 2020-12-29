
//  Changing Dice Image for Player 1
var randomNumber1 = getRandomIntInclusive(1,6);
var randomDiceImage = "dice" + randomNumber1+".png" ;
var randomImageSource1 = "images/"+randomDiceImage;


var image1 = document.querySelectorAll("img")[0];
image1.setAttribute("src", randomImageSource1);

// Changing Dice Image for Player 2

var randomNumber2 = getRandomIntInclusive(1,6);
var randomImageSource2 = "images/dice"+randomNumber2+".png";

var image2 = document.querySelectorAll("img")[1].setAttribute("src",randomImageSource2);

// Text to display who won

if (randomNumber1>randomNumber2){
  document.querySelector("h1").innerHTML = "😊 Player 1 won!!";
} else if (randomNumber2>randomNumber1) {
  document.querySelector("h1").innerHTML = "😊 Player 2 won!!";
} else {
  document.querySelector("h1").innerHTML = "😜 Draw!!";
}




// Helper function to generate random numbers
function getRandomIntInclusive(min, max) {
  min = Math.ceil(min);
  max = Math.floor(max);
  return Math.floor(Math.random() * (max - min + 1) + min); //The maximum is inclusive and the minimum is inclusive
}
