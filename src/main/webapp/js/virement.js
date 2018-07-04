function checkAmount(form) {
	
	let debiteurString = form.compteDebiter.value.split("##");
	let debiteurAccount = debiteurString[0];
	let debiteurSolde = parseFloat(debiteurString[1])+parseFloat(debiteurString[2]);
	let crediteurString = form.compteCrediter.value.split("##");
	let crediteurAccount = crediteurString[0];
	let amount = form.montant.value;
	if(crediteurAccount==debiteurAccount){
		alert("Virement refusé : Impossible d'effectuer un virement d'un compte vers lui-même")
		return false
	}
	if(debiteurSolde<amount){
		alert("Virement refusé : Le compte à debiter n'est pas assez approvisionné")
		return false
	}else{
		alert("Virement validé")
		return true;		
	}
	

};
(function() {

})();