define(['controllers','angularResource', 'services/loginResource'],
    function(controllers) {
        controllers.controller('LoginCtrl', ['$scope', '$location', 'loginResource',
            function ($scope, $location, loginResource) {
                $scope.login = function login() {
                    loginResource.login(
                        {'loginUserId': $scope.loginUserId, 'password': $scope.password},
                        function (data) {
                            if (data.result === "error") {
                                $scope.messages = data.messages;
                            } else {
                                $location.path("menu/" + data.roleId);
                            }
                        }
                    );
                };
            }]);
    });
