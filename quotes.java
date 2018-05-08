package licenta;

public class quotes {
	private static String[] quotes = {"Believe in yourself! Have faith in your abilities! Without a humble but reasonable confidence in your own powers you cannot be successful or happy.", "—Norman Vincent Peale,“If you can dream it, you can do it.” —Walt Disney","“Where there is a will, there is a way. If there is a chance in a million that you can do something, anything, to keep what you want from ending, do it. Pry the door open or, if need be, wedge your foot in that door and keep it open.” —Pauline Kael","Do something today that your future self will thank you for","“Press forward. Do not stop, do not linger in your journey, but strive for the mark set before you.” —George Whitefield","“Don’t watch the clock; do what it does. Keep going.” —Sam Levenson"};
	private static String[] hQuotes ={"Drinking water is like taking a shower on the inside of your body" , "Take care of your body it's the only place you have to live in!" , "Being healthy and fit isn't a fad or a trend instead, it's a lifestyle!"};
			
	public static String returnQuotes(){
		String quote=quotes[(int) Math.ceil(Math.random() * quotes.length-1)];
		return quote;
	}
	
	public static String returnQuotesAndPhoto(){
		String quote=hQuotes[(int) Math.ceil(Math.random() * hQuotes.length-1)];
		return quote;
	}
}
