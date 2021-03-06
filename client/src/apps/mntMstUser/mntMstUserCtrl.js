angular.module('controllers').controller('MntMstUserCtrl', ['$scope', '$location', 'dtoSrv', 'mntMstUserResource',
        function ($scope, $location, dtoSrv, mntMstUserResource) {

            $scope.recs = [];
            $scope.cond = {};

            mntMstUserResource.getUsers(
                {}, function (data) {
                    $scope.cond.roles = data.roles;
                }
            );

            //戻る
            if (dtoSrv.getData('MntMstUser') != null) {
                $scope.recs = dtoSrv.getData('MntMstUser').recs;
                $scope.cond = dtoSrv.getData('MntMstUser').cond;
            }
            //検索
            $scope.find = function find() {
                mntMstUserResource.getUsers(
                    {
                        'userNm': $scope.cond.userNm,
                        'deptId1': $scope.cond.deptId1,
                        'deptId2': $scope.cond.deptId2,
                        'roleId': $scope.cond.roleId
                    }, function (data) {
                        if (data.result === "error") {
                            $scope.messages = data.messages;
                        } else {
                            $scope.recs = data.recs;
                            $scope.cond.roles = data.roles;
                        }
                    }
                );
            };
            //登録
            $scope.register = function register(rec) {
                $location.path("mntMstUserReg");
            };
            //修正
            $scope.modify = function modify(rec) {
                dtoSrv.setData('MntMstUser', {'cond': $scope.cond, 'recs': $scope.recs})
                $location.path("mntMstUserReg/" + rec.mstUserId);
            };
            //部門検索
            $scope.findDept = function findDept(kind) {
                //TODO jQuery排除するか
                $("#codeDept").removeClass("hide");
                $("#codeDept").addClass("show");
            };
            //部門検索「OK」押下
            $scope.$on('CodeDeptOK', function (event, rec) {
                $scope.cond.deptId1 = rec.pDeptId;
                $scope.cond.deptNm1 = rec.pDeptNm;
                $scope.cond.deptId2 = rec.deptId;
                $scope.cond.deptNm2 = rec.deptNm;
                $("#codeDept").removeClass("show");
                $("#codeDept").addClass("hide");
            });

        }]
);
