angular.module('services').factory('menuResource', ['$resource', '$routeParams',
    function ($resource, $routeParams) {
        var baseApi = 'webresources/menu/';
        var params = null;
        var actions = {
            getMenu: {
                method: 'GET',
                url: baseApi + $routeParams.roleId,
                isArray: true
            }
        };
        return $resource(baseApi, params, actions);

    }]);
