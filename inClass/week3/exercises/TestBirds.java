public class TestBirds {
    public static void main(String[] args) {
	FemaleBird b1 = new FemaleBird();
	MaleBird b2 = new MaleBird();

	//set some stuff
	b1.altitude(2000);
	b1.sing(4);
	b1.feed("vegetables");

	b2.altitude(1000);
	b2.sing(2);
	b2.feed("worms");

	System.out.println("Female bird statistics:"
			   + "\n\tFlight Altitude (ft): " + b1.altitude()
			   + "\n\tSong Pitch: " + b1.sing()
			   + "\n\tPreferred Food: " + b1.feed());

	System.out.println("Male bird statistics:"
			   + "\n\tFlight Altitude (ft): " + b2.altitude()
			   + "\n\tSong Pitch: " + b2.sing()
			   + "\n\tPreferred Food: " + b2.feed());
    }
}