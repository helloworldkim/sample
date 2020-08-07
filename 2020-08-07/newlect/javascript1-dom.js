//Ex10-클릭한 컬럼을 기준으로 레코드 정렬하기 #1
window.addEventListener("load", function(){

    var notices = [
        {"id":1, "title":"유투브에 끌려다니지 않으려고 했는데....ㅜㅜ..", "regDate":"2019-02-05", "writerId":"newlec", "hit":2},
        {"id":2, "title":"자바스크립트란..", "regDate":"2019-02-02", "writerId":"newlec", "hit":0},
        {"id":3, "title":"기본기가 튼튼해야....", "regDate":"2019-02-01", "writerId":"newlec", "hit":1},
        {"id":4, "title":"근데 조회수가 ㅜㅜ..", "regDate":"2019-01-25", "writerId":"newlec", "hit":0}
    ];

    var section = document.querySelector("#section10");
    
    var noticeList =section.querySelector(".notice-list");
    var titldTd = section.querySelector(".title"); //thead제목부분
    var regDateTd = section.querySelector(".reg-date");
    var tbodyNode = noticeList.querySelector("tbody");

    var bindData = function(){
        var template = section.querySelector("template");

        for(var i=0; i<notices.length; i++){
            var cloneNode = document.importNode(template.content, true);
            var tds = cloneNode.querySelectorAll("td");
            tds[0].textContent = notices[i].id;            

            var aNode = tds[1].children[0];
            aNode.href=notices[i].id;
            aNode.textContent = notices[i].title;

            tds[2].textContent = notices[i].regDate;
            tds[3].textContent = notices[i].writerId;
            tds[4].textContent = notices[i].hit;

            //tbodyNode.appendChild(cloneNode);
            tbodyNode.append(cloneNode);
        }
    };

    bindData();

    var titleSorted = false;

    titldTd.onclick = function(){
        tbodyNode.innerHTML = "";
        if(!titleSorted){
            notices.sort(function(a,b){
                if(a.title<b.title){
                    return -1;
                }else if(a.title>b.title){
                    return 1;
                }else{
                    return 0;
                }
            });
        }else{
            notices.reverse();
        }
        

        bindData();

        titleSorted = true;
    };

    var dateSorted = false;

    regDateTd.onclick = function(){
        tbodyNode.innerHTML = "";
        if(!dateSorted){
            notices.sort(function(a,b){
                if(a.title>b.title){
                    return 1;
                }else if(a.title<b.title){
                    return -1;
                }else{
                    return 0;
                }
            });
        }else{
            notices.reverse();
        }
        

        bindData();

        dateSorted = true;
    };


});



//Ex9-다중 노드선택 방법과 일괄삭제, 노드의 자리바꾸기
window.addEventListener("load", function(){

    var section = document.querySelector("#section9");
    
    var noticeList =section.querySelector(".notice-list"); 
    var tbody = noticeList.querySelector("tbody");
    var allCheckbox = section.querySelector(".overall-checkbox");
    var delButton = section.querySelector(".del-button");
    var swapButton = section.querySelector(".swap-button");

    allCheckbox.onchange = function(){
        console.log(allCheckbox.checked); //true,false 값을 가짐
        var checkbox = tbody.querySelectorAll("input[type='checkbox']");
        for(var i=0; i<checkbox.length; i++){
            checkbox[i].checked = allCheckbox.checked;
        }
    };

    delButton.onclick = function(){
        var checkedbox = tbody.querySelectorAll("input[type='checkbox']:checked");
        for(var i=0; i <checkedbox.length; i++){
            checkedbox[i].parentElement.parentElement.remove();
        }
    };

    swapButton.onclick = function(){
        var checkedbox = tbody.querySelectorAll("input[type='checkbox']:checked");
        if(checkedbox.length==2){
            var tr1 = checkedbox[0].parentElement.parentElement;
            var tr2 = checkedbox[1].parentElement.parentElement;
            var cloneTr = tr2.cloneNode(true); //두번째꺼 깊은복사
            tr1.replaceWith(cloneTr);//복사한 2번째것과 처음것이 자리를 바꿈
            tr2.replaceWith(tr1);//밖으로 튕겨져나간 처음것을 2번째것과 바꿈;
            //튕겨져나간 tr2는  나중에 가비지컬렉터가 회수해감
            

        }else{
            alert("두개만 선택해주세요");
        }
    };

});

//Ex8-노드 삽입과 바꾸기
window.addEventListener("load", function(){

    var section = document.querySelector("#section8");
    
    var noticeList =section.querySelector(".notice-list"); 
    var tbodyNode = noticeList.querySelector("tbody");
    var upButton = section.querySelector(".up-button");
    var downButton = section.querySelector(".down-button");

    var currentNode = tbodyNode.firstElementChild;//.children[0];

    downButton.onclick = function(){
        
        var nextNode = currentNode.nextElementSibling;
        if(nextNode == null){
            alert("더이상 이동불가")
        }
        //tbodyNode.removeChild(nextNode);
        //tbodyNode.insertBefore(nextNode,currentNode);
        tbodyNode.insertAdjacentElement("beforebegin",nextNode);
        
    };

    upButton.onclick = function(){
        var prevNode = currentNode.previousElementSibling;
        if(prevNode==null){
            alert("더이상 이동불가")
        }
        //tbodyNode.removeChild(currentNode);
        //tbodyNode.insertBefore(currentNode,prevNode);
        tbodyNode.insertAdjacentElement("afterend",nextNode);
    };

});


//Ex7 : 노드 복제와 템플릿 태그
window.addEventListener("load", function(){
    var notices = [
        {id:5, title:"퐈이야~~~", regDate:"2019-01-26", writerId:"newlec", hit:0},
        {id:6, title:"나 좀 복제해줘~", regDate:"2019-01-26", writerId:"newlec", hit:17}
    ];

    var section = document.querySelector("#section7");
    
    var noticeList =section.querySelector(".notice-list"); 
    var tbodyNode = noticeList.querySelector("tbody");
    var cloneButton = section.querySelector(".clone-button");
    var templateButton = section.querySelector(".template-button");
   
    cloneButton.onclick = function(){
        var trNode = noticeList.querySelector("tbody tr");
        for(var j=0,i=0; i<notices.length; i++){
            var cloneNode = trNode.cloneNode(true); //깊은복사 자식의 자식까지 모두 싹다~
            var tds = cloneNode.querySelectorAll("td");
            tds[j].textContent= notices[i].id;
            tds[j+1].innerHTML = "<a href='"+notices[i].id+"'>"+notices[i].title+"</a>";
            tds[j+2].textContent= notices[i].regDate;
            tds[j+3].textContent= notices[i].writerId;
            tds[j+4].textContent= notices[i].hit;
            tbodyNode.append(cloneNode);
        }  
        
    };

    templateButton.onclick = function(){
        console.log(notices);
        var template = document.querySelector("template");
        //console.log(template);
        //console.log(template.content);
       
        for(var j=0,i=0; i<notices.length; i++){
            var cloneNode = document.importNode(template.content, true);
            var tds = cloneNode.querySelectorAll("td");
            tds[j].textContent= notices[i].id;
            tds[j+1].innerHTML = "<a href='"+notices[i].id+"'>"+notices[i].title+"</a>";
            tds[j+2].textContent= notices[i].regDate;
            tds[j+3].textContent= notices[i].writerId;
            tds[j+4].textContent= notices[i].hit;
            tbodyNode.append(cloneNode);
        }  
        
    };

});


//Ex6 : 메뉴추가(createTextNode, Element)
window.addEventListener("load", function(){
    var section = document.querySelector("#section6");
    
    var titleInput =section.querySelector(".title-input"); 
    var menuListUl =section.querySelector(".menu-list"); 
    var addButton = section.querySelector(".add-button");
    var delButton = section.querySelector(".del-button");

    addButton.onclick = function(){

        //menuListUl.innerHTML +="<li><a href=''>"+titleInput.value+"</a></li>";
        
        var textNode = document.createTextNode(titleInput.value);
        var li= document.createElement("li");
        var a = document.createElement('a');
        a.href="#";
        //a.innerHTML = titleInput.value;
        a.append(textNode);
        li.append(a);
        menuListUl.append(li);
        
        

    };
    delButton.onclick = function(){
       var firstLi =menuListUl.children[0];
       //menuListUl.removeChild(firstLi);
       firstLi.remove();
       

    };

});

//Ex5 : 엘리먼트 노드의 속성& CSS 속성 변경
window.addEventListener("load", function(){
    var section = document.querySelector("#section5");
    var srcInput = section.querySelector(".src-input");
    var imgSelect = section.querySelector(".img-select");
    var changeButton = section.querySelector(".change-button");
    var img = section.querySelector(".img");
    var colorInput = section.querySelector(".color-input");

    changeButton.onclick = function(){
        img.src="./images/"+srcInput.value;
        img.src="./images/"+imgSelect.value;
        console.log(colorInput);
        console.log(img.className);
        img.style.borderColor=colorInput.value;
    };

});
