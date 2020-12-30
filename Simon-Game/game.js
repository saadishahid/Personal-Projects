var gamePattern = [];
var userClickedPattern = [];

var buttonColors = ["red","blue","green","yellow"];
var level = 0;
var started = false;
var hiScore = 0;

//restart
function startOver() {
  level = 0;
  gamePattern=[];
  started=false;
}


//generate random sequence
function nextSequence() {
  userClickedPattern = [];
  level++;
  if (level > hiScore) {
    hiScore = level;
    $("#high-score").text("High Score: "+hiScore);
  }
  
  $("#level-title").text("Level "+level);
  var randomNumber = Math.floor(Math.random()*4);
  var randomChosenColor = buttonColors[randomNumber];
  gamePattern.push(randomChosenColor);
  $("#"+randomChosenColor).fadeIn(100).fadeOut(100).fadeIn(100);
  playSound(randomChosenColor);
}

//checks answer
function checkAnswer(currentLevel) {
  if (gamePattern[currentLevel]===userClickedPattern[currentLevel]) {
        if (userClickedPattern.length === gamePattern.length){
      setTimeout(function(){
        nextSequence();
      },1000);
    }
  } else {
    playSound("wrong");
    $("body").addClass("game-over");
    setTimeout(function() {
    $("body").removeClass("game-over");
},200);
  $("#level-title").text("Game Over, Press Any Key to Restart");
  startOver();
  }

}


// Events
$(document).keydown(function(){
  if (!started){
    $("#level-title").text("Level " + level);
  nextSequence();
  started = true;
  }
});


$(".btn").click(function(){
  var userChosenColor = $(this).attr('id');
  userClickedPattern.push(userChosenColor);
  playSound(userChosenColor);
  animatePress(userChosenColor);
  checkAnswer(userClickedPattern.length-1);
});

// Sound
function playSound(name){
  var audio = new Audio("sounds/"+name+".mp3");
  audio.play();
}

// Button Animation

function animatePress(currentColor){
  $("#"+currentColor).addClass("pressed");
  setTimeout(function(){
    $("#"+currentColor).removeClass("pressed");
  },100);
}
