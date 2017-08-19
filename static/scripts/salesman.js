(function() {
    angular.module("myApp").controller("salesmanController", salesmanController);
               
    function salesmanController($http, $sessionStorage, $location) {

        var vm = this;
       
        vm.goTo = goTo;
        vm.order = order;
        
        function goTo(path) {
        	$location.path('/' + path.toLowerCase());
        }
        
    }
   
})();