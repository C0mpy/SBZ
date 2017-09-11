(function() {
    angular.module("myApp").controller("salesmanController", salesmanController);
               
    function salesmanController($http, $sessionStorage, $location) {

        var vm = this;
       
        vm.goTo = goTo;
        vm.checkSupplies = checkSupplies;
        vm.order = order;
        vm.getReceipts = getReceipts;
        vm.accept = accept;
        vm.reject = reject;
        
        vm.ammounts = [];
        vm.receiptStatus = "ORDERED";
        
        vm.checkSupplies();
        vm.getReceipts();
        
        function goTo(path) {
        	$location.path('/' + path.toLowerCase());
        }
     
        function checkSupplies() {
        	
        	$http.get("/api/salesman/checkSupplies").then(function(response) {
    			vm.articles = response.data;
    			for(i = 0; i < vm.articles.length; i++) {
    				vm.ammounts.push({"articleCode" : vm.articles[i]["code"], "amount" : 0});
    			}
            });

        }
        
        function order(code, amount) {
        	if(!amount)
        		amount = 0;
        	request = {"code" : code, "amount" : amount};
        	$http.post("/api/salesman/orderArticles", request).then(function(response) {
    			vm.checkSupplies();
            });
        }
        
        function getReceipts() {
        	request = {"message" : vm.receiptStatus};
        	$http.post("/api/salesman/receiptState", request).then(function(response) {
        		console.log(vm.receipts);
    			vm.receipts = response.data;    			
            });
        }
        
        function accept(code) {
        	request = {"message" : code};
        	$http.post("/api/salesman/accept", request).then(function(response) {
    			if(response.data.length != 0) {
    				var articles = [];
    				for(i = 0; i < response.data.length; i++) {
    					articles.push({"code" : response.data[i]["article"]["code"], "name" : response.data[i]["article"]["name"]})
    				}
    				alert("Receipt cannot be accepted, these Items are low on amount: " + JSON.stringify(articles));
    			}
    			getReceipts();
            });
        }
        
        function reject(code) {
        	request = {"message" : code};
        	$http.post("/api/salesman/reject", request).then(function(response) {
        		getReceipts();
        	});
        }
         
    }
   
})();