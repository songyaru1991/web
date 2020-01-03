function buttonClick() {
    //取new_file.js的值
    var view = "", viewId = "", symbols = "",symbolsAddArray = "",symbolsModifyArray="";
    for (var item in newData) {
        if (item == 'view') {
            view = newData[item];  //640
            for (var item in view) {
                if (item == 'id') {
                    viewId = view[item];  //640
                }
            }
        }
        if (item == 'symbols') {
            symbols = newData[item];
            if (symbols != "") {
                for (var item in symbols) {
                    if (item == 'add') {
                        symbolsAddArray = symbols[item];
                    }
                    if (item == 'modify') {
                        symbolsModifyArray = symbols[item];
                    }
                }
            }
        }
    }

    //操作data.min.js的数据
    var symbolsTestDataArray = "";
    var viewStr = "", viewIdStr = "";
    for (var item in testData) {
        if (item == 'view') {
            viewStr = testData[item];
            for (var item in viewStr) {
                if (item == viewId) {//640
                    viewIdStr = viewStr[item];
                    for (var item in viewIdStr) {
                        if (item == 'symbols') {
                            symbolsTestDataArray = viewIdStr[item]; //640
                        }
                    }
                }
            }
        }
    }

    //取new_file.js的值增加到data.min.js的view--640--symbols下
    //add
    if (symbolsAddArray != "") {
        for (var add in symbolsAddArray) {
            if (symbolsTestDataArray != "") {
                symbolsTestDataArray.push(symbolsAddArray[add]);
            }
        }
        console.log("addSymbolsTestDataArray:" + symbolsTestDataArray);
        viewIdStr = setJson(viewIdStr, "symbols", symbolsTestDataArray);
        testData = setJson(testData, "view", viewIdStr);
    }

    //modify
    if (symbolsModifyArray != "") {
        //modify
        for (var item1 in symbolsTestDataArray) {
            var symbolsId = symbolsTestDataArray[item1].id;
            var symbolsModifyId = "";
            for (var item2 in symbolsModifyArray) {
                symbolsModifyId = symbolsModifyArray[item2].id

                if (symbolsId == symbolsModifyId) {
                    symbolsTestDataArray[item1] = symbolsModifyArray[item2]

                    viewIdStr = setJson(viewIdStr, "symbols", symbolsTestDataArray);
                    testData = setJson(testData, "view", viewIdStr);
                }

            }
        }

    }

    var jsonData = JSON.stringify(testData);
    var testDataStr ="var testData = "+ jsonData;

    var path='C://Users//Administrator//Desktop//js-json//data.min.js';
    var contextPath = getContextPath();
    $.ajax({
        url:contextPath+"/json/modifyJsFile",
        type:"post",
        data:{"content": testDataStr, "path": path},
        // dataType:"json",
        success:function(result){
            if(result.code == 200){
                layer.alert(result.message,function () {
                    window.parent.location.href = contextPath+result.nextUrl;
                });
            }else{
                layer.alert(result.message);
                return;
            }
        }
    })

    //写文件
    var title = "data1.min.js";//文件名
    /* var xmlHttp = new ActiveXObject("Scripting.FileSystemObject");
     var xmlHttp;
     var f = xmlHttp.CreateTextFile("C://Users//Administrator//Desktop//js-json//" + title, true); //可随意选择后缀名,如果文件可以覆盖，则第二个参数值为 true ，否则为 false
     f.write(testDataStr);
     f.Close();*/

    //  download(title + ".js",testDataStr);
}

//添加或者修改json数据
function setJson(jsonObj, name, value) {
    jsonObj[name] = value;
    // return JSON.stringify(jsonObj);
    return jsonObj;
}