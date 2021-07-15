let app = {};
let data = [];
for (let i = 0; i < 49; ++i) {
    data.push(0);
}

//for AJAX接受数据
let note = [];
let num = [];
let databaseUpdateTime;

let upDateTime;
let barColors = ["#00008b", "#f00", "#ffde00", "#002a8f", "#003580", "#ed2939",
    "#003897", "#f93", "#bc002d", "#024fa2", "#00247d",
    "#ef2b2d", "#dc143c", "#d52b1e", "#e30a17", "#00247d", "#b22234"];
let thisTimeColor = [];
for (let j = 0; j < 49; ++j) {
    thisTimeColor.push(barColors[Math.round(Math.random() * 16.0)]);
}
//AJAX接收数据主体
$.ajax({
    type: "GET",
    url: "../weibo/showAll",
    dataType: "json",
    async: false,
    success: function (result) {

        for (let i = 0; i < result.length; i++) {
            note.push(result[i].note);
            num.push(result[i].num);

        }

    },
    error: function (errorMsg) {
        alert("获取后台数据失败！");
    }
});



function run() {
    let data = option.series[0].data;
    let yData = option.yAxis.data;

    for (let i = 0; i < 49; i++) {
        data[i] = num[i];
        yData[i] = note[i];
    }
    myChart.setOption(option);
}


function getCurrentTime() {
    let date = new Date();
    let year = date.getFullYear();
    let month = date.getMonth() + 1;
    month = month < 10 ? "0" + month : month;
    let day = date.getDate();
    day = day < 10 ? "0" + day : day;
    let week = date.getDay();
    switch (week) {
        case 1: {
            week = "星期一";
            break;
        }
        case 2: {
            week = "星期二";
            break;
        }
        case 3: {
            week = "星期三";
            break;
        }
        case 4: {
            week = "星期四";
            break;
        }
        case 5: {
            week = "星期五";
            break;
        }
        case 6: {
            week = "星期六";
            break;
        }
        case 0: {
            week = "星期日";
            break;
        }
    }
    let hour = date.getHours();
    hour = hour < 10 ? "0" + hour : hour;
    let minute = date.getMinutes();
    minute = minute < 10 ? "0" + minute : minute;
    let second = date.getSeconds();
    second = second < 10 ? "0" + second : second;
    let result = year + "." + month + "." + day + " " + week + " " + hour + ":" + minute + ":" + second;
    let noWeekResult = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
    return noWeekResult;
}

function show() {
    let currentTime = getCurrentTime();
    document.getElementById("time").innerHTML = currentTime;
}

function aJax() {
    $.ajax({
        type: "GET",
        url: "../weibo/showAll",
        dataType: "json",
        async: false,
        success: function (result) {
            note = [];
            num = [];
            databaseUpdateTime = result[1].onboardTime;
            for (let i = 0; i < result.length; i++) {
                note.push(result[i].note);
                num.push(result[i].num);

            }
            //更新更新的时间
            upDateTime = getCurrentTime();
            document.getElementById("updateTime").innerHTML = upDateTime;
            document.getElementById("dataBaseUpdateTime").innerHTML = databaseUpdateTime;

        },
        error: function (errorMsg) {
            alert("获取后台数据失败！");
        }
    });
}
