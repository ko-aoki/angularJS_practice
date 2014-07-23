var tests = [];
for (var file in window.__karma__.files) {
    if (/Spec\.js$/.test(file)) {
        tests.push(file);
    }
}

requirejs.config({
  // Karma serves files from '/base'
  baseUrl: '/base/web/js',

    paths: {
        'jquery': 'vendor/jquery/jquery',
        'jquery.treeview': 'vendor/jquery/jquery.treeview',
        'angular': 'vendor/angular/angular',
        'angularRoute': 'vendor/angular/angular-route',
        'angularMocks': 'vendor/angular-mocks/angular-mocks',
        'domReady': 'vendor/requirejs/domReady',
        'text': 'vendor/requirejs-text/text',
        'unitTest': '../../test/unit'
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

  // ask Require.js to load these files (all our tests)
  deps: tests,

  // start test run, once Require.js is done
  callback: window.__karma__.start
});
