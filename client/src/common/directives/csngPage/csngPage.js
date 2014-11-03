angular.module('directives').directive('csngPage', ['$rootScope', function ($rootScope) {
    return {
        restrict: 'A',
        scope: {
            pageInfo: '=',
            pageJump: '='
        },
        templateUrl: 'partials/common/directives/page/page.tpl.html',
        replace: true
    };
}]);

