define(['controllers', 'services/dtoSrv'],
    function(controllers) {
        controllers.controller('MntMstUserRegCtrl', ['$scope', '$http', '$location', '$routeParams', 'dtoSrv',
            function ($scope, $http, $location, $routeParams, dtoSrv) {
                if (dtoSrv.getData('MntMstUserReg') == null) {
                    $http.get('webresources/mntMstUser/' + $routeParams.mstUserId).success(function (data) {
                        $scope.rec = data.rec;
                        $scope.roles = data.roles;
                    });
                } else {
                    $scope.rec = dtoSrv.getData('MntMstUserReg').rec;
                    $scope.roles = dtoSrv.getData('MntMstUserReg').roles;
                    dtoSrv.setData('MntMstUserReg', null);
                }
                $scope.confirm = function () {
                    $http.post('webresources/mntMstUser/',
                        {rec: $scope.rec},
                        {headers: {
                            'Content-Type': 'application/json'
                        }}
                    ).success(function (data) {
                            dtoSrv.setData('MntMstUserRegConfirm', {'rec':$scope.rec, 'roles':$scope.roles});
                            dtoSrv.setData('MntMstUserReg', {'rec':$scope.rec, 'roles':$scope.roles});
                            $location.path("mntMstUserRegConfirm");
                        });
                };
                $scope.back = function () {
                    $location.path('mntMstUser');
                };
            }
        ]);
    }
);
