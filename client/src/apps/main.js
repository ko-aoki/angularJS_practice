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
