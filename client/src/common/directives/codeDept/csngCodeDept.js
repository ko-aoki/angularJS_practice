angular.module('directives').directive('csngCodeDept', ['$rootScope', '$http', function ($rootScope, $http) {
    return {
        restrict: 'A',
        scope: true,
        templateUrl: 'partials/common/directives/codeDept/codeDept.tpl.html',
        replace: true,
        controller: 'CodeDeptCtrl'
    };
}]);
