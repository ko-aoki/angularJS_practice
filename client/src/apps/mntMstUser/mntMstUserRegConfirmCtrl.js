angular.module('controllers').controller('MntMstUserRegConfirmCtrl', ['$scope', '$location', 'dtoSrv', 'mntMstUserResource',
    function ($scope, $location, dtoSrv, mntMstUserResource) {
        $scope.rec = dtoSrv.getData('MntMstUserRegConfirm').rec;
        $scope.register = function () {
            mntMstUserResource.update(
                {
                    'rec': $scope.rec,
                    'mstUserId': $scope.rec.mstUserId
                }, function (data) {
                    $scope.messages = data.messages;
                }
            );
        };
        $scope.back = function () {
            $location.path('mntMstUserReg');
        };
    }
]);
