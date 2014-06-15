define(['directives'],function(directives) {
    directives.directive('csngCodeDept', ['$rootScope', '$http',function($rootScope, $http) {
        return {
            restrict: 'A',
            scope: true,
            templateUrl:'templates/codeDept.html',
            replace:true,
            controller: 'CodeDeptCtrl'
        };
    }]);
});
