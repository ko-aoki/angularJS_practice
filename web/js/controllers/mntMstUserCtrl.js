define(['jquery', 'controllers', 'services/dtoSrv'],
    function($, controllers) {
        controllers.controller('MntMstUserCtrl', ['$scope', '$http', '$location', '$routeParams', 'dtoSrv',
                function ($scope, $http, $location, $routeParams, dtoSrv) {
                    $scope.recs = [];
                    $scope.cond = {};
                    $http.get('webresources/mntMstUser/,,,').success(function (data) {
                        $scope.cond.roles = data.roles;
                    });
                    //戻る
                    if (dtoSrv.getData('MntMstUser') != null) {
                        $scope.recs = dtoSrv.getData('MntMstUser').recs;
                        $scope.cond = dtoSrv.getData('MntMstUser').cond;
                    }
                    $scope.find = function find() {
                        var url = 'webresources/mntMstUser/' +
                            ($.isEmptyObject($scope.cond.userNm) ? '' : $scope.cond.userNm) + ',' +
                            ($.isEmptyObject($scope.cond.deptId1) ? '' : $scope.cond.deptId1) + ',' +
                            ($.isEmptyObject($scope.cond.deptId2) ? '' : $scope.cond.deptId2) + ',' +
                            ($.isEmptyObject($scope.cond.roleId) ? '' : $scope.cond.roleId);
                        url = encodeURI(url);
                        $http.get(url).success(function (data) {
                            if (data.result === "error") {
                                $scope.messages = data.messages;
                            } else {
                                $scope.recs = data.recs;
                                $scope.cond.roles = data.roles;
                            }
                        });
                    };
                    $scope.register = function register(rec) {
                        $location.path("mntMstUserReg");
                    };
                    $scope.modify = function modify(rec) {
                        dtoSrv.setData('MntMstUser', {'cond':$scope.cond, 'recs':$scope.recs})
                        $location.path("mntMstUserReg/" + rec.mstUserId);
                    };
                    $scope.findDept = function findDept(kind) {
                        //TODO jQuery排除するか
                        $("#codeDept").removeClass("hide");
                        $("#codeDept").addClass("show");
                    };
                    $scope.codeDeptOk = function codeDeptOk(rec) {
                        $scope.cond.deptId1 = rec.pDeptId;
                        $scope.cond.deptNm1 = rec.pDeptNm;
                        $scope.cond.deptId2 = rec.deptId;
                        $scope.cond.deptNm2 = rec.deptNm;
                        $("#codeDept").removeClass("show");
                        $("#codeDept").addClass("hide");
                    };

                }]
        )
    }
);
