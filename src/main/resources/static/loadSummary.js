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
  let user = getUser()
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
        generateTable(data)
        console.log(log)
    }
  })
}

function generateTable(data) {
  let logStartDay = getLogStartDay();
  let table = document.getElementById("weekly-log-table");
  let dailyLogs = data.dailyLogs;
  var i;
  // headers
  var headerRow = document.createElement("TR");
  table.appendChild(headerRow);
  var practiceDays = getPracticeDays(logStartDay);
  for (i=0; i < practiceDays.length; i++) {
    var headerCell = document.createElement("TH");
    if (i==0) {
      headerCell.innerHTML="";
    } else {
      headerCell.innerHTML=practiceDays[i];
    }
    headerRow.appendChild(headerCell);
  }
  var headerCell = document.createElement("TH");
  headerCell.innerHTML = "Total";
  headerCell.setAttribute("class", "total");
  headerRow.appendChild(headerCell);
  table.appendChild(headerRow);

  for (i = 0; i < dailyLogs.length; i++) {
     var j;
     var pieceLogs = dailyLogs.pieceLogs;
     for (j=0; j < pieceLogs.length; j++) {
      var row = document.createElement("TR");
      var th = document.createElement("TH");
      var piece = getPiece(pieceLogs[i].pieceId);
      th.innerHTML = piece.name;
       var cell = document.createElement("TD");
       var id = 
       headerCell.setAttribute("id", id);
       headerCell.setAttribute("class", "editable");
       row.appendChild(cell);
       table.append(row);
     }
     
  }
  
}

function getPiece(pieceId) {
  let userUrl = "http://localhost:8085/users/samst";
  console.log("Calling url" + userUrl);
  let logStartDay = "Saturday";
  $.ajax({
    url: userUrl,
    crossDomain: true,
    headers: {
       origin: "http://localhost:8085"
    },
    error: function(e) {
    console.log("ERROR: ", e);
    display(e);
    },
    success: function(user) {
    	console.log(user.userId);
      logStartDay = user.logStartDay;
    }
  })

}

function getPracticeDays(logStartDay) {
  const days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
  var i;
  for (i=0; i < days.length; i++) {
    if (days[i] == logStartDay) {
      break;
    }
  }

  var modDays = [];
  var j;
  var k;
  for (k=0,j = i; k < days.length; k++, j++) {
    if (j >= days.length) {
      j=0;
    }
    modDays[k] = days[j];
  }

  return modDays;
}

function updateTotal(field) {

}

function getLogStartDay() {
  let userUrl = "http://localhost:8085/users/samst";
  console.log("Calling url" + userUrl);
  let logStartDay = "Saturday";
  $.ajax({
    url: userUrl,
    crossDomain: true,
    headers: {
       origin: "http://localhost:8085"
    },
    error: function(e) {
    console.log("ERROR: ", e);
    display(e);
    },
    success: function(user) {
    	console.log(user.userId);
      logStartDay = user.logStartDay;
    }
  })

  return logStartDay;
}

