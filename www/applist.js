var exec = require("cordova/exec");

var Applist = function () {
    this.name = "Applist";
};

Apps.prototype.list = function (func) {
	exec(func, null, "Applist", "list", []);
};

module.exports = new Applist();
