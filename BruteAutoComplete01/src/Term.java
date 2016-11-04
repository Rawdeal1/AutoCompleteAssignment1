/*
 * This class is the object term
 */
public class Term {
double weight;
String word;
public Term(double weight, String word){
	setWeight(weight);
	setWord(word);
}
@Override
public String toString() {
	return "StoreWord [weight=" + weight + ", word=" + word + "]";
}
public double getWeight() {
	return weight;
}
public void setWeight(double weight) {
	if(weight > 0)
		this.weight = weight;
	else
		throw new IllegalArgumentException();
}
public String getWord() {
	return word;
}
public void setWord(String word) {
	if(word != null)
		this.word = word;
	else
		throw new IllegalArgumentException();
}

}
