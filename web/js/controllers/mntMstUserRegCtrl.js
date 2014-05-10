define(['controllers', 'services/dtoSrv'],
    function(controllers) {
        controllers.controller('MntMstUserRegCtrl', ['$scope', '$http', '$location', '$routeParams', 'dtoSrv',
            function ($scope, $http, $location, $routeParams, dtoSrv) {
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
                            dtoSrv.setData($scope.rec);
                            window.location.href = "#/mntMstUserRegConfirm/";
                        });
                };
            }
         ]);
    }
);
