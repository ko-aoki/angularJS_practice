define([
    'angular',
    'filters',
    'services',
    'directives',
    'controllers',
    'angularRoute',
], function (angular, filters, services, directives, controllers) {
    'use strict';

    // Declare app level module which depends on filters, and services

    return angular.module('myApp', [
        'ngRoute',
        'myApp.controllers',
        'myApp.filters',
        'myApp.services',
        'myApp.directives'
    ]).
    config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/login', {templateUrl: 'partials/login.html', controller: 'LoginCtrl'});
        $routeProvider.when('/menu/:roleId', {templateUrl: 'partials/menu.html', controller: 'MenuCtrl'});
        $routeProvider.when('/mntMstUser', {templateUrl: 'partials/mntMstUser.html', controller: 'MntMstUserCtrl'});
        $routeProvider.when('/mntMstUserReg/:mstUserId', {templateUrl: 'partials/mntMstUserReg.html', controller: 'MntMstUserRegCtrl'});
        $routeProvider.otherwise({redirectTo: '/login'});
    }]);

});

/*
'use strict';


// Declare app level module which depends on filters, and services
angular.module('myApp', [
  'ngRoute',
  'myApp.filters',
  'myApp.services',
  'myApp.directives',
  'myApp.controllers'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/login', {templateUrl: 'partials/login.html', controller: 'LoginCtrl'});
  $routeProvider.when('/menu/:roleId', {templateUrl: 'partials/menu.html', controller: 'MenuCtrl'});
  $routeProvider.when('/mntMstUser', {templateUrl: 'partials/mntMstUser.html', controller: 'MntMstUserCtrl'});
  $routeProvider.when('/mntMstUserReg/:mstUserId', {templateUrl: 'partials/mntMstUserReg.html', controller: 'MntMstUserRegCtrl'});
  $routeProvider.otherwise({redirectTo: '/login'});
}]);
*/