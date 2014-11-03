/*! common-app-javaee7 - v0.0.1-SNAPSHOT - 2014-11-04
 * https://github.com/ko-aoki/angularJS_practice
 * Copyright (c) 2014 Pawel Kozlowski & Peter Bacon Darwin;
 * Licensed MIT
 */
angular.module('app', [
    'ngResource',
    'ngRoute',
    'controllers',
    'services',
    'filters',
    'directives'
    //,
    //'templates.app',
    //'templates.common'
]);

angular.module('controllers', []);

angular.module('directives', []);

angular.module('filters', []);


angular.module('controllers').controller('LoginCtrl', ['$scope', '$location', 'loginResource',
    function ($scope, $location, loginResource) {
        $scope.login = function login() {
            loginResource.login(
                {'loginUserId': $scope.loginUserId, 'password': $scope.password},
                function (data) {
                    if (data.result === "error") {
                        $scope.messages = data.messages;
                    } else {
                        $location.path("menu/" + data.roleId);
                    }
                }
            );
        };
    }]);

angular.module('app').config(['$routeProvider',
         function ($routeProvider) {
//ルートの定義。画面を追加したらここで追記
             $routeProvider.when('/login', {templateUrl: 'partials/app/login/login.tpl.html', controller: 'LoginCtrl'});
             //メニュー画面
             $routeProvider.when('/menu/:roleId', {templateUrl: 'partials/app/menu/menu.tpl.html', controller: 'MenuCtrl'});
             //ユーザマスタメンテナンス画面
             $routeProvider.when('/mntMstUser', {templateUrl: 'partials/app/mntMstUser/mntMstUser.tpl.html', controller: 'MntMstUserCtrl'});
             //ユーザマスタメンテナンス画面（登録）
             $routeProvider.when('/mntMstUserReg', {templateUrl: 'partials/app/mntMstUser/mntMstUserReg.tpl.html',
                 controller: 'MntMstUserRegCtrl'
             });
             //ユーザマスタメンテナンス画面（修正）
             $routeProvider.when('/mntMstUserReg/:mstUserId', {templateUrl: 'partials/app/mntMstUser/mntMstUserReg.tpl.html',
                 controller: 'MntMstUserRegCtrl'
             });
             //ユーザマスタメンテナンス画面（確認）
             $routeProvider.when('/mntMstUserRegConfirm', {templateUrl: 'partials/app/mntMstUser/mntMstUserRegConfirm.tpl.html',
                 controller: 'MntMstUserRegConfirmCtrl'
             });
             //部門コード参照画面
             $routeProvider.when('/codeDept', {templateUrl: 'partials/app/codeDept/codeDept.tpl.html',
                 controller: 'CodeDeptCtrl'
             });
             $routeProvider.otherwise({redirectTo: '/login'});
         }
     ]);

angular.module('controllers').controller('MenuCtrl', ['$scope', 'menuResource',
    function ($scope, menuResource) {
//                $http.get('webresources/menu/' + $routeParams.roleId).success(function (data) {
        menuResource.getMenu(
            {},
            function (data) {
                var $menu = $("#menu");
                writeMenuList(data, $menu);
                $menu.treeview();
            }
        );
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
        }
    }
]);

angular.module('controllers').controller('MntMstUserCtrl', ['$scope', '$location', 'dtoSrv', 'mntMstUserResource',
        function ($scope, $location, dtoSrv, mntMstUserResource) {

            $scope.recs = [];
            $scope.cond = {};

            mntMstUserResource.getUsers(
                {}, function (data) {
                    $scope.cond.roles = data.roles;
                }
            );

            //戻る
            if (dtoSrv.getData('MntMstUser') != null) {
                $scope.recs = dtoSrv.getData('MntMstUser').recs;
                $scope.cond = dtoSrv.getData('MntMstUser').cond;
            }
            //検索
            $scope.find = function find() {
                mntMstUserResource.getUsers(
                    {
                        'userNm': $scope.cond.userNm,
                        'deptId1': $scope.cond.deptId1,
                        'deptId2': $scope.cond.deptId2,
                        'roleId': $scope.cond.roleId
                    }, function (data) {
                        if (data.result === "error") {
                            $scope.messages = data.messages;
                        } else {
                            $scope.recs = data.recs;
                            $scope.cond.roles = data.roles;
                        }
                    }
                );
            };
            //登録
            $scope.register = function register(rec) {
                $location.path("mntMstUserReg");
            };
            //修正
            $scope.modify = function modify(rec) {
                dtoSrv.setData('MntMstUser', {'cond': $scope.cond, 'recs': $scope.recs})
                $location.path("mntMstUserReg/" + rec.mstUserId);
            };
            //部門検索
            $scope.findDept = function findDept(kind) {
                //TODO jQuery排除するか
                $("#codeDept").removeClass("hide");
                $("#codeDept").addClass("show");
            };
            //部門検索「OK」押下
            $scope.$on('CodeDeptOK', function (event, rec) {
                $scope.cond.deptId1 = rec.pDeptId;
                $scope.cond.deptNm1 = rec.pDeptNm;
                $scope.cond.deptId2 = rec.deptId;
                $scope.cond.deptNm2 = rec.deptNm;
                $("#codeDept").removeClass("show");
                $("#codeDept").addClass("hide");
            });

        }]
);

angular.module('controllers').controller('MntMstUserRegConfirmCtrl', ['$scope', '$location', 'dtoSrv', 'mntMstUserResource',
    function ($scope, $location, dtoSrv, mntMstUserResource) {
        $scope.rec = dtoSrv.getData('MntMstUserRegConfirm').rec;
        $scope.register = function () {
            mntMstUserResource.update(
                {
                    'rec': $scope.rec,
                    'mstUserId': $scope.rec.mstUserId
                }, function (data) {
                    $scope.messages = data.messages;
                }
            );
        };
        $scope.back = function () {
            $location.path('mntMstUserReg');
        };
    }
]);

angular.module('controllers').controller('MntMstUserRegCtrl', ['$scope', '$location', '$routeParams', 'dtoSrv', 'mntMstUserResource',
    function ($scope, $location, $routeParams, dtoSrv, mntMstUserResource) {
        if (dtoSrv.getData('MntMstUserReg') == null) {
            mntMstUserResource.getUser(
                {
                    'mstUserId': $routeParams.mstUserId
                }, function (data) {
                    $scope.rec = data.rec;
                    $scope.roles = data.roles;
                }
            );
        } else {
            $scope.rec = dtoSrv.getData('MntMstUserReg').rec;
            $scope.roles = dtoSrv.getData('MntMstUserReg').roles;
            dtoSrv.setData('MntMstUserReg', null);
        }
        $scope.confirm = function () {
            mntMstUserResource.confirm(
                {
                    'rec': $scope.rec
                }, function (data) {
                    dtoSrv.setData('MntMstUserRegConfirm', {'rec': $scope.rec, 'roles': $scope.roles});
                    dtoSrv.setData('MntMstUserReg', {'rec': $scope.rec, 'roles': $scope.roles});
                    $location.path("mntMstUserRegConfirm");
                }
            );

        };
        $scope.back = function () {
            $location.path('mntMstUser');
        };
    }
]);

angular.module('services', []);

angular.module('controllers').controller('CodeDeptCtrl', ['$scope', 'codeDeptResource',
        function ($scope, codeDeptResource) {
            $scope.find = function () {
                codeDeptResource.find(
                    {
                        pDeptId: $scope.pDeptId,
                        pDeptNm: $scope.pDeptNm,
                        deptId: $scope.deptId,
                        deptNm: $scope.deptNm,
                        pageInfo: $scope.pageInfo
                    },
                    function (data) {
                        $scope.pageInfo = data.pageInfo;
                        $scope.recs = data.recs;
                    }
                );
            };
            $scope.pageJump = function (page) {
                $scope.pageInfo.requestPage = page;
                $scope.find();
            };
            $scope.ok = function ok(rec) {
                $scope.$emit('CodeDeptOK', rec);
            };
            $scope.cancel = function cancel() {
                $("#codeDept").removeClass("show");
                $("#codeDept").addClass("hide");
            };
        }]
);

angular.module('directives').directive('csngCodeDept', ['$rootScope', '$http', function ($rootScope, $http) {
    return {
        restrict: 'A',
        scope: true,
        templateUrl: 'partials/common/directives/codeDept/codeDept.tpl.html',
        replace: true,
        controller: 'CodeDeptCtrl'
    };
}]);

//引用：http://stackoverflow.com/questions/14474555/how-to-format-a-date-using-ng-model
angular.module('directives').directive('csngDate', [ function () {
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function (scope, element, attrs, ngModelCtrl) {
            ngModelCtrl.$formatters.push(formatter);
            ngModelCtrl.$parsers.push(parser);

            element.on('change', function (e) {
                var element = e.target;
                element.value = formatter(ngModelCtrl.$modelValue);
            });

            function parser(value) {
                var m = moment(value);
                var valid = m.isValid();
                ngModelCtrl.$setValidity('csngDate', valid);
                if (valid) {
                    return m.toDate();
                }
                else {
                    return value;
                }
            }

            function formatter(value) {
                var m = moment(value);
                var valid = m.isValid();
                if (valid) {
                    return m.format("YYYY/MM/DD");
                }
                else {
                    return value;
                }
            }

        }
    };
}]);

angular.module('directives').directive('csngPage', ['$rootScope', function ($rootScope) {
    return {
        restrict: 'A',
        scope: {
            pageInfo: '=',
            pageJump: '='
        },
        templateUrl: 'partials/common/directives/page/page.tpl.html',
        replace: true
    };
}]);


angular.module('services').factory('codeDeptResource', ['$resource',
    function ($resource) {
        var baseApi = 'webresources/codeDept';
        var params = null;
        var actions = {
            find: {
                method: 'POST',
                url: baseApi
            }
        };
        return $resource(baseApi, params, actions);

    }]);

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

angular.module('services').factory('loginResource', ['$resource',
    function ($resource) {
        var baseApi = 'webresources/login';
        var params = null;
        var actions = {
            login: {
                method: 'GET',
                params: {
                    'loginUserId': '@loginUserId',
                    'password': '@password'
                },
                url: baseApi + '/:loginUserId,:password'
            }
        };
        return $resource(baseApi, params, actions);
    }]);

angular.module('services').factory('menuResource', ['$resource', '$routeParams',
    function ($resource, $routeParams) {
        var baseApi = 'webresources/menu/';
        var params = null;
        var actions = {
            getMenu: {
                method: 'GET',
                url: baseApi + $routeParams.roleId,
                isArray: true
            }
        };
        return $resource(baseApi, params, actions);

    }]);

angular.module('services').factory('mntMstUserResource', ['$resource',
    function ($resource) {
        var baseApi = 'webresources/mntMstUser';
        var params = null;
        var actions = {
            getUsers: {
                method: 'GET',
                params: {
                    'userNm': '@userNm',
                    'deptId1': '@deptId1',
                    'deptId2': '@deptId2',
                    'roleId': '@roleId'
                },
                url: baseApi + '/:userNm,:deptId1,:deptId2,:roleId'
            },
            getUser: {
                method: 'GET',
                params: {
                    'mstUserId': '@mstUserId'
                },
                url: baseApi + '/:mstUserId'
            },
            confirm: {
                method: 'POST',
                url: baseApi
            },
            update: {
                method: 'PUT',
                params: {
                    'mstUserId': '@mstUserId'
                },
                url: baseApi + '/:mstUserId'
            }
        };
        return $resource(baseApi, params, actions);

    }]);
