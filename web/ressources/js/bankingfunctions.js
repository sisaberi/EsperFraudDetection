/**
 * Created by Serkan on 13.05.17.
 */
var date = "";
var locationCountry = "";
var xValu = 1;
var dataLength = 5; // number of dataPoints visible at any point

var dailyPaymentsArray = [0];

function manually(){
    document.getElementById('location').value = '';
    document.getElementById('amount').value = '';
    document.getElementById('timestamp').value = '';
}
function automatically(){
    var countries = ['Germany','Germany','Germany','Germany','Germany','Germany','Germany','Germany','Germany','Germany','Germany','Germany','Germany','Germany','Germany','Germany','Germany','Germany','Germany','France','Italy','Switzerland','Austria','Belgium','Somalia','Somalia','Somalia','Russia','Russia','Russia','Poland','Poland','Poland','Portugal', 'Bulgaria'];
    var randomCountry = Math.floor(Math.random() * countries.length);

    locationCountry = document.getElementById('location').value = countries[randomCountry];

    //var random = Math.floor(Math.random()*(1000-1+1)+1);
    var amountsArray = [50,25,17,450,500,287,666,701,750,1000,2001,2020,2310];
    var random2 = Math.floor(Math.random() * amountsArray.length);
    document.getElementById('amount').value = amountsArray[random2];
    var current = new Date();
    date = document.getElementById('timestamp').value = current.toLocaleString();
}
var xVal = 0;
//function startDetect() {

    window.onload = function () {


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
                labelFontColor: "black",
                lineColor: "black"


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
    chart.render();
        var amounts = 0;

        var ausgabeData = "";
        $("#addDataPoint").click(function () {
            setTimeout(function(){
            var length = chart.options.data[0].dataPoints.length;
            var newAmounts = document.getElementById('amount').value;
            var newDate = document.getElementById('timestamp').value;
            var newCountry = document.getElementById('location').value;

            dailyPaymentsArray.push(newAmounts);

            xVal++;
            var a = parseInt(newAmounts);

            if (getSumOfArray() > 2000){
                chart.options.data[0].dataPoints.push({
                    y: a,
                    x: xValu,
                    color: "red"
                });
                ausgabeData = ausgabeData + "<font color='red'>&nbsp;&nbsp;&nbsp;------>DETECTED FRAUD: daily payment limit of 2000,- EUR exceeded: " + getSumOfArray() + " payment: " + xValu + " amount: " + a + ",- EUR date: "+ newDate +" location: "+ newCountry +"<------</font><br>";
            } else if (locationCountry == "Bulgaria" || locationCountry == "Russia" || locationCountry == "Somalia") {
                chart.options.data[0].dataPoints.push({
                    y: a,
                    x: xValu,
                    color: "red"
                });
    ausgabeData = ausgabeData + "<font color='red'>&nbsp;&nbsp;&nbsp;------>DETECTED FRAUD: unusual location: payment: " + xValu + " amount: " + a + ",- EUR date: " + newDate + " location: " + newCountry + "<------</font><br>";
} else {
    chart.options.data[0].dataPoints.push({
        y: a,
        x: xValu,
    });
    ausgabeData = ausgabeData + "<font color='black'>&nbsp;&nbsp;&nbsp;payment: " + xValu + " amount: " + a + ",- EUR date: " + newDate + " location: " + newCountry + "</font><br>";
}
            document.getElementById('dat').innerHTML = ausgabeData;
           /*
           if (dps.length > dataLength) {
                dps.shift();
            }*/
            chart.render();

            xValu++;},Math.floor(Math.random()*(3000-2000+2000)+2000));
        });


    }
    function getSumOfArray() {
        var sum1 =0;
        var sum = parseInt(sum1);
        for(i=0;i<dailyPaymentsArray.length;i++){
            sum +=parseInt(dailyPaymentsArray[i]);
        }
        return sum;
    }

    function startDetect(){
    /*var ausgabeData = "";
    var yVal = 0;
    var xFraud = 0;
    var xClear = 0;
    var xValu = 1;
    var updateInterval = 1000;
    var dataLength = 10; // number of dataPoints visible at any point
    var updateChart = function () {
        //count = count || 1;
        // count is number of times loop runs to generate random dataPoints.

        //for (var j = 0; j < count; j++) {
            yVal = document.getElementById('amount').value;


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

            xValu = xVal + 1;
        //}
        ;

        if (dps.length > dataLength) {
            dps.shift();
        }

        chart.render();

    };

    // generates first set of dataPoints
    //updateChart(dataLength);

    // update chart after specified time.
    //setInterval(function () {
        updateChart();
    //}, updateInterval);*/





}