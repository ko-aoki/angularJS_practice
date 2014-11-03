angular.module('services').factory('loginResource', ['$resource',
    function ($resource) {
        var baseApi = 'webresources/login';
        var params = null;
        var actions = {
            login: {
                method: 'GET',
                params: {
                    'loginUserId': '@loginUserId',
                    'password': '@password'
                },
                url: baseApi + '/:loginUserId,:password'
            }
        };
        return $resource(baseApi, params, actions);
    }]);
