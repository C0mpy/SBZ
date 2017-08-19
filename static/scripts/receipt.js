(function() {
    angular.module("myApp").controller("receiptController", receiptController);
               
    function receiptController($http, $sessionStorage, $location) {

        var vm = this;
        vm.receipt = $sessionStorage.receipt;
        vm.originalPoints = vm.receipt.customer.points;
        vm.points = vm.receipt.customer.points;
        
        vm.goTo = goTo;
        vm.order = order;
        
        function goTo(path) {
        	$location.path('/' + path.toLowerCase());
        }
        
        function order() {
        	request = {"receiptCode" : vm.receipt.code, "points" : vm.spentPoints};
        	
        	$http.post("/api/customer/order", request).then(function(response) {
    			vm.goTo("customer"); 
    			$sessionStorage.removeItem("receipt");
            });

        }
        
        
    }
    
    
})();