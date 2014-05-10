define(['controllers', 'services/dtoSrv'],
    function(controllers) {
        controllers.controller('MntMstUserRegConfirmCtrl', ['$scope', '$http', '$location', '$routeParams', 'dtoSrv',
            function ($scope, $http, $location, $routeParams, dtoSrv) {
                $scope.rec = dtoSrv.getData();
            }]
        );
    }
);
