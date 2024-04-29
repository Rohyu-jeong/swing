package ex2_enum;

public enum Transportation {
	BUS(100){
		@Override
		int totalFare(int distance) {
			// TODO Auto-generated method stub
			return distance * fare;
		}
	},
	TRAIN(150) {
		@Override
		int totalFare(int distance) {
			// TODO Auto-generated method stub
			return distance * fare;
		}
	},
	SHIP(200) {
		@Override
		int totalFare(int distance) {
			// TODO Auto-generated method stub
			return distance * fare;
		}
	},
	AIRPLANE(250) {
		@Override
		int totalFare(int distance) {
			// TODO Auto-generated method stub
			return distance * fare;
		}
	};
	
	protected final int fare;
	
	private Transportation(int fare) {
		this.fare = fare;
	}
	
	// 추상메서드
	abstract int totalFare(int distance);
}
