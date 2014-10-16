require.config({
	paths: {
        'jquery': 'vendor/jquery/jquery',
        'jquery.treeview': 'vendor/jquery/jquery.treeview',
        'moment': 'vendor/momentjs/moment',
        'angular': 'vendor/angular/angular',
        'angularRoute': 'vendor/angular/angular-route',
        'angularResource': 'vendor/angular/angular-resource',
        'angularMocks': 'vendor/angular-mocks/angular-mocks',
        'domReady': 'vendor/requirejs/domReady'
//        'text': 'vendor/requirejs-text/text'
	},
	shim: {
        'jquery' : {'exports' : 'jquery'},
        'jquery.treeview' :['jquery'],
        'moment' : {'exports' : 'moment'},
        'angular' : {'exports' : 'angular'},
		'angularRoute': ['angular'],
        'angularResource': { deps:['angular'] },
		'angularMocks': {
			deps:['angular'],
			'exports':'angular.mock'
		}
	}
});

require([
        'angular',
        'moment',
        'app',
        'domReady',
        //ファイルを追加したらここに追記
        'services/dtoSrv',
        'services/loginResource',
        'services/menuResource',
        'services/mntMstUserResource',
        'services/codeDeptResource',
        'controllers/loginCtrl',
        'controllers/menuCtrl',
        'controllers/mntMstUserCtrl',
        'controllers/mntMstUserRegCtrl',
        'controllers/mntMstUserRegConfirmCtrl',
        'controllers/codeDeptCtrl',
        'directives/csngPage',
        'directives/csngCodeDept',
        'directives/csngDate'
    ],
    function (angular, moment, app, domReady) {
        'use strict';
        app.config(['$routeProvider',
            function($routeProvider) {
//ルートの定義。画面を追加したらここで追記
                $routeProvider.when('/login', {templateUrl: 'partials/login.html', controller: 'LoginCtrl'});
                //メニュー画面
                $routeProvider.when('/menu/:roleId', {templateUrl: 'partials/menu.html', controller: 'MenuCtrl'});
                //ユーザマスタメンテナンス画面
                $routeProvider.when('/mntMstUser', {templateUrl: 'partials/mntMstUser.html', controller: 'MntMstUserCtrl'});
                //ユーザマスタメンテナンス画面（登録）
                $routeProvider.when('/mntMstUserReg', {templateUrl: 'partials/mntMstUserReg.html',
                    controller: 'MntMstUserRegCtrl'
                });
                //ユーザマスタメンテナンス画面（修正）
                $routeProvider.when('/mntMstUserReg/:mstUserId', {templateUrl: 'partials/mntMstUserReg.html',
                    controller: 'MntMstUserRegCtrl'
                });
                //ユーザマスタメンテナンス画面（確認）
                $routeProvider.when('/mntMstUserRegConfirm', {templateUrl: 'partials/mntMstUserRegConfirm.html',
                    controller: 'MntMstUserRegConfirmCtrl'
                });
                //部門コード参照画面
                $routeProvider.when('/codeDept', {templateUrl: 'partials/codeDept.html',
                    controller: 'CodeDeptCtrl'
                });
                $routeProvider.otherwise({redirectTo: '/login'});
            }
        ]);
        domReady(function() {
            angular.bootstrap(document, ['MyApp']);

            // The following is required if you want AngularJS Scenario tests to work
            $('html').addClass('ng-app: MyApp');
        });
    }
);
