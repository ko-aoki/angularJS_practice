require.config({
	paths: {
        'jquery': 'vendor/jquery/jquery',
        'jquery.treeview': 'vendor/jquery/jquery.treeview',
        'angular': 'vendor/angular/angular',
        'angularRoute': 'vendor/angular/angular-route',
        'angularMocks': 'vendor/angular-mocks/angular-mocks',
        'domReady': 'vendor/requirejs/domReady',
        'text': 'vendor/requirejs-text/text'
	},
	shim: {
        'jquery' : {'exports' : 'jquery'},
        'jquery.treeview' :['jquery'],
        'angular' : {'exports' : 'angular'},
		'angularRoute': ['angular'],
		'angularMocks': {
			deps:['angular'],
			'exports':'angular.mock'
		}
	}
});

require([
        'angular',
        'app',
        'domReady',
        'services/dtoSrv',
        'controllers/loginCtrl',
        'controllers/menuCtrl',
        'controllers/mntMstUserCtrl',
        'controllers/mntMstUserRegCtrl',
        'controllers/mntMstUserRegConfirmCtrl'
        // Any individual controller, service, directive or filter file
        // that you add will need to be pulled in here.
    ],
    function (angular, app, domReady) {
        'use strict';
        app.config(['$routeProvider',
            function($routeProvider) {
                $routeProvider.when('/login', {templateUrl: 'partials/login.html', controller: 'LoginCtrl'});
                $routeProvider.when('/menu/:roleId', {templateUrl: 'partials/menu.html', controller: 'MenuCtrl'});
                $routeProvider.when('/mntMstUser', {templateUrl: 'partials/mntMstUser.html', controller: 'MntMstUserCtrl'});
                $routeProvider.when('/mntMstUserReg/:mstUserId', {templateUrl: 'partials/mntMstUserReg.html',
                    controller: 'MntMstUserRegCtrl'
                });
                $routeProvider.when('/mntMstUserRegConfirm', {templateUrl: 'partials/mntMstUserRegConfirm.html',
                    controller: 'MntMstUserRegConfirmCtrl'
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
