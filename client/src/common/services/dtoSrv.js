angular.module('services').factory('dtoSrv', [
    function () {
        var data = [];
        return {
            getData: function (key) {
                return data[key];
            },
            setData: function (key, value) {
                data[key] = value;
            }
        };
    }]);
