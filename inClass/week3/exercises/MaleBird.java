public class MaleBird implements Bird {
    int alt;
    int pitch;
    String food;

    public int altitude(int alt) {
	this.alt = alt;
	return alt;
    }

    public int sing(int pitch) {
	this.pitch = pitch;
	return pitch;
    }

    public String feed(String food) {
	this.food = food;
	return food;
    }

    public int altitude() {
	return alt;
    }

    public int sing() {
	return pitch;
    }

    public String feed() {
	return food;
    }
}