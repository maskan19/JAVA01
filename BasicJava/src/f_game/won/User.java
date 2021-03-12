package f_game.won;

public class User {
	int Bet; // 나의 배팅 금액
	int Money; // 내가 가지고 있는 돈
	int Sum; // 받은 카드의 총 합
	Card[] card;

	User() {
		this.Bet = 0;
		this.Money = 100000;
		this.Sum = 0;
		this.card = new Card[10];
	}
	void getcard(Card c){
		for(int i = 0; i<card.length; i ++){
			if(card[i]==null){
				card[i] = c;
				break;
			} else{System.out.println("더이상 카드를 얻을 수 없습니다.");}
	}
	}
	void Betting(User u, User d) {
		
		u.Money -= u.Bet;
		d.Money -= d.Bet;
	}

	void Win(User u, User d) {
		u.Money += u.Bet + d.Bet;
		System.out.println("Win!");
		System.out.println("배팅액을 얻습니다.");
		System.out.println("현재 남은 금액: " + u.Money + "원" + "\t" + "딜러 남은 금액: "
				+ d.Money + "원");
	}

	void Lose(User u, User d) {
		d.Money += u.Bet + d.Bet;
		System.out.println("Lose!");
		System.out.println("현재 남은 금액: " + u.Money + "원" + "\t" + "딜러 남은 금액: "
				+ d.Money + "원");
	}

	void Draw(User u, User d) {
		u.Money +=u.Bet;
		d.Money +=d.Bet;
		System.out.println("Draw!");
		System.out.println("배팅액을 회수합니다.");
		System.out.println("현재 남은 금액: " + u.Money + "원" + "\t" + "딜러 남은 금액: "
				+ d.Money + "원");
	}

	void Die(User u, User d) {
		u.Money +=u.Bet;
		System.out.println("현재 남은 금액: " + u.Money + "원" + "\t" + "딜러 남은 금액: "
				+ d.Money + "원");
	}
}
