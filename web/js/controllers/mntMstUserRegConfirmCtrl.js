define(['controllers',  'angularResource', 'services/dtoSrv'],
    function(controllers) {
        controllers.controller('MntMstUserRegConfirmCtrl', ['$scope', '$http', '$location', '$resource', 'dtoSrv',
            function ($scope, $http, $location, $resource, dtoSrv) {
                $scope.rec = dtoSrv.getData('MntMstUserRegConfirm').rec;
                $scope.register = function () {
                    var resource = $resource('webresources/mntMstUser/:mstUserId',
                        {'mstUserId': '@mstUserId'},
                        { 'update' :{
                            'method': 'PUT',
                            isArray:false
                        }}
                    );
                    resource.update(
                        {
                            'rec': $scope.rec,
                            'mstUserId': $scope.rec.mstUserId
                        }, function(data) {
                            $scope.messages = data.messages;
                        }
                    );
//                    $http.put('webresources/mntMstUser/' + $scope.rec.mstUserId,
//                        {rec: $scope.rec},
//                        {headers: {
//                            'Content-Type': 'application/json'
//                        }}
//                    ).success(function (data) {
//                            $scope.messages = data.messages;
//                        });
                };
                $scope.back = function () {
                    $location.path('mntMstUserReg');
                };
            }]
        );
    }
);
