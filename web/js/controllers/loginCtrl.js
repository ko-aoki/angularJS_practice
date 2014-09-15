define(['controllers','angularResource'],
    function(controllers) {
        controllers.controller('LoginCtrl', ['$scope', '$http', '$location', '$resource',
            function ($scope, $http, $location, $resource) {
                $scope.login = function login() {
                    var login = $resource('webresources/login/:loginUserId,:password',
                                    {'loginUserId': '@loginUserId'},
                                    {'password': '@password'}
                                );
                    login.get(
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
