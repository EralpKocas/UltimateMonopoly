package domain.card;

import domain.Player;

public abstract class CommunityChestCard extends Card {

	public CommunityChestCard(String n, String d) {
		super(n, d);
		// TODO Auto-generated constructor stub
		
	}

	public abstract void useSpecificCard();

	@Override
	public void useCard(Player p, String s) {
		// TODO Auto-generated method stub
		
	}

}
