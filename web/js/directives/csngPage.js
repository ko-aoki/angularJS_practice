define(['directives'], function(directives) {
    directives.directive('csngPage', ['$rootScope', function($rootScope) {
        return {
            restrict: 'A',
            scope: {
                pageInfo: '=',
                pageJump: '='
            },
            templateUrl:'templates/page.html',
            replace:true
        };
    }]);
});
