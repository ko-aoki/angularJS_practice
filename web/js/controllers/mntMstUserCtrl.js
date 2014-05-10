define(['jquery', 'controllers'],
    function($, controllers) {
        controllers.controller('MntMstUserCtrl', ['$scope', '$http', '$routeParams',
                function ($scope, $http, $routeParams) {
                    $scope.recs = [];
                    $http.get('webresources/mntMstUser/,,,').success(function (data) {
                        $scope.roles = data.roles;
                    });
                    $scope.find = function find() {
                        var url = 'webresources/mntMstUser/' +
                            ($.isEmptyObject($scope.userNm) ? '' : $scope.userNm) + ',' +
                            ($.isEmptyObject($scope.deptId1) ? '' : $scope.deptId1) + ',' +
                            ($.isEmptyObject($scope.deptId2) ? '' : $scope.deptId2) + ',' +
                            ($.isEmptyObject($scope.roleId) ? '' : $scope.roleId);
                        url = encodeURI(url);
                        $http.get(url).success(function (data) {
                            if (data.result === "error") {
                                $scope.messages = data.messages;
                            } else {
                                $scope.recs = data.recs;
                                $scope.roles = data.roles;
                            }
                        });
                    };
                    $scope.regiser = function register(rec) {
                        $http.get('webresources/mntMstUser/' + rec.mstUserId).success(function (data) {
                            window.location.href = "#/mntMstUserReg/";
                        });
                    };
                    $scope.modify = function modify(rec) {
                        window.location.href = "#/mntMstUserReg/" + rec.mstUserId;
                    };
                }]
        )
    }
);
