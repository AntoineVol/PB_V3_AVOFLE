

(function() {
	function checkAmount(form){
		let debiteurString = form.debiter;
		let debiteurAccount = debiteurString.split("##");
		let crediteurString = form.crediter;
		let crediteurAccount = crediteurString.split("##");
		let amount= form.montant;
		
		
	    console.log(amount);
	    return  true;
	};
})();