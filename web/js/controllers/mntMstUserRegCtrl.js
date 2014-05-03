define([], function() {
    return ['$scope', '$http', '$routeParams', function ($scope, $http, $routeParams) {
        console.log("★★★★★★★★★★★★");
        $http.get('webresources/mntMstUser/' + $routeParams.mstUserId).success(function (data) {
            $scope.rec = data.rec;
            $scope.roles = data.roles;
        });
        $scope.$apply();
    }];
});
