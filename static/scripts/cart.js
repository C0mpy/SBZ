(function() {
    angular.module("myApp").controller("cartController", cartController);
               
    function cartController($http, $sessionStorage, $location) {

        var vm = this;
        vm.receipt = $sessionStorage.receipt;
        
        vm.goTo = goTo;
        vm.calculateDiscounts = calculateDiscounts;
        
        function goTo(path) {
        	$location.path('/' + path.toLowerCase());
        }
        
        function calculateDiscounts() {
        	var receipt = {"code" : vm.receipt.code, "date" : vm.receipt.date, "customer" : vm.receipt.customer, "totalPrice" : vm.receipt.totalPrice, "items" : vm.receipt.items};
        	$http.post("/api/customer/calculateDiscounts", {"message" : vm.receipt.code}).then(function(response) {
    			$sessionStorage.receipt = response.data;
    			vm.goTo("receipt");
            });
        }
        
    }
    
    
})();