// The app/scripts/app.js file, which defines our AngularJS app
define([
    'angular',
    'controllers',
    'services',
    'filters',
    'directives',
    'angularRoute'
], function (angular) {
    return angular.module('MyApp', [
        'ngRoute',
        'controllers',
        'services',
        'filters',
        'directives']);
});
