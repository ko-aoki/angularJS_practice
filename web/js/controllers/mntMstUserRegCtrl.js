define(['controllers', 'services/dtoSrv', 'services/mntMstUserResource'],
    function(controllers) {
        controllers.controller('MntMstUserRegCtrl', ['$scope', '$location', '$routeParams', 'dtoSrv', 'mntMstUserResource',
            function ($scope, $location, $routeParams, dtoSrv, mntMstUserResource) {
                if (dtoSrv.getData('MntMstUserReg') == null) {
                    mntMstUserResource.getUser(
                        {
                        'mstUserId': $routeParams.mstUserId
                        }, function(data) {
                            $scope.rec = data.rec;
                            $scope.roles = data.roles;
                        }
                    );
                } else {
                    $scope.rec = dtoSrv.getData('MntMstUserReg').rec;
                    $scope.roles = dtoSrv.getData('MntMstUserReg').roles;
                    dtoSrv.setData('MntMstUserReg', null);
                }
                $scope.confirm = function () {
                    mntMstUserResource.confirm(
                        {
                            'rec': $scope.rec
                        }, function(data) {
                            dtoSrv.setData('MntMstUserRegConfirm', {'rec':$scope.rec, 'roles':$scope.roles});
                            dtoSrv.setData('MntMstUserReg', {'rec':$scope.rec, 'roles':$scope.roles});
                            $location.path("mntMstUserRegConfirm");
                        }
                    );

                };
                $scope.back = function () {
                    $location.path('mntMstUser');
                };
            }
        ]);
    }
);
