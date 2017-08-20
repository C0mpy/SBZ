(function() {
    angular.module("myApp").controller("managerController", managerController);
               
    function managerController($http, $sessionStorage, $location) {
        
    	var vm = this;
    	
    	vm.getUserCategories = getUserCategories;
        vm.saveLimits = saveLimits;
        vm.getArticleCategories = getArticleCategories;
        vm.addArticleCategory = addArticleCategory;
        vm.saveArticleCategories = saveArticleCategories;
        vm.addSale = addSale;
        vm.getSales = getSales;
        vm.saveSales = saveSales;
        
    	vm.getUserCategories();
    	vm.getArticleCategories();
    	vm.getSales();
    	
    	function getUserCategories() {
    		$http.get("/api/manager/getUserCategories").then(function(response) {
        		vm.categories = response.data;
            });
    	}
    	
    	function saveLimits() {
    		request = [];
    		for(i = 0; i < vm.categories.length; i++) {
    			for(j = 0; j < vm.categories[i]["limits"].length; j++) {
    				request.push(vm.categories[i]["limits"][j]);
    			}
    		}
    		
    		$http.post("/api/manager/saveLimits", request).then(function(response) {
            	vm.getUserCategories();
            });
    	}
    	
    	function getArticleCategories() {
    		$http.get("/api/manager/getArticleCategories").then(function(response) {
        		vm.articleCategories = response.data;
            });
    	}
    	
    	function addArticleCategory() {
    		request = {"code" : vm.newArticleCategoryCode, "name" : vm.newArticleCategoryName, "maxDiscount" : vm.newArticleCategoryMaxDiscount};
    		$http.post("/api/manager/addArticleCategory", request).then(function(response) {
            	vm.getArticleCategories();
            });
    		
    	}
    	
    	function saveArticleCategories() {
    	
    		$http.post("/api/manager/saveArticleCategories", vm.articleCategories).then(function(response) {
            	vm.getArticleCategories();
            	alert("saved");
            });
    	}
    	
    	function addSale() {
    		var categories = [];
    		Object.keys(vm.checkboxes).forEach(function(k, i) {
    			if(vm.checkboxes[k]) {
    				categories.push(k);
    			}
    		});
    		
    		var request = {"code" : vm.newSaleCode, "name" : vm.newSaleName, "fromDate" : vm.newSaleStartDate, "toDate" : vm.newSaleEndDate,
    				"discount" : vm.newSaleDiscount, "categories" : categories};
    		
    		$http.post("/api/manager/addSale", request).then(function(response) {
            	alert("saved");
            	vm.getSales();
            });
    	}
    	
    	function getSales() {
    		$http.get("/api/manager/getSales").then(function(response) {
    			for(i = 0; i < response.data.length; i++) {
    				response.data[i]["fromDate"] = new Date(response.data[i]["fromDate"]);
    				response.data[i]["toDate"] = new Date(response.data[i]["toDate"]);
    			}
        		vm.sales = response.data;
            });
    	}
    	
    	function saveSales() {
    		var request = vm.sales;
    		$http.post("/api/manager/saveSales", request).then(function(response) {
            	alert("saved");
            	vm.getSales();
            });
    	}
    }

})();