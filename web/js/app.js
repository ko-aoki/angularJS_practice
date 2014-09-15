// The app/scripts/app.js file, which defines our AngularJS app
define([
    'angular',
    'angularResource',
    'angularRoute',
    'controllers',
    'services',
    'filters',
    'directives'
], function (angular) {
    return angular.module('MyApp', [
        'ngResource',
        'ngRoute',
        'controllers',
        'services',
        'filters',
        'directives'
    ]);
});
