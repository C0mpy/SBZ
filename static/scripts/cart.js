(function() {
    angular.module("myApp").controller("cartController", cartController);
               
    function cartController($http, $sessionStorage, $location) {

        var vm = this;
        vm.receipt = $sessionStorage.receipt;
        
        vm.goTo = goTo;
        vm.calculateDiscounts = calculateDiscounts;
        vm.removeItem = removeItem;
        
        function goTo(path) {
        	$location.path('/' + path.toLowerCase());
        }
        
        function calculateDiscounts() {
        	$http.post("/api/customer/calculateDiscounts", {"message" : vm.receipt.code}).then(function(response) {
    			$sessionStorage.receipt = response.data;
    			vm.goTo("receipt");
            });
        }
        
        function removeItem(itemId) {
        	$http.delete("/api/customer/receipt/" + vm.receipt.code + "/item/" + itemId).then(function(response) {
    			vm.receipt = response.data;
            });
        }
        
    }
    
    
})();