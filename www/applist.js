var ApplistLoader = function (require, exports, module) {
    var exec = require("cordova/exec");
    
    function Applist () {}
        
    Applist.prototype.getList = function (params, successFunc, failFunc) {
        exec(successFunc, failFunc, "Applist","getList",[]);
    };
    
    var appList = new Applist();
    module.exports = appList;
};

ApplistLoader(require, exports, module);

cordova.define("cordova/plugin/Applist", ApplistLoader);



/*  ORIG

var exec = require("cordova/exec");

var Applist = function () {
    this.name = "Applist";
};

Apps.prototype.list = function (func) {
	exec(func, null, "Applist", "list", []);
};

module.exports = new Applist();*/
