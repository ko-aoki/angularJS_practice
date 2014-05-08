define([], function() {
    return ['$scope', '$http', '$location', '$routeParams', function ($scope, $http, $location, $routeParams) {
        $http.get('webresources/mntMstUser/' + $routeParams.mstUserId).success(function (data) {
            $scope.rec = data.rec;
            $scope.roles = data.roles;
        });
        $scope.confirm = function () {
//            $location.path('#/mntMstUserRegConfirm/');
            $http.post('webresources/mntMstUser/',
                {rec: $scope.rec},
                {headers: {
                    'Content-Type': 'application/json'
                }}
            ).success(function (data) {
                    window.location.href = "#/mntMstUserRegConfirm/";
                });
        };

        $scope.$apply();
    }];
});
