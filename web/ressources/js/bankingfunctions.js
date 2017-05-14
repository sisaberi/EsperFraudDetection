/**
 * Created by Serkan on 13.05.17.
 */
function manually(){
    document.getElementById('location').value = '';
    document.getElementById('amount').value = '';
    document.getElementById('timestamp').value = '';
}
function automatically(){
    var countries = ['Germany','Germany','Germany','Germany','Germany','Germany','Germany','Germany','Germany','Germany','Germany','Germany','Germany','Germany','Germany','Germany','Germany','France','Italy','Switzerland','Austria','Belgium','Somalia','Russia','Poland','Portugal', 'Bulgaria'];
    var randomCountry = Math.floor(Math.random() * countries.length);

    document.getElementById('location').value = countries[randomCountry];

    var random = Math.floor(Math.random()*(1000-1+1)+1);
    document.getElementById('amount').value = random;
    var current = new Date();
    document.getElementById('timestamp').value = current.toLocaleString();
}
function startDetect() {

    //window.onload = function ()

    var ausgabeData;
    ausgabeData = "";

    var dps = []; // dataPoints

    var chart = new CanvasJS.Chart("chartContainer", {
        backgroundColor: "black",
        axisY: {
            labelFontColor: "#E0FFFF",
            gridColor: "#E0FFFF",
            gridThickness: 0,
            lineColor: "#E0FFFF"
        },
        axisX: {
            labelFontColor: "#E0FFFF",
            lineColor: "#E0FFFF"


        },
        title: {
            text: " ",
            fontColor: "#E0FFFF"
        },
        data: [{
            type: "splineArea",
            dataPoints: dps
        }]
    });

    var xVal = 0;
    var yVal = 0;
    var xFraud = 0;
    var xClear = 0;
    var xValu = 1;
    var updateInterval = 1000;
    var dataLength = 10; // number of dataPoints visible at any point
    var updateChart = function (count) {
        count = count || 1;
        // count is number of times loop runs to generate random dataPoints.

        for (var j = 0; j < count; j++) {
            yVal = Math.floor(Math.random() * (1000 - 1 + 1) + 1);


            if (yVal > 700) {
                dps.push({
                    x: xVal,
                    y: yVal,
                    color: "red"

                });
                xFraud++;
                ausgabeData = ausgabeData + "<font color='red'>&nbsp;&nbsp;&nbsp;------>FRAUD DETECTED: Überweisung: " + xValu + " Betrag: " + yVal + ",- EUR<------</font><br>";
            } else {
                dps.push({
                    x: xVal,
                    y: yVal,

                });
                xClear++;
                ausgabeData = ausgabeData + "<font color='black'>&nbsp;&nbsp;&nbsp;Überweisung: " + xValu + " Betrag: " + yVal + ",- EUR</font><br>";

            }
            document.getElementById('dat').innerHTML = ausgabeData;
            xVal++;
            xValu = xVal + 1;
        }
        ;

        if (dps.length > dataLength) {
            dps.shift();
        }

        chart.render();

    };

    // generates first set of dataPoints
    //updateChart(dataLength);

    // update chart after specified time.
    setInterval(function () {
        updateChart()
    }, updateInterval);
}