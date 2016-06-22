
function Board(boardStr){
    this.str = boardStr;
    this.size = boardStr.length;
    //为什么这里必须要定义一个私有变量obj才能在retrieveListsByBoard中才能访问到，而如果是直接调用retrieveListsByBoard
    //而不是作为一个方法的参数直接用this有可以取到值?
    var obj = this;
    this.retrieveListsByBoard = function (successMsg){
        var listData = [];
        var cardData = [];
        var title = document.createElement("div");
        title.setAttribute("class","col-sm-6");
        title.innerHTML = obj[successMsg[0].idBoard];
        document.getElementById("lists").appendChild(title);
        $.each(successMsg,function(key,v){
            if(v.name === 'ProcessOn'){
                $.each(v.cards,function(key,v){
                    var card = document.createElement('li');
                    card.innerHTML = v.name;
                   title.appendChild(card);
                });
            }
            var name = v.name;
            var value = v.cards.length;
            var data = new Data(value,name);
            listData[key] = data;
            cardData[key] = name;
        });

        var displayDiv = document.createElement('div');
        displayDiv.setAttribute("class","col-md-6");
        displayDiv.style.cssText = "width:580px;height:400px";
        var myChart = echarts.init(displayDiv);
        myChart.setOption({
            title: {
                text:obj[successMsg[0].idBoard],
                x: 'center',
                textStyle: {
                    color: '#ccc'
                }
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: cardData
            },
            series : [
                {
                    name: 'Cards Num',
                    type: 'pie',
                    radius: '70%',
                    data:listData,
                    itemStyle: {
                        normal: {
                            shadowBlur: 200,
                            shadowOffsetX: 10,
                            shadowOffsetY: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        });
        document.getElementById("graphic").appendChild(displayDiv);

    }
}

function Data(value,name){
    this.value = value;
    this.name = name;
}


