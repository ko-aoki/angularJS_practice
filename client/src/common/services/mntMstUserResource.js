angular.module('services').factory('mntMstUserResource', ['$resource',
    function ($resource) {
        var baseApi = 'webresources/mntMstUser';
        var params = null;
        var actions = {
            getUsers: {
                method: 'GET',
                params: {
                    'userNm': '@userNm',
                    'deptId1': '@deptId1',
                    'deptId2': '@deptId2',
                    'roleId': '@roleId'
                },
                url: baseApi + '/:userNm,:deptId1,:deptId2,:roleId'
            },
            getUser: {
                method: 'GET',
                params: {
                    'mstUserId': '@mstUserId'
                },
                url: baseApi + '/:mstUserId'
            },
            confirm: {
                method: 'POST',
                url: baseApi
            },
            update: {
                method: 'PUT',
                params: {
                    'mstUserId': '@mstUserId'
                },
                url: baseApi + '/:mstUserId'
            }
        };
        return $resource(baseApi, params, actions);

    }]);
