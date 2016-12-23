void shuffleCards(int[] cards){
	for (int i = 0; i < cards.length; i++){
		int randCardIndex = Math.random(0, i);
		// swap card at i and card at randCardIndex
		card[i] = card[i] ^ card[randCardIndex];
		card[randCardIndex] = card[i] ^ card[randCardIndex];
		card[i] = card[i] ^ card[randCardIndex];
	}
}


