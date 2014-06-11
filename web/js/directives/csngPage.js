define(['directives'], function(directives) {
    directives.directive('csngPage', ['$rootScope', function($rootScope) {
        return {
            restrict: 'A',
            scope: true,
            templateUrl:'templates/page.html',
            replace:true
        };
    }]);
});
