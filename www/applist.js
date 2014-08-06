var AppinfoLoader = function (require, exports, module) {
    var exec = require("cordova/exec");
    
    function Applist () {}
        
    Applist.prototype.list = function (successFunc, failFunc) {
        exec(successFunc, failFunc, "Applist","list",[]);
    };
    
    var appList = new AppInfo();
    module.exports = appList;
};

SmslogLoader(require, exports, module);

cordova.define("cordova/plugin/Applist", AppinfoLoader);



/*  ORIG

var exec = require("cordova/exec");

var Applist = function () {
    this.name = "Applist";
};

Apps.prototype.list = function (func) {
	exec(func, null, "Applist", "list", []);
};

module.exports = new Applist();*/
