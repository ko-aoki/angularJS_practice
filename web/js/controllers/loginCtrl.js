define(['controllers'],
    function(controllers) {
        controllers.controller('LoginCtrl', ['$scope', '$http', '$location',
        function ($scope, $http, $location) {
        $scope.login = function login() {
            $http.get('webresources/login/' + $scope.loginUserId + ',' + $scope.password).success(function (data) {
                if (data.result === "error") {
                    $scope.messages = data.messages;
                } else {
                    $location.path("menu/" + data.roleId) ;
                }
            });
        };
    }]);
});
