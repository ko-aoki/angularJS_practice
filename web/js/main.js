require.config({
	paths: {
        'jquery': 'vendor/jquery/jquery',
        'jquery.treeview': 'vendor/jquery/jquery.treeview',
        'angular': 'vendor/angular/angular',
        'angularRoute': 'vendor/angular/angular-route',
        'angularMocks': 'vendor/angular-mocks/angular-mocks',
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
	},
	priority: [
		"angular"
	]
});

//http://code.angularjs.org/1.2.1/docs/guide/bootstrap#overview_deferred-bootstrap
//https://docs.angularjs.org/guide/bootstrap
window.name = "NG_DEFER_BOOTSTRAP!";

require( [
	'angular',
	'app'
], function( angular, app) {
	'use strict';
	var $html = angular.element(document.getElementsByTagName('html')[0]);

	angular.element().ready(function() {
		angular.resumeBootstrap([app['name']]);
	});
});
