$(document).ready(function(){
  

  let today = new Date().toISOString().slice(0, 10)
  document.getElementById("practiceStartDate").value=today

  $(".editable").click(function(){
    if($(this).children("input").length > 0)
          return false;

    var tdObj = $(this);
    var preText = tdObj.html();
    var inputObj = $("<input type='text' />");
    tdObj.html("");

    inputObj.width(tdObj.width())
            .height(tdObj.height())
            .css({border:"0px",fontSize:"10px"})
            .val(preText)
            .appendTo(tdObj)
            .trigger("focus")
            .trigger("select");

    inputObj.keyup(function(event){
      if(13 == event.which) { // press ENTER-key
        var text = $(this).val();
        tdObj.html(text);
        updateTotal(this)
        // save to server
        savePracticeLog(this)

      }
      else if(27 == event.which) {  // press ESC-key
        tdObj.html(preText);
      }
    });

    inputObj.click(function(){
      return false;
    });
  });

  
});

function submitLog() {

}

function getLog() {
  let date = document.getElementById("practiceStartDate").value;
  let logUrl = "http://localhost:8085/practice-log/current-year/weeks/date/" + date;
  logUrl += "?userId=samst";
  console.log("Calling url" + logUrl);
  $.ajax({
    url: logUrl,
    crossDomain: true,
    headers: {
       origin: "http://localhost:8085"
    },
    error: function(e) {
    console.log("ERROR: ", e);
    display(e);
    },
    success: function(log) {
    	console.log(log)
        var data = JSON.parse(log);
        console.log(log)
    }
  })
}

function updateTotal(field) {

}

