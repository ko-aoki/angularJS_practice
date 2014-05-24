define(['controllers', 'services/dtoSrv'],
    function(controllers) {
        controllers.controller('MntMstUserRegConfirmCtrl', ['$scope', '$http', '$location', '$routeParams', 'dtoSrv',
            function ($scope, $http, $location, $routeParams, dtoSrv) {
                $scope.rec = dtoSrv.getData();
                $scope.register = function () {
                    //            $location.path('#/mntMstUserRegConfirm/');
                    $http.put('webresources/mntMstUser/' + $scope.rec.mstUserId,
                        {rec: $scope.rec},
                        {headers: {
                            'Content-Type': 'application/json'
                        }}
                    ).success(function (data) {
                            $scope.messages = data.messages;
                        });
                };
            }]
        );
    }
);
