'use strict';

/* Controllers */

angular.module('myApp.controllers', [])
    .controller('LoginCtrl', ['$scope', '$http', function ($scope, $http) {
        $scope.login = function login() {
            $http.get('webresources/login/' + $scope.loginUserId + ',' + $scope.password).success(function (data) {
                if (data.result === "error") {
                    $scope.messages = data.messages;
                } else {
                    window.location.href = "#/menu/" + data.roleId;
                }
            });
        };
    }])
    .controller('MenuCtrl', ['$scope', '$http', '$routeParams', function ($scope, $http, $routeParams) {
//        $http.get('data/menuJson.js').success(function(data) {
        $http.get('webresources/menu/' + $routeParams.roleId).success(function (data) {
            writeMenuList(data, $("#menu"));
            $("#menu").treeview();
        });
        function writeMenuList(data, elm) {
            for (var i = 0; i < data.length; i++) {
                if (data[i].childMenu != undefined && data[i].childMenu.length > 0) {
                    var ul = $("<ul></ul>");
                    var li = $("<li>" + data[i].menuId + "</li>");
                    writeMenuList(data[i].childMenu, ul);
                    li.append(ul);
                    elm.append(li);
                    console.log("ul:" + data[i].path);
                } else {
                    elm.append('<li><a href="' + data[i].url + '" target="_blank" "width=1024,height=800">' + data[i].menuId + '</a></li>');
                    console.log("li:" + data[i].path);
                }
            }
        };

    }])
    .controller('MntMstUserCtrl', ['$scope', '$http', '$routeParams', function ($scope, $http, $routeParams) {
        $scope.find = function find() {
            var url = 'webresources/mntMstUser/' +
                 ($.isEmptyObject($scope.userNm) ? '' : $scope.userNm) + ',' +
                 ($.isEmptyObject($scope.deptId1) ? '' : $scope.deptId1) + ',' +
                 ($.isEmptyObject($scope.deptId2) ? '' : $scope.deptId2) + ',' +
                 ($.isEmptyObject($scope.roleId) ? '' : $scope.roleId) ;
            url = encodeURI(url);
            $http.get(url).success(function (data) {
                if (data.result === "error") {
                    $scope.messages = data.messages;
                } else {
                    $scope.recs = data.recs;
                }
            });
        };
        $scope.regiser = function regiser() {
            $http.get('webresources/mntMstUserReg/' + $routeParams.mstUserId).success(function (data) {
                window.location.href = "#/mntMstUserReg/" + data.roleId;
            });
        };
    }])
    .controller('MyCtrl2', [function () {

    }]);