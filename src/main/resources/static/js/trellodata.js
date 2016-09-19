$(function () {
    var boards;
    var boardName;

    var success = function(successMsg) {
        boards = new Board(successMsg);

        $.each(successMsg,function(key,value){
            if(value.name === 'Life' || value.name === 'Work'){
                var boardID = value.id;
                var parameters = {
                    cards:'open',
                    card_fields:'idBoard,name',
                    fields:'idBoard,name'
                };
                boards[boardID] = value.name;
                Trello.get('/boards/'+boardID+'/lists',parameters,boards.retrieveListsByBoard,error);
            }
        });
    };


    var authenticationSuccess = function () {
        Trello.get('/member/me/boards',success,error);
    };

    Trello.authorize({
        type: 'popup',
        name: 'Trello Dashboard',
        scope: {
            read: true,
            write: false
        },
        expiration: 'never',
        success: authenticationSuccess,
        error: error
    });
});
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
        var titleContent = document.createElement("h1");
        titleContent.innerHTML = obj[successMsg[0].idBoard];
        title.appendChild(titleContent);
        document.getElementById("lists").appendChild(title);

        var index = 0;
        $.each(successMsg,function(key,v){
            var listTitle = document.createElement('h4');
            listTitle.innerHTML = v.name;
            title.appendChild(listTitle);
            var listGroup = document.createElement('ul')
            listGroup.setAttribute("class","list-group");
            title.appendChild(listGroup)
            $.each(v.cards,function(key,v){
                var card = document.createElement('li');
                card.setAttribute("class","list-group-item");
                card.innerHTML = v.name;
                title.appendChild(card);
                //Try to get actions of a card
                Trello.get('/cards/'+ v.id+'/actions',{},retrieveCard,error);
            });
            if(v.name != 'MUST READ'){
                var name = v.name;
                var value = v.cards.length;
                var data = new Data(value,name);
                var position = index++;
                listData[position] = data;
                cardData[position] = name;
            }
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

function retrieveCard(successMsg){
    if(successMsg.length>0){
        console.log('R:'+successMsg.length);
        $.each(successMsg,function(key,v){
            console.log('key:'+key+' value:'+v);
        });
    }

}

function Data(value,name){
    this.value = value;
    this.name = name;
}

function error(errorMsg){
    console.log(errorMsg);
}


