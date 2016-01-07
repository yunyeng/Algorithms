function houseOfCards(floors){
	if(floors <= 0){
		return 0;
	}
	var cards = 7;
	var total = cards;
	if(floors == 1){
		return cards;
	}
	cards++;
	total += cards;
	for(var i=2; i<floors; i++){
		cards += 3;
		total += cards;	
	}		
	return total;
}

console.log(houseOfCards(1)); // 7
console.log(houseOfCards(12)); // 26