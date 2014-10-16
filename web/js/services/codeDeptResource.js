define(['services'],
 function(services) {
    services.factory('codeDeptResource', ['$resource',
      function($resource) {
          var baseApi = 'webresources/codeDept';
          var params = null;
          var actions = {
              find: {
                  method: 'POST',
                  url: baseApi
             }
          };
          return $resource(baseApi, params, actions);

      }]);
  });
