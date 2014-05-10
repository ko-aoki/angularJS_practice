define(['controllers'],
    function(controllers) {
        controllers.controller('LoginCtrl', ['$scope', '$http',
        function ($scope, $http) {
        $scope.login = function login() {
            $http.get('webresources/login/' + $scope.loginUserId + ',' + $scope.password).success(function (data) {
                if (data.result === "error") {
                    $scope.messages = data.messages;
                } else {
                    window.location.href = "#/menu/" + data.roleId;
                }
            });
        };
    }]);
});
