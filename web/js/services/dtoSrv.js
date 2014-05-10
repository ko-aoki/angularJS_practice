define(['services'],
 function(services) {
    services.factory('dtoSrv', [
      function() {
          var data;
          return {
              getData: function () {
                  return data;
              },
              setData: function (value) {
                  data = value;
              }
          };
      }]);
  });
